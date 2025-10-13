<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="通知标识" name="NotificationID">
						<a-input v-model:value="searchFormState.NotificationID" placeholder="请输入通知标识" />
					</a-form-item>
				</a-col>
				<a-col :span="6">
					<a-form-item label="订阅标识" name="SubscribeID">
						<a-input v-model:value="searchFormState.SubscribeID" placeholder="请输入订阅标识" />
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
			:row-key="(record) => record.ID"
			:tool-config="toolConfig"
			:row-selection="options.rowSelection"
		>
			<template #operator class="table-operator">
				<a-space>
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidNotificationUpAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<xn-batch-button
						v-if="hasPerm('viidNotificationUpBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchViidSubscribeNotifications"
					/>
				</a-space>
			</template>
			<template #bodyCell="{ column, record }">
				<template v-if="column.dataIndex === 'action'">
					<a @click="showDetail(record)">详情</a>
					<a-divider type="vertical" v-if="hasPerm(['viidNotificationUpEdit', 'viidNotificationUpDelete'], 'and')" />
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidNotificationUpEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidNotificationUpEdit', 'viidNotificationUpDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidSubscribeNotifications(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidNotificationUpDelete')">删除</a-button>
					</a-popconfirm>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
	<Detail ref="detailRef" />
</template>

<script setup name="viidNotificationUp">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import Detail from './detail.vue'
	import viidNotificationApi from '@/api/viid/viidNotificationApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const detailRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const columns = [
		{
			title: '通知标识',
			dataIndex: 'NotificationID'
		},
		{
			title: '订阅标识',
			dataIndex: 'SubscribeID'
		},
		{
			title: '订阅标题',
			dataIndex: 'Title'
		},
		{
			title: '触发时间',
			dataIndex: 'TriggerTime'
		},
		{
			title: '请求耗时(ms)',
			dataIndex: 'RequestCost'
		},
		{
			title: '创建时间',
			dataIndex: 'CreateTime'
		}
	]
	// 操作栏通过权限判断是否显示
	if (hasPerm(['viidNotificationUpDetail', 'viidNotificationUpEdit', 'viidNotificationUpDelete'])) {
		columns.push({
			title: '操作',
			dataIndex: 'action',
			align: 'center',
			width: '200px'
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
		return viidNotificationApi.viidSubscribeNotificationsPage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	// 删除
	const deleteViidSubscribeNotifications = (record) => {
		let params = [
			{
				ID: record.ID
			}
		]
		viidNotificationApi.viidSubscribeNotificationsDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 批量删除
	const deleteBatchViidSubscribeNotifications = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				ID: m
			}
		})
		viidNotificationApi.viidSubscribeNotificationsDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}
	// 显示详情
	const showDetail = (record) => {
		detailRef.value.onOpen(record)
	}
</script>