<template>
	<a-card :bordered="false">
		<a-tabs v-model:activeKey="activeKey" @change="handleTabChange">
			<a-tab-pane key="workflow" tab="工作流">
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
							<a-button @click="loadTemplates" v-if="hasPerm('viidWorkflowAdd')">
								<template #icon><copy-outlined /></template>
								从模板安装
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
						<template v-if="column.dataIndex === 'isTemplate'">
							<a-tag :color="record.isTemplate ? 'blue' : 'green'">
								{{ record.isTemplate ? '模板' : '普通' }}
							</a-tag>
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
			</a-tab-pane>
			
			<a-tab-pane key="template" tab="模板" v-if="hasPerm('viidWorkflowAdd')">
				<a-alert message="以下为系统预置模板，可以点击“安装”按钮将其添加为普通工作流" type="info" show-icon style="margin-bottom: 16px;" />
				<s-table
					ref="templateTable"
					:columns="templateColumns"
					:data="loadTemplateData"
					:alert="templateOptions.alert.show"
					bordered
					:row-key="(record) => record.id"
					:tool-config="toolConfig"
					:row-selection="templateOptions.rowSelection"
				>
					<template #operator class="table-operator">
						<a-space>
							<xn-batch-button
								buttonName="批量安装"
								icon="DownloadOutlined"
								:selectedRowKeys="selectedTemplateRowKeys"
								@batchCallBack="installBatchTemplate"
							/>
						</a-space>
					</template>
					<template #bodyCell="{ column, record }">
						<template v-if="column.dataIndex === 'subscribeDetail'">
							<a-tag v-for="textValue in JSON.parse(record.subscribeDetail)" :key="textValue" color="processing">
								{{ $TOOL.dictTypeData('VIID_Subscribe_Detail_Type', textValue) }}
							</a-tag>
						</template>
						<template v-if="column.dataIndex === 'action'">
							<a @click="installTemplate(record)">安装</a>
						</template>
					</template>
				</s-table>
			</a-tab-pane>
		</a-tabs>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
	<design-workflow ref="designWorkflowRef" @successful="table.refresh(true)" />
</template>

<script setup name="workflow">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import DesignWorkflow from './designWorkflow.vue'
	import viidWorkflowApi from '@/api/resource/viidWorkflowApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const templateTable = ref()
	const formRef = ref()
	const designWorkflowRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const loading = ref(false)
	const activeKey = ref('workflow')
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
			title: '类型',
			dataIndex: 'isTemplate'
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
	
	const templateColumns = [
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
			title: '备注',
			dataIndex: 'remark',
			ellipsis: true
		},
		{
			title: '操作',
			dataIndex: 'action',
			align: 'center',
			width: '100px'
		}
	]
	
	let selectedRowKeys = ref([])
	let selectedTemplateRowKeys = ref([])
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
	
	const templateOptions = {
		alert: {
			show: false,
			clear: () => {
				selectedTemplateRowKeys = ref([])
			}
		},
		rowSelection: {
			onChange: (selectedRowKey, selectedRows) => {
				selectedTemplateRowKeys.value = selectedRowKey
			}
		}
	}
	
	const loadData = (parameter) => {
		const searchFormParam = JSON.parse(JSON.stringify(searchFormState))
		return viidWorkflowApi.viidWorkflowPage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	
	const loadTemplateData = (parameter) => {
		return viidWorkflowApi.viidWorkflowTemplateList().then((data) => {
			// 模拟分页数据
			const pageSize = parameter.size || 10
			const current = parameter.current || 1
			const start = (current - 1) * pageSize
			const end = start + pageSize
			return {
				total: data.length,
				records: data.slice(start, end),
				current: current,
				size: pageSize
			}
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
	
	// 加载模板
	const loadTemplates = () => {
		activeKey.value = 'template'
		nextTick(() => {
			templateTable.value.refresh(true)
		})
	}
	
	// 安装模板
	const installTemplate = (record) => {
		viidWorkflowApi.viidWorkflowInstallTemplate({id: record.id}).then(() => {
			message.success('安装成功')
			if (activeKey.value === 'workflow') {
				table.value.refresh(true)
			}
		})
	}
	
	// 批量安装模板
	const installBatchTemplate = () => {
		if (selectedTemplateRowKeys.value.length < 1) {
			message.warning('请选择一条或多条模板')
			return false
		}
		const promises = selectedTemplateRowKeys.value.map(id => {
			return viidWorkflowApi.viidWorkflowInstallTemplate({id: id})
		})
		Promise.all(promises).then(() => {
			message.success('批量安装成功')
			templateTable.value.clearRefreshSelected()
			if (activeKey.value === 'workflow') {
				table.value.refresh(true)
			}
		})
	}
	
	// Tab切换处理
	const handleTabChange = (key) => {
		if (key === 'workflow') {
			table.value.refresh(true)
		} else if (key === 'template') {
			templateTable.value.refresh(true)
		}
	}
</script>