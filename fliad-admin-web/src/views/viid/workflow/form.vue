<template>
	<a-drawer
		:title="formData.id ? '编辑工作流' : '增加工作流'"
		:width="600"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-form-item label="标题：" name="title">
				<a-input v-model:value="formData.title" placeholder="请输入标题" allow-clear />
			</a-form-item>
			<a-form-item label="订阅类别：" name="subscribeDetail">
				<a-select
					v-model:value="formData.subscribeDetail"
					placeholder="请选择订阅类别"
					mode="multiple"
					:options="subscribedetailOptions"
				/>
			</a-form-item>
			<a-form-item label="备注：" name="remark">
				<a-textarea
					v-model:value="formData.remark"
					placeholder="请输入备注"
					:auto-size="{ minRows: 3, maxRows: 6 }"
					allow-clear
				/>
			</a-form-item>
		</a-form>
		<template #footer>
			<a-button style="margin-right: 8px" @click="onClose">关闭</a-button>
			<a-button type="primary" @click="onSubmit" :loading="submitLoading">保存</a-button>
		</template>
	</a-drawer>
</template>

<script setup name="viidWorkflowForm">
	import { cloneDeep } from 'lodash-es'
	import { required } from '@/utils/formRules'
	import viidWorkflowApi from '@/api/viid/viidWorkflowApi'
	import tool from '@/utils/tool'
	// 抽屉状态
	const visible = ref(false)
	const emit = defineEmits({ successful: null })
	const formRef = ref()
	// 表单数据
	const formData = ref({})
	const submitLoading = ref(false)
	const subscribedetailOptions = ref([])

	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		if (record) {
			let recordData = cloneDeep(record)
			if (recordData.subscribeDetail) {
				recordData.subscribeDetail = JSON.parse(recordData.subscribeDetail)
			}
			formData.value = Object.assign({}, recordData)
		}
		subscribedetailOptions.value = tool.dictList('VIID_Subscribe_Detail_Type')
	}
	// 关闭抽屉
	const onClose = () => {
		formRef.value.resetFields()
		formData.value = {}
		visible.value = false
	}
	// 默认要校验的
	const formRules = {
		title: [required('请输入标题')],
		subscribeDetail: [required('请选择订阅类别')]
	}
	// 验证并提交数据
	const onSubmit = () => {
		formRef.value.validate().then(() => {
			submitLoading.value = true
			const formDataParam = cloneDeep(formData.value)
			formDataParam.subscribeDetail = JSON.stringify(formDataParam.subscribeDetail)
			viidWorkflowApi
				.viidWorkflowSubmitForm(formDataParam, formDataParam.id)
				.then(() => {
					onClose()
					emit('successful')
				})
				.finally(() => {
					submitLoading.value = false
				})
		})
	}
	// 抛出函数
	defineExpose({
		onOpen
	})
</script>
