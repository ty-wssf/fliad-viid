<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="标题" name="title">
						<a-input v-model:value="searchFormState.title" placeholder="请输入标题" />
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
			:row-key="(record) => record.id"
			:tool-config="toolConfig"
			:row-selection="options.rowSelection"
		>
			<template #operator class="table-operator">
				<a-space>
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidWorkflowAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<xn-batch-button
						v-if="hasPerm('viidWorkflowBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchViidWorkflow"
					/>
				</a-space>
			</template>
			<template #bodyCell="{ column, record }">
				<template v-if="column.dataIndex === 'subscribeDetail'">
					<a-tag v-for="textValue in JSON.parse(record.subscribeDetail)" :key="textValue" color="processing">
						{{ $TOOL.dictTypeData('VIID_Subscribe_Detail_Type', textValue) }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'status'">
					<a-switch :loading="loading" :checked="record.status === 'ENABLE'" @change="editStatus(record)" />
				</template>
				<template v-if="column.dataIndex === 'action'">
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidWorkflowEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidWorkflowEdit', 'viidWorkflowDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidWorkflow(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidWorkflowDelete')">删除</a-button>
					</a-popconfirm>
					<a-divider type="vertical" />
					<a @click="copyViidWorkflow(record)">复制</a>
					<a-divider type="vertical" />
					<a @click="designWorkflowRef.onOpen(record)">设计工作流</a>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
	<design-workflow ref="designWorkflowRef" @successful="table.refresh(true)" />
</template>

<script setup name="workflow">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import DesignWorkflow from './designWorkflow.vue'
	import viidWorkflowApi from '@/api/viid/viidWorkflowApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const designWorkflowRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const loading = ref(false)
	const columns = [
		{
			title: 'ID',
			dataIndex: 'id'
		},
		{
			title: '标题',
			dataIndex: 'title'
		},
		{
			title: '订阅类别',
			dataIndex: 'subscribeDetail'
		},
		{
			title: '状态',
			dataIndex: 'status'
		},
		{
			title: '备注',
			dataIndex: 'remark',
			ellipsis: true
		}
	]
	// 操作栏通过权限判断是否显示
	if (hasPerm(['viidWorkflowEdit', 'viidWorkflowDelete'])) {
		columns.push({
			title: '操作',
			dataIndex: 'action',
			align: 'center',
			width: '240px'
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
		return viidWorkflowApi.viidWorkflowPage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	// 删除
	const deleteViidWorkflow = (record) => {
		let params = [
			{
				id: record.id
			}
		]
		viidWorkflowApi.viidWorkflowDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 复制
	const copyViidWorkflow = (record) => {
		let params = {
			id: record.id
		}
		viidWorkflowApi.viidWorkflowCopy(params).then(() => {
			table.value.refresh(true)
			message.success('复制成功')
		})
	}
	// 批量删除
	const deleteBatchViidWorkflow = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				id: m
			}
		})
		viidWorkflowApi.viidWorkflowDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}
	// 修改状态
	const editStatus = (record) => {
		loading.value = true
		if (record.status === 'ENABLE') {
			viidWorkflowApi
				.disableWorkflow(record)
				.then(() => {
					table.value.refresh(true)
				})
				.finally(() => {
					loading.value = false
				})
		} else {
			viidWorkflowApi
				.enableWorkflow(record)
				.then(() => {
					table.value.refresh(true)
				})
				.finally(() => {
					loading.value = false
				})
		}
	}
</script>
