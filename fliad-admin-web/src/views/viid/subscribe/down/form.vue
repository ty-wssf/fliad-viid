<template>
	<a-drawer
		:title="formData.subscribeid ? '编辑订阅下发' : '增加订阅下发'"
		:width="600"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-row :gutter="16">
				<a-col :span="24">
					<a-form-item label="订阅标题：" name="Title">
						<a-input v-model:value="formData.Title" placeholder="请输入订阅标题" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="订阅目标节点：" name="SubscriberRecoverOrgid">
						<a-select
							v-model:value="formData.SubscriberRecoverOrgid"
							multiple
							class="xn-wd"
							placeholder="请选择订阅目标节点"
						>
							<a-select-option v-for="(item, index) in viidCascadePlatformOptions" :key="index" :value="item.id" > {{ item.name }} </a-select-option>
						</a-select>
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="信息上报间隔时间：" name="ReportInterval">
						<a-input-number v-model:value="formData.ReportInterval" :min="1" :max="10000" style="width: 100%" />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="订阅类别：" name="SubscribeDetail">
						<a-select v-model:value="formData.SubscribeDetail" placeholder="请选择订阅类别" mode="multiple" :options="subscribedetailOptions" />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="订阅资源：" name="ResourceURI">
						<a-input v-model:value="formData.ResourceURI" placeholder="请输入订阅资源" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="信息接收地址：" name="ReceiveAddr">
						<a-input v-model:value="formData.ReceiveAddr" placeholder="请输入信息接收地址" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="申请人：" name="ApplicantName">
						<a-input v-model:value="formData.ApplicantName" placeholder="请输入申请人" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="申请单位：" name="ApplicantOrg">
						<a-input v-model:value="formData.ApplicantOrg" placeholder="请输入申请单位" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="理由：" name="Reason">
						<a-input v-model:value="formData.Reason" placeholder="请输入理由" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="开始时间：" name="BeginTime">
<!--						<a-input v-model:value="formData.begintime" placeholder="请输入开始时间" allow-clear />-->
						<a-date-picker v-model:value="formData.BeginTime" value-format="YYYY-MM-DD" class="xn-wd" />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="结束时间：" name="EndTime">
						<a-date-picker v-model:value="formData.EndTime" value-format="YYYY-MM-DD" class="xn-wd" />
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

<script setup name="viidSubscribeForm">
	import { cloneDeep } from 'lodash-es'
	import { required } from '@/utils/formRules'
	import viidSubscribeApi from '@/api/viid/viidSubscribeApi'
	import viidCascadePlatformApi from '@/api/viid/viidCascadePlatformApi'
	import tool from '@/utils/tool'
	import { data } from '@/components/Cron/data'
	// 抽屉状态
	const visible = ref(false)
	const emit = defineEmits({ successful: null })
	const formRef = ref()
	// 表单数据
	const formData = ref({})
	const submitLoading = ref(false)
	const subscribedetailOptions = ref([])
	const viidCascadePlatformOptions = ref([])

	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		if (record) {
			let recordData = cloneDeep(record)
			recordData.SubscribeDetail = JSON.parse(recordData.SubscribeDetail)
			formData.value = Object.assign({}, recordData)
		} else {
			let recordData = {}
			recordData.ReportInterval = 30
			recordData.ReceiveAddr = 'http://localhost:8080/VIID/SubscribeNotifications'
			formData.value = Object.assign({}, recordData)
		}
		subscribedetailOptions.value = tool.dictList('VIID_Subscribe_Detail_Type')
		viidCascadePlatformApi.viidCascadePlatformList({ type: "1" })
			.then((res) => {
				viidCascadePlatformOptions.value = res
			})
	}
	// 关闭抽屉
	const onClose = () => {
		formRef.value.resetFields()
		formData.value = {}
		visible.value = false
	}
	// 默认要校验的
	const formRules = {
		Title: [required('请输入订阅标题')],
		SubscribeDetail: [required('请输入订阅类别')],
		ResourceURI: [required('请输入订阅资源')],
		ApplicantName: [required('请输入申请人')],
		ApplicantOrg: [required('请输入申请单位')],
		BeginTime: [required('请输入开始时间')],
		EndTime: [required('请输入结束时间')],
		ReceiveAddr: [required('请输入信息接收地址')],
		ReportInterval: [required('请输入信息上报间隔时间')],
		SubscriberRecoverOrgid: [required('请选择订阅目标节点')]
	}
	// 验证并提交数据
	const onSubmit = () => {
		formRef.value.validate().then(() => {
			submitLoading.value = true
			const formDataParam = cloneDeep(formData.value)
			formDataParam.SubscribeDetail = JSON.stringify(formDataParam.SubscribeDetail)
			viidSubscribeApi
				.viidSubscribeSubmitForm(formDataParam, formDataParam.SubscribeID)
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
