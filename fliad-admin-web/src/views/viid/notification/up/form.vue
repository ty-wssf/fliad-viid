<template>
	<a-drawer
		:title="formData.id ? '编辑通知上报' : '增加通知上报'"
		:width="700"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-row :gutter="16">
				<a-col :span="12">
					<a-form-item label="通知标识：" name="NotificationID">
						<a-input v-model:value="formData.NotificationID" placeholder="请输入通知标识" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="订阅标识：" name="SubscribeID">
						<a-input v-model:value="formData.SubscribeID" placeholder="请输入订阅标识" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="订阅标题：" name="Title">
						<a-input v-model:value="formData.Title" placeholder="请输入订阅标题" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="触发时间：" name="TriggerTime">
						<a-date-picker v-model:value="formData.TriggerTime" show-time class="xn-wd" />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="信息标识：" name="InfoIDs">
						<a-textarea v-model:value="formData.InfoIDs" placeholder="请输入信息标识" :rows="2" />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="请求字段数据：" name="RequestData">
						<a-textarea v-model:value="formData.RequestData" placeholder="请输入请求字段数据" :rows="3" />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="响应字段数据：" name="ResponseData">
						<a-textarea v-model:value="formData.ResponseData" placeholder="请输入响应字段数据" :rows="3" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="请求耗时：" name="RequestCost">
						<a-input-number v-model:value="formData.RequestCost" placeholder="请输入请求耗时" style="width: 100%" />
					</a-form-item>
				</a-col>
			</a-row>
		</a-form>
		<template #footer>
			<a-button style="margin-right: 8px" @click="onClose">关闭</a-button>
			<a-button type="primary" @click="onSubmit" :loading="submitLoading">保存</a-button>
		</template>
	</a-drawer>
</template>

<script setup name="viidNotificationUpForm">
	import { cloneDeep } from 'lodash-es'
	import { required } from '@/utils/formRules'
	import viidNotificationApi from '@/api/viid/viidNotificationApi'
	// 抽屉状态
	const visible = ref(false)
	const emit = defineEmits({ successful: null })
	const formRef = ref()
	// 表单数据
	const formData = ref({})
	const submitLoading = ref(false)
	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		if (record) {
			formData.value = Object.assign({}, record)
		} else {
			formData.value = {}
		}
	}
	// 关闭抽屉
	const onClose = () => {
		formRef.value.resetFields()
		formData.value = {}
		visible.value = false
	}
	// 默认要校验的
	const formRules = {
		NotificationID: [required('请输入通知标识')],
		SubscribeID: [required('请输入订阅标识')],
		Title: [required('请输入订阅标题')]
	}
	// 验证并提交数据
	const onSubmit = () => {
		formRef.value.validate().then(() => {
			submitLoading.value = true
			const formDataParam = cloneDeep(formData.value)
			viidNotificationApi
				.viidSubscribeNotificationsSubmitForm(formDataParam, formDataParam.ID)
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