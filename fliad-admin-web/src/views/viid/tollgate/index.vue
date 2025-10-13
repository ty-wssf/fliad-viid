<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="卡口名称" name="Name">
						<a-input v-model:value="searchFormState.Name" placeholder="请输入卡口名称" />
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
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidTollgateAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<xn-batch-button
						v-if="hasPerm('viidTollgateBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchViidTollgate"
					/>
				</a-space>
			</template>
			<template #bodyCell="{ column, record }">
				<template v-if="column.dataIndex === 'Status'">
					<a-tag :color="record.Status === 1 ? 'green' : (record.Status === 2 ? 'red' : 'orange')">
						{{ record.Status === 1 ? '正常' : (record.Status === 2 ? '停用' : '其他') }}
					</a-tag>
				</template>
				<template v-if="column.dataIndex === 'TollgateUsage'">
					{{ record.TollgateUsage === 80 ? '治安卡口' : (record.TollgateUsage === 81 ? '交通卡口' : '其他') }}
				</template>
				<template v-if="column.dataIndex === 'action'">
					<a @click="formRef.onOpen(record)" v-if="hasPerm('viidTollgateEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['viidTollgateEdit', 'viidTollgateDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteViidTollgate(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('viidTollgateDelete')">删除</a-button>
					</a-popconfirm>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />
</template>

<script setup name="viidTollgate">
	import { message } from 'ant-design-vue'
	import Form from './form.vue'
	import viidTollgateApi from '@/api/viid/viidTollgateApi'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const columns = [
		{
			title: '卡口ID',
			dataIndex: 'TollgateID'
		},
		{
			title: '卡口名称',
			dataIndex: 'Name'
		},
		{
			title: '经度',
			dataIndex: 'Longitude'
		},
		{
			title: '纬度',
			dataIndex: 'Latitude'
		},
		{
			title: '行政区划代码',
			dataIndex: 'PlaceCode'
		},
		{
			title: '位置',
			dataIndex: 'Place'
		},
		{
			title: '卡口状态',
			dataIndex: 'Status'
		},
		{
			title: '卡口类型',
			dataIndex: 'TollgateCat'
		},
		{
			title: '卡口用途',
			dataIndex: 'TollgateUsage'
		},
		{
			title: '车道数',
			dataIndex: 'LaneNum'
		}
	]
	// 操作栏通过权限判断是否显示
	if (hasPerm(['viidTollgateEdit', 'viidTollgateDelete'])) {
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
		return viidTollgateApi.viidTollgatePage(Object.assign(parameter, searchFormParam)).then((data) => {
			return data
		})
	}
	// 删除
	const deleteViidTollgate = (record) => {
		let params = [
			{
				ID: record.ID
			}
		]
		viidTollgateApi.viidTollgateDelete(params).then(() => {
			table.value.refresh(true)
		})
	}
	// 批量删除
	const deleteBatchViidTollgate = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				ID: m
			}
		})
		viidTollgateApi.viidTollgateDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}
</script>
