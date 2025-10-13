<template>
	<a-drawer
		:title="formData.id ? '编辑海康布防' : '增加海康布防'"
		:width="700"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-row :gutter="16">
				<a-col :span="12">
					<a-form-item label="设备名称：" name="name">
						<a-input v-model:value="formData.name" placeholder="请输入设备名称" :disabled="!!formData.id" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="IP地址：" name="ipAddr">
						<a-input v-model:value="formData.ipAddr" placeholder="请输入IP地址" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="端口：" name="port">
						<a-input-number v-model:value="formData.port" placeholder="请输入端口" style="width: 100%" :min="1" :max="65535" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="用户名：" name="username">
						<a-input v-model:value="formData.username" placeholder="请输入用户名" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="密码：" name="password">
						<a-input-password v-model:value="formData.password" placeholder="请输入密码" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="启用状态：" name="enableStatus">
						<a-radio-group v-model:value="formData.enableStatus" button-style="solid">
							<a-radio-button :value="1">启用</a-radio-button>
							<a-radio-button :value="0">禁用</a-radio-button>
						</a-radio-group>
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

<script setup name="viidHikvisionDefenseForm">
	import { cloneDeep } from 'lodash-es'
	import { required } from '@/utils/formRules'
	import viidHikvisionDefenseApi from '@/api/viid/viidHikvisionDefenseApi'
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
			let recordData = cloneDeep(record)
			formData.value = Object.assign({}, recordData)
		} else {
			formData.value = {
				enableStatus: 1
			}
		}
	}
	// 关闭抽屉
	const onClose = () => {
		formRef.value.resetFields()
		formData.value = {
			enableStatus: 1
		}
		visible.value = false
	}
	// 默认要校验的
	const formRules = {
		name: [required('请输入设备名称')],
		ipAddr: [required('请输入IP地址')],
		port: [required('请输入端口')],
		username: [required('请输入用户名')],
		password: [required('请输入密码')]
	}
	// 验证并提交数据
	const onSubmit = () => {
		formRef.value
			.validate()
			.then(() => {
				submitLoading.value = true
				const formDataParam = cloneDeep(formData.value)
				viidHikvisionDefenseApi
					.viidHikvisionDefenseSubmitForm(formDataParam, formDataParam.id)
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