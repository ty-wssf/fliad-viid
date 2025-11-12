<template>
	<a-card :bordered="false">
		<a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
			<a-row :gutter="24">
				<a-col :span="6">
					<a-form-item label="设备编号" name="deviceId">
						<a-input v-model:value="searchFormState.deviceId" placeholder="请输入设备编号" />
					</a-form-item>
				</a-col>
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
			:row-key="(record) => record.id_"
			:tool-config="toolConfig"
			:row-selection="options.rowSelection"
		>
			<template #operator class="table-operator">
				<a-space>
					<a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('dahuaDefenseAdd')">
						<template #icon><plus-outlined /></template>
						新增
					</a-button>
					<a-button type="primary" @click="exportTemplate">
						<template #icon><download-outlined /></template>
						导出模板
					</a-button>
					<a-button type="primary" @click="showImportModal">
						<template #icon><upload-outlined /></template>
						导入
					</a-button>
					<a-button type="primary" @click="exportData">
						<template #icon><download-outlined /></template>
						批量导出
					</a-button>
					<xn-batch-button
						v-if="hasPerm('dahuaDefenseBatchDelete')"
						buttonName="批量删除"
						icon="DeleteOutlined"
						:selectedRowKeys="selectedRowKeys"
						@batchCallBack="deleteBatchDahuaDefense"
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
					<a @click="formRef.onOpen(record)" v-if="hasPerm('dahuaDefenseEdit')">编辑</a>
					<a-divider type="vertical" v-if="hasPerm(['dahuaDefenseEdit', 'dahuaDefenseDelete'], 'and')" />
					<a-popconfirm title="确定要删除吗？" @confirm="deleteDahuaDefense(record)">
						<a-button type="link" danger size="small" v-if="hasPerm('dahuaDefenseDelete')">删除</a-button>
					</a-popconfirm>
				</template>
			</template>
		</s-table>
	</a-card>
	<Form ref="formRef" @successful="table.refresh(true)" />

	<!-- 导入模态框 -->
	<a-modal v-model:open="importModalVisible" title="导入大华设备" @ok="handleImport" :confirm-loading="importLoading" :after-close="resetImportForm">
		<a-form :model="importFormState" ref="importFormRef">
			<a-form-item label="选择文件" :rules="[{ required: true, message: '请选择要导入的文件' }]">
				<a-upload-dragger name="file" :multiple="false" :max-count="1" :before-upload="beforeUpload" v-model:file-list="importFormState.fileList">
					<p class="ant-upload-drag-icon">
						<inbox-outlined />
					</p>
					<p class="ant-upload-text">点击或拖拽文件到此区域上传</p>
					<p class="ant-upload-hint">仅支持.xlsx格式文件</p>
				</a-upload-dragger>
			</a-form-item>
		</a-form>
		<div style="margin-top: 10px">
			<a-alert message="导入前请先下载模板文件，按照模板格式填写数据" type="info" show-icon>
				<template #action>
					<a-button size="small" type="primary" @click="exportTemplate">下载模板</a-button>
				</template>
			</a-alert>
		</div>
	</a-modal>
</template>

<script setup name="dahuaDefense">
	import { message } from 'ant-design-vue'
	import { ref, reactive } from 'vue'
	import { InboxOutlined } from '@ant-design/icons-vue'
	import Form from './form.vue'
	import dahuaDefenseApi from '@/api/dahua/dahuaDefenseApi'
	import downloadUtil from '@/utils/downloadUtil'
	let searchFormState = reactive({})
	const searchFormRef = ref()
	const table = ref()
	const formRef = ref()
	const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
	const columns = [
		{
			title: '设备编号',
			dataIndex: 'deviceId'
		},
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
	if (hasPerm(['dahuaDefenseEdit', 'dahuaDefenseDelete'])) {
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
		return dahuaDefenseApi.dahuaDefensePage(Object.assign(parameter, searchFormParam))
	}

	// 删除大华布防
	const deleteDahuaDefense = (record) => {
		const param = [{
			id: record.id_
		}]
		dahuaDefenseApi.dahuaDefenseDelete(param).then(() => {
			table.value.refresh(true)
		})
	}

	// 批量删除大华布防
	const deleteBatchDahuaDefense = () => {
		if (selectedRowKeys.value.length < 1) {
			message.warning('请选择一条或多条数据')
			return false
		}
		const params = selectedRowKeys.value.map((m) => {
			return {
				id: m
			}
		})
		dahuaDefenseApi.dahuaDefenseDelete(params).then(() => {
			table.value.clearRefreshSelected()
		})
	}

	// 导出模板
	const exportTemplate = () => {
		dahuaDefenseApi.dahuaDefenseExportTemplate().then(res => {
			downloadUtil.resultDownload(res)
		}).catch(error => {
			message.error('导出模板失败: ' + error)
		})
	}

	// 导入相关
	const importModalVisible = ref(false)
	const importLoading = ref(false)
	const importFormRef = ref()
	const importFormState = reactive({
		fileList: []
	})

	// 显示导入模态框
	const showImportModal = () => {
		importModalVisible.value = true
	}

	// 上传前处理
	const beforeUpload = (file) => {
		const isExcel = file.type === 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' ||
					   file.type === 'application/vnd.ms-excel' ||
					   file.name.endsWith('.xlsx');
		if (!isExcel) {
			message.error('只能上传.xlsx格式的文件');
			return false;
		}
		// 返回 false 阻止组件自动上传，我们会在 handleImport 中手动处理
		return false;
	}

	// 处理导入
	const handleImport = async () => {
		try {
			const file = importFormState.fileList[0]?.originFileObj;
			if (!file) {
				message.error('请选择要导入的文件');
				return;
			}

			importLoading.value = true;

			// 创建 FormData 对象
			const formData = new FormData();
			formData.append('file', file);

			// 调用导入接口
			dahuaDefenseApi.dahuaDefenseImport(formData).then(res => {
				table.value.refresh(true)
			});
		} catch (error) {
			// message.error('导入失败: ' + (error.message || error));
		} finally {
			importLoading.value = false;
			importModalVisible.value = false
		}
	}

	// 重置导入表单
	const resetImportForm = () => {
		importFormState.fileList = [];
	}

	// 导出数据
	const exportData = () => {
		const searchFormParam = JSON.parse(JSON.stringify(searchFormState))
		dahuaDefenseApi.dahuaDefenseExport(searchFormParam).then(res => {
			downloadUtil.resultDownload(res)
		}).catch(error => {
			message.error('导出失败: ' + error)
		})
	}
</script>
