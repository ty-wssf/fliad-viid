<template>
	<a-drawer
		:title="formData.ID ? '编辑视频卡口' : '增加视频卡口'"
		:width="700"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-row :gutter="16">
				<a-col :span="12">
					<a-form-item label="卡口ID：" name="TollgateID">
						<a-input v-model:value="formData.TollgateID" placeholder="请输入卡口ID" :disabled="!!formData.ID" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="卡口名称：" name="Name">
						<a-input v-model:value="formData.Name" placeholder="请输入卡口名称" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="经度：" name="Longitude">
						<a-input-number v-model:value="formData.Longitude" placeholder="请输入经度" :min="-180" :max="180" :step="0.000001" style="width: 100%" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="纬度：" name="Latitude">
						<a-input-number v-model:value="formData.Latitude" placeholder="请输入纬度" :min="-90" :max="90" :step="0.000001" style="width: 100%" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="行政区划代码：" name="PlaceCode">
						<a-input v-model:value="formData.PlaceCode" placeholder="请输入行政区划代码" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="具体位置：" name="Place">
						<a-input v-model:value="formData.Place" placeholder="请输入具体位置" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="卡口状态：" name="Status">
						<a-select v-model:value="formData.Status" placeholder="请选择卡口状态" allow-clear>
							<a-select-option :value="1">正常</a-select-option>
							<a-select-option :value="2">停用</a-select-option>
							<a-select-option :value="9">其他</a-select-option>
						</a-select>
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="卡口类型：" name="TollgateCat">
						<a-input v-model:value="formData.TollgateCat" placeholder="请输入卡口类型" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="卡口用途：" name="TollgateUsage">
						<a-select v-model:value="formData.TollgateUsage" placeholder="请选择卡口用途" allow-clear>
							<a-select-option :value="80">治安卡口</a-select-option>
							<a-select-option :value="81">交通卡口</a-select-option>
							<a-select-option :value="82">其他</a-select-option>
						</a-select>
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="车道数：" name="LaneNum">
						<a-input-number v-model:value="formData.LaneNum" placeholder="请输入车道数" :min="0" style="width: 100%" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="管辖单位代码：" name="OrgCode">
						<a-input v-model:value="formData.OrgCode" placeholder="请输入管辖单位代码" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="启用时间：" name="ActiveTime">
						<a-date-picker v-model:value="formData.ActiveTime" value-format="YYYY-MM-DD HH:mm:ss" show-time class="xn-wd" />
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

<script setup name="viidTollgateForm">
	import { cloneDeep } from 'lodash-es'
	import { required } from '@/utils/formRules'
	import viidTollgateApi from '@/api/viid/viidTollgateApi'
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
		TollgateID: [required('请输入卡口ID')],
		Name: [required('请输入卡口名称')],
		Longitude: [required('请输入经度')],
		Latitude: [required('请输入纬度')],
		PlaceCode: [required('请输入行政区划代码')],
		Status: [required('请选择卡口状态')],
		TollgateCat: [required('请输入卡口类型')],
		TollgateUsage: [required('请选择卡口用途')]
	}
	// 验证并提交数据
	const onSubmit = () => {
		formRef.value.validate().then(() => {
			submitLoading.value = true
			const formDataParam = cloneDeep(formData.value)
			viidTollgateApi
				.viidTollgateSubmitForm(formDataParam, formDataParam.ID)
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