<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="订阅标题" name="Title">
						<a-input v-model:value="searchFormState.Title" placeholder="请输入订阅标题" />
					</a-form-item>
				</a-col>
				<a-col :span="6">
					<a-form-item label="订阅目标节点" name="SubscriberRecoverOrgid">
						<a-input v-model:value="searchFormState.SubscriberRecoverOrgid" placeholder="请选择订阅目标节点" />
					</a-form-item>
				</a-col>
				<a-col :span="6">
					<a-button type="primary" @click="table.refresh(true)">查询</a-button>
					<a-button style="margin: 0 8px" @click="() => searchFormRef.resetFields()">重置</a-button>
				</a-col>
			</a-row>
		</a-form>
		<s-table
			ref="table"
			:columns="columns"
			:data="loadData"
			:alert="options.alert.show"
			bordered
			:row-key="(record) => record.subscribeid"
			:tool-config="toolConfig"
			:row-selection="options.rowSelection"
		>
			<template #operator class="table-operator">
				<a-space>
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidSubscribeUpAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<xn-batch-button
						v-if="hasPerm('viidSubscribeBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchViidSubscribe"
					/>
				</a-space>
			</template>
			<template #bodyCell="{ column, record }">
				<template v-if="column.dataIndex === 'SubscribeDetail'">
					<a-tag v-for="textValue in JSON.parse(record.SubscribeDetail)" :key="textValue" color="processing">
						{{ $TOOL.dictTypeData('VIID_Subscribe_Detail_Type', textValue) }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'SubscribeStatus'">
					{{ $TOOL.dictTypeData('VIID_Subscribe_Status', record.SubscribeStatus) }}
				</template>
				<template v-if="column.dataIndex === 'action'">
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidSubscribeUpEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidSubscribeUpEdit', 'viidSubscribeUpDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidSubscribe(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidSubscribeUpDelete')">删除</a-button>
					</a-popconfirm>
					<a-divider
						type="vertical"
					/>
					<a-dropdown>
						<a class="ant-dropdown-link">
							更多
							<DownOutlined />
						</a>
						<template #overlay>
							<a-menu>
								<a-menu-item v-if="record.SubscribeStatus === '0'">
									<a @click="openCancelForm(record)">取消订阅</a>
								</a-menu-item>
								<a-menu-item>
									<a @click="subscribeSend(record)" v-if="record.SubscribeStatus === '0'">重载订阅</a>
									<a @click="subscribeSend(record)" v-if="record.SubscribeStatus === '1'">订阅</a>
									<a @click="subscribeSend(record)" v-if="record.SubscribeStatus === '9'">订阅</a>
								</a-menu-item>
							</a-menu>
						</template>
					</a-dropdown>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />

	<!-- 取消订阅表单 -->
	<a-modal
		v-model:visible="cancelForm.visible"
		title="取消订阅"
		:confirm-loading="cancelForm.submitLoading"
		@ok="handleCancelSubmit"
		@cancel="handleCancelCancel"
	>
		<a-form ref="cancelFormRef" :model="cancelForm.formData" :rules="cancelForm.formRules" layout="vertical">
			<a-form-item label="订阅编号：" name="SubscribeID">
				<a-input v-model:value="cancelForm.formData.SubscribeID" readOnly />
			</a-form-item>
			<a-form-item label="订阅取消单位：" name="SubscribeCancelOrg">
				<a-input v-model:value="cancelForm.formData.SubscribeCancelOrg" placeholder="请输入订阅取消单位" />
			</a-form-item>
			<a-form-item label="订阅取消人：" name="SubscribeCancelPerson">
				<a-input v-model:value="cancelForm.formData.SubscribeCancelPerson" placeholder="请输入订阅取消人" />
			</a-form-item>
			<a-form-item label="取消原因：" name="CancelReason">
				<a-textarea v-model:value="cancelForm.formData.CancelReason" placeholder="请输入取消原因" :rows="3" />
			</a-form-item>
		</a-form>
	</a-modal>
</template>

<script setup name="subscribeUp">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import viidSubscribeApi from '@/api/viid/viidSubscribeApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const cancelFormRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const columns = [
		{
			title: '订阅编号',
			dataIndex: 'SubscribeID'
		},
		{
			title: '订阅标题',
			dataIndex: 'Title'
		},
		{
			title: '订阅类别',
			dataIndex: 'SubscribeDetail'
		},
		{
			title: '开始时间',
			dataIndex: 'BeginTime'
		},
		{
			title: '结束时间',
			dataIndex: 'EndTime'
		},
		{
			title: '订阅目标节点',
			dataIndex: 'SubscriberRecoverOrgname'
		},
		{
			title: '订阅状态',
			dataIndex: 'SubscribeStatus'
		}
	]
	// 操作栏通过权限判断是否显示
	if (hasPerm(['viidSubscribeUpEdit', 'viidSubscribeUpDelete'])) {
		columns.push({
			title: '操作',
			dataIndex: 'action',
			align: 'center',
			width: '220px'
		})
	}
	let selectedRowKeys = ref([])
	// 列表选择配置
	const options = {
		alert: {
			show: false,
			clear: () => {
				selectedRowKeys = ref([])
			}
		},
		rowSelection: {
			onChange: (selectedRowKey, selectedRows) => {
				selectedRowKeys.value = selectedRowKey
			}
		}
	}
	const loadData = (parameter) => {
		const searchFormParam = JSON.parse(JSON.stringify(searchFormState))
		return viidSubscribeApi.viidSubscribePage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	// 删除
	const deleteViidSubscribe = (record) => {
		let params = [
			{
				SubscribeID: record.SubscribeID
			}
		]
		viidSubscribeApi.viidSubscribeDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 批量删除
	const deleteBatchViidSubscribe = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				SubscribeID: m
			}
		})
		viidSubscribeApi.viidSubscribeDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}
	// 向上级发送订阅请求
	const subscribeSend = (record) => {
		let params = {
				SubscribeID: record.SubscribeID
		}

		viidSubscribeApi.subscribeSend(params).then(() => {
			message.success("操作成功")
			table.value.refresh(true)
		})
	}

	// 取消订阅表单数据
	const cancelForm = reactive({
		visible: false,
		submitLoading: false,
		formData: {},
		formRules: {
			SubscribeCancelOrg: [{ required: true, message: '请输入订阅取消单位', trigger: 'blur' }],
			SubscribeCancelPerson: [{ required: true, message: '请输入订阅取消人', trigger: 'blur' }]
		}
	})

	// 打开取消订阅表单
	const openCancelForm = (record) => {
		cancelForm.visible = true
		cancelForm.formData = {
			SubscribeID: record.SubscribeID,
			SubscribeCancelOrg: '',
			SubscribeCancelPerson: '',
			CancelTime: null,
			CancelReason: ''
		}
	}

	// 处理取消订阅提交
	const handleCancelSubmit = () => {
		cancelFormRef.value.validate().then(() => {
			cancelForm.submitLoading = true
			viidSubscribeApi.subscribeCancel(cancelForm.formData)
				.then(() => {
					message.success("取消订阅成功")
					cancelForm.visible = false
					table.value.refresh(true)
				})
				.finally(() => {
					cancelForm.submitLoading = false
				})
		})
	}

	// 处理取消订阅取消
	const handleCancelCancel = () => {
		cancelFormRef.value.resetFields()
		cancelForm.visible = false
	}

	// 向上级发送取消订阅请求
	const subscribeCancel = (record) => {
		let recordData = cloneDeep(record)
		viidSubscribeApi.subscribeCancel(recordData).then(() => {
			message.success("操作成功")
			table.value.refresh(true)
		})
	}
</script>