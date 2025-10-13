<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="设备名称" name="name">
						<a-input v-model:value="searchFormState.name" placeholder="请输入设备名称" />
					</a-form-item>
				</a-col>
				<a-col :span="6">
					<a-form-item label="IP地址" name="ipAddr">
						<a-input v-model:value="searchFormState.ipAddr" placeholder="请输入IP地址" />
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
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidHikvisionDefenseAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<xn-batch-button
						v-if="hasPerm('viidHikvisionDefenseBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchViidHikvisionDefense"
					/>
				</a-space>
			</template>
			<template #bodyCell="{ column, record }">
				<template v-if="column.dataIndex === 'enableStatus'">
					<a-tag :color="record.enableStatus === 1 ? 'green' : 'red'">
						{{ record.enableStatus === 1 ? '启用' : '禁用' }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'onlineStatus'">
					<a-tag :color="record.onlineStatus === 1 ? 'green' : 'red'">
						{{ record.onlineStatus === 1 ? '在线' : '离线' }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'action'">
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidHikvisionDefenseEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidHikvisionDefenseEdit', 'viidHikvisionDefenseDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidHikvisionDefense(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidHikvisionDefenseDelete')">删除</a-button>
					</a-popconfirm>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
</template>

<script setup name="viidHikvisionDefense">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import viidHikvisionDefenseApi from '@/api/viid/viidHikvisionDefenseApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const columns = [
		{
			title: '设备名称',
			dataIndex: 'name'
		},
		{
			title: 'IP地址',
			dataIndex: 'ipAddr'
		},
		{
			title: '端口',
			dataIndex: 'port'
		},
		{
			title: '用户名',
			dataIndex: 'username'
		},
		{
			title: '启用状态',
			dataIndex: 'enableStatus'
		},
		{
			title: '在线状态',
			dataIndex: 'onlineStatus'
		},
		{
			title: '创建时间',
			dataIndex: 'createTime'
		}
	]
	// 操作栏通过权限判断是否显示
	if (hasPerm(['viidHikvisionDefenseEdit', 'viidHikvisionDefenseDelete'])) {
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
		return viidHikvisionDefenseApi.viidHikvisionDefensePage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}

	// 删除海康布防
	const deleteViidHikvisionDefense = (record) => {
		const param = {
			id: record.id
		}
		viidHikvisionDefenseApi.viidHikvisionDefenseDelete([param]).then(() => {
			table.value.refresh(true)
			message.success('删除成功')
		})
	}

	// 批量删除海康布防
	const deleteBatchViidHikvisionDefense = (ids) => {
		const param = ids.map((id) => {
			return { id: id }
		})
		viidHikvisionDefenseApi.viidHikvisionDefenseDelete(param).then(() => {
			table.value.refresh(true)
			message.success('删除成功')
		})
	}
</script>