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
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidDatasourceAdd')">
						<template #icon><plus-outlined /></template>
						新增
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
						{{ $TOOL.dictTypeData('VIID_Subscribe_Detail_Type', record.subscribeDetail) }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'type'">
					{{ getTypeLabel(record.type) }}
				</template>
				<template v-if="column.dataIndex === 'status'">
					<a-switch :loading="loading" :checked="record.status === 'ENABLE'" @change="editStatus(record)" />
				</template>
				<template v-if="column.dataIndex === 'action'">
					<a @click="copyViidDatasource(record)" v-if="hasPerm('viidDatasourceAdd')">复制</a>
					<a-divider type="vertical" v-if="hasPerm(['viidDatasourceAdd', 'viidDatasourceEdit'], 'and')" />
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidDatasourceEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidDatasourceEdit', 'viidDatasourceDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidDatasource(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidDatasourceDelete')">删除</a-button>
					</a-popconfirm>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
</template>

<script setup name="datasource">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import viidDatasourceApi from '@/api/viid/viidDatasourceApi'
	import tool from '@/utils/tool'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const designDatasourceRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const loading = ref(false)
	const datasourceTypeOptions = ref([
		{ label: 'RabbitMQ', value: 'rabbitmq' }
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
		return viidDatasourceApi.viidDatasourcePage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	// 删除
	const deleteViidDatasource = (record) => {
		let params = [
			{
				id: record.id
			}
		]
		viidDatasourceApi.viidDatasourceDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 批量删除
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
		viidDatasourceApi.viidDatasourceDelete(params).then(() => {
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
	
	// 复制数据源
	const copyViidDatasource = (record) => {
		viidDatasourceApi.viidDatasourceCopy({id: record.id}).then(() => {
			table.value.refresh(true)
		})
	}
</script>
