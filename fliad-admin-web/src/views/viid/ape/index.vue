<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="设备名称" name="Name">
						<a-input v-model:value="searchFormState.Name" placeholder="请输入设备名称" />
					</a-form-item>
				</a-col>
				<a-col :span="6">
					<a-form-item label="IP地址" name="IPAddr">
						<a-input v-model:value="searchFormState.IPAddr" placeholder="请输入IP地址" />
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
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidApeAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<xn-batch-button
						v-if="hasPerm('viidApeBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchViidApe"
					/>
				</a-space>
			</template>
			<template #bodyCell="{ column, record }">
				<template v-if="column.dataIndex === 'IsOnline'">
					<a-tag :color="record.IsOnline === 1 ? 'green' : 'red'">
						{{ record.IsOnline === 1 ? '在线' : '离线' }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'action'">
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidApeEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidApeEdit', 'viidApeDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidApe(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidApeDelete')">删除</a-button>
					</a-popconfirm>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
</template>

<script setup name="viidApe">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import viidApeApi from '@/api/viid/viidApeApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const columns = [
		{
			title: '设备唯一标识',
			dataIndex: 'ApeID'
		},
		{
			title: '设备名称',
			dataIndex: 'Name'
		},
		{
			title: '设备型号',
			dataIndex: 'Model'
		},
		{
			title: 'IP地址',
			dataIndex: 'IPAddr'
		},
		{
			title: '端口',
			dataIndex: 'Port'
		},
		{
			title: '位置',
			dataIndex: 'Place'
		},
		{
			title: '在线状态',
			dataIndex: 'IsOnline'
		}
	]
	// 操作栏通过权限判断是否显示
	if (hasPerm(['viidApeEdit', 'viidApeDelete'])) {
		columns.push({
			title: '操作',
			dataIndex: 'action',
			align: 'center',
			width: '150px'
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
		return viidApeApi.viidApePage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	// 删除
	const deleteViidApe = (record) => {
		let params = [
			{
				ID: record.ID
			}
		]
		viidApeApi.viidApeDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 批量删除
	const deleteBatchViidApe = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				ID: m
			}
		})
		viidApeApi.viidApeDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}
</script>
