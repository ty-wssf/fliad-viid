<template>
	<a-card :bordered="false">
		<a-tabs v-model:activeKey="activeKey" @change="handleTabChange">
			<a-tab-pane key="datasource" tab="数据源">
				<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
					<a-row :gutter="24">
						<a-col :span="6">
							<a-form-item label="标题" name="title">
								<a-input v-model:value="searchFormState.title" placeholder="请输入标题" />
							</a-form-item>
						</a-col>
						<a-col :span="6">
							<a-form-item label="类型" name="type">
								<a-select v-model:value="searchFormState.type" placeholder="请选择类型" allow-clear>
									<a-select-option v-for="item in datasourceTypeOptions" :key="item.value" :value="item.value">{{ item.label }}</a-select-option>
								</a-select>
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
							<a-button type="primary" @click="formRef.onOpen(undefined, false)" v-if="hasPerm('viidDatasourceAdd')">
								<template #icon><plus-outlined /></template>
								新增
							</a-button>
							<a-button @click="loadTemplates" v-if="hasPerm('viidDatasourceAdd')">
								<template #icon><copy-outlined /></template>
								从模板安装
							</a-button>
							<xn-batch-button
								v-if="hasPerm('viidDatasourceBatchDelete')"
								buttonName="批量删除"
								icon="DeleteOutlined"
								:selectedRowKeys="selectedRowKeys"
								@batchCallBack="deleteBatchViidDatasource"
							/>
						</a-space>
					</template>
					<template #bodyCell="{ column, record }">
						<template v-if="column.dataIndex === 'subscribeDetail'">
							<a-tag color="processing">
								{{ $TOOL.dictTypeData('RESOURCE_Subscribe_Detail_Type', record.subscribeDetail) }}
							</a-tag>
						</template>
						<template v-if="column.dataIndex === 'type'">
							{{ getTypeLabel(record.type) }}
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
							<a @click="exportDataInit(record)">导出</a>
							<a-divider type="vertical" />
							<a @click="copyViidDatasource(record)" v-if="hasPerm('viidDatasourceAdd')">复制</a>
							<a-divider type="vertical" v-if="hasPerm(['viidDatasourceAdd', 'viidDatasourceEdit'], 'and')" />
							<a @click="convertToTemplate(record)" v-if="hasPerm('viidDatasourceEdit')">转为模板</a>
							<a-divider type="vertical" v-if="hasPerm(['viidDatasourceAdd', 'viidDatasourceEdit'], 'and')" />
							<a @click="formRef.onOpen(record, false)" v-if="hasPerm('viidDatasourceEdit')">编辑</a>
							<a-divider type="vertical" v-if="hasPerm(['viidDatasourceEdit', 'viidDatasourceDelete'], 'and')" />
							<a-popconfirm title="确定要删除吗？" @confirm="deleteViidDatasource(record)">
								<a-button type="link" danger size="small" v-if="hasPerm('viidDatasourceDelete')">删除</a-button>
							</a-popconfirm>
						</template>
					</template>
				</s-table>
			</a-tab-pane>

			<a-tab-pane key="template" tab="模板" v-if="hasPerm('viidDatasourceAdd')">
				<a-alert message="以下为系统预置模板，可以点击“安装”按钮将其添加为普通数据源" type="info" show-icon style="margin-bottom: 16px;" />
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
							<a-button type="primary" @click="formRef.onOpen(undefined, true)" v-if="hasPerm('viidDatasourceAdd')">
								<template #icon><plus-outlined /></template>
								新增模板
							</a-button>
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
							<a-tag color="processing">
								{{ $TOOL.dictTypeData('RESOURCE_Subscribe_Detail_Type', record.subscribeDetail) }}
							</a-tag>
						</template>
						<template v-if="column.dataIndex === 'type'">
							{{ getTypeLabel(record.type) }}
						</template>
						<template v-if="column.dataIndex === 'action'">
							<a @click="exportDataInit(record)">导出</a>
							<a-divider type="vertical" />
							<a @click="copyTemplate(record)" v-if="hasPerm('viidDatasourceAdd')">复制</a>
							<a-divider type="vertical" v-if="hasPerm(['viidDatasourceAdd', 'viidDatasourceEdit'], 'and')" />
							<a @click="formRef.onOpen(record, true)" v-if="hasPerm('viidDatasourceEdit')">编辑</a>
							<a-divider type="vertical" v-if="hasPerm(['viidDatasourceEdit', 'viidDatasourceDelete'], 'and')" />
							<a-popconfirm title="确定要删除吗？" @confirm="deleteTemplate(record)">
								<a-button type="link" danger size="small" v-if="hasPerm('viidDatasourceDelete')">删除</a-button>
							</a-popconfirm>
							<a-divider type="vertical" />
							<a @click="installTemplate(record)">安装</a>
						</template>
					</template>
				</s-table>
			</a-tab-pane>
		</a-tabs>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
</template>

<script setup name="datasource">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import viidDatasourceApi from '@/api/resource/datasourceApi'
	import tool from '@/utils/tool'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const templateTable = ref()
	const formRef = ref()
	const designDatasourceRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const loading = ref(false)
	const activeKey = ref('datasource')
	const datasourceTypeOptions = ref([
		{ label: 'RabbitMQ', value: 'rabbitmq' },
		{ label: '定时任务', value: 'cron' }
	])

	// 添加一个方法来获取type的显示标签
	const getTypeLabel = (typeValue) => {
		const typeOption = datasourceTypeOptions.value.find(option => option.value === typeValue)
		return typeOption ? typeOption.label : typeValue
	}

	onMounted(() => {
	})

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
			title: '类型',
			dataIndex: 'type'
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
	if (hasPerm(['viidDatasourceEdit', 'viidDatasourceDelete'])) {
		columns.push({
			title: '操作',
			dataIndex: 'action',
			align: 'center',
			width: '300px'
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
			title: '类型',
			dataIndex: 'type'
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
			width: '250px'
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
		return viidDatasourceApi.datasourcePage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}

	const loadTemplateData = (parameter) => {
		return viidDatasourceApi.datasourceTemplateList().then((data) => {
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

	// 删除数据源
	const deleteViidDatasource = (record) => {
		let params = [
			{
				id: record.id
			}
		]
		viidDatasourceApi.datasourceDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 批量删除数据源
	const deleteBatchViidDatasource = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				id: m
			}
		})
		viidDatasourceApi.datasourceDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}
	// 修改状态
	const editStatus = (record) => {
		loading.value = true
		if (record.status === 'ENABLE') {
			viidDatasourceApi
				.disableDatasource(record)
				.then(() => {
					table.value.refresh(true)
				})
				.finally(() => {
					loading.value = false
				})
		} else {
			viidDatasourceApi
				.enableDatasource(record)
				.then(() => {
					table.value.refresh(true)
				})
				.finally(() => {
					loading.value = false
				})
		}
	}

	// 导出为data-init.xml格式
	const exportDataInit = (record) => {
		viidDatasourceApi.datasourceExportDataInit({id: record.id}).then((res) => {
			// 创建Blob对象
			const blob = new Blob([res], { type: 'application/xml' });
			// 创建下载链接
			const url = window.URL.createObjectURL(blob);
			const link = document.createElement('a');
			link.href = url;
			link.download = `datasource_${record.id}_data-init.xml`;
			link.click();
			// 清理URL对象
			window.URL.revokeObjectURL(url);
		});
	}

	// 复制数据源
	const copyViidDatasource = (record) => {
		viidDatasourceApi.datasourceCopy({id: record.id}).then(() => {
			table.value.refresh(true)
		})
	}

	// 将数据源转换为模板
	const convertToTemplate = (record) => {
		viidDatasourceApi.datasourceConvertToTemplate({id: record.id}).then(() => {
			message.success('数据源已转换为模板');
			table.value.refresh(true);
			// 如果当前在模板tab，则刷新模板列表
			if (activeKey.value === 'template') {
				templateTable.value.refresh(true);
			}
		})
	}

	// 复制模板
	const copyTemplate = (record) => {
		viidDatasourceApi.datasourceCopy({id: record.id}).then(() => {
			templateTable.value.refresh(true)
		})
	}

	// 删除模板
	const deleteTemplate = (record) => {
		let params = [
			{
				id: record.id
			}
		]
		viidDatasourceApi.datasourceDelete(params).then(() => {
			templateTable.value.refresh(true)
		})
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
		viidDatasourceApi.datasourceInstallTemplate({id: record.id}).then(() => {
			message.success('安装成功')
			if (activeKey.value === 'datasource') {
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
			return viidDatasourceApi.datasourceInstallTemplate({id: id})
		})
		Promise.all(promises).then(() => {
			message.success('批量安装成功')
			templateTable.value.clearRefreshSelected()
			if (activeKey.value === 'datasource') {
				table.value.refresh(true)
			}
		})
	}

	// Tab切换处理
	const handleTabChange = (key) => {
		if (key === 'datasource') {
			table.value.refresh(true)
		} else if (key === 'template') {
			templateTable.value.refresh(true)
		}
	}
</script>
