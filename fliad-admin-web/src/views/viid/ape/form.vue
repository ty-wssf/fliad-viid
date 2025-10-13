<template>
	<a-drawer
		:title="formData.ID ? '编辑采集设备' : '增加采集设备'"
		:width="700"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-row :gutter="16">
				<a-col :span="12">
					<a-form-item label="设备唯一标识：" name="ApeID">
						<a-input v-model:value="formData.ApeID" placeholder="请输入设备唯一标识" :disabled="!!formData.ID" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="设备名称：" name="Name">
						<a-input v-model:value="formData.Name" placeholder="请输入设备名称" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="设备型号：" name="Model">
						<a-input v-model:value="formData.Model" placeholder="请输入设备型号" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="IPv4地址：" name="IPAddr">
						<a-input v-model:value="formData.IPAddr" placeholder="请输入IPv4地址" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="IPv6地址：" name="IPV6Addr">
						<a-input v-model:value="formData.IPV6Addr" placeholder="请输入IPv6地址" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="端口号：" name="Port">
						<a-input-number v-model:value="formData.Port" placeholder="请输入端口号" :min="1" :max="65535" style="width: 100%" />
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
					<a-form-item label="管辖单位代码：" name="OrgCode">
						<a-input v-model:value="formData.OrgCode" placeholder="请输入管辖单位代码" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="车辆抓拍方向：" name="CapDirection">
						<a-select v-model:value="formData.CapDirection" placeholder="请选择车辆抓拍方向" allow-clear>
							<a-select-option :value="0">拍车头</a-select-option>
							<a-select-option :value="1">拍车尾</a-select-option>
						</a-select>
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="监视方向：" name="MonitorDirection">
						<a-input v-model:value="formData.MonitorDirection" placeholder="请输入监视方向" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="监视区域说明：" name="MonitorAreaDesc">
						<a-input v-model:value="formData.MonitorAreaDesc" placeholder="请输入监视区域说明" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="所属采集系统ID：" name="OwnerApsID">
						<a-input v-model:value="formData.OwnerApsID" placeholder="请输入所属采集系统ID" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="登录账号：" name="UserId">
						<a-input v-model:value="formData.UserId" placeholder="请输入登录账号" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="登录密码：" name="Password">
						<a-input-password v-model:value="formData.Password" placeholder="请输入登录密码" allow-clear />
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="功能类型：" name="FunctionType">
						<a-select v-model:value="formData.FunctionType" placeholder="请选择功能类型" allow-clear>
							<a-select-option value="1">车辆卡口</a-select-option>
							<a-select-option value="2">人员卡口</a-select-option>
							<a-select-option value="3">微卡口</a-select-option>
							<a-select-option value="4">特征摄像机</a-select-option>
							<a-select-option value="5">普通监控</a-select-option>
							<a-select-option value="6">高空瞭望摄像机</a-select-option>
							<a-select-option value="99">其他</a-select-option>
						</a-select>
					</a-form-item>
				</a-col>
				<a-col :span="24">
					<a-form-item label="位置类型：" name="PositionType">
						<a-select v-model:value="formData.PositionType" placeholder="请选择位置类型" mode="multiple" :options="positionTypeOptions" />
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

<script setup name="viidApeForm">
	import { cloneDeep } from 'lodash-es'
	import { required } from '@/utils/formRules'
	import viidApeApi from '@/api/viid/viidApeApi'
	// 抽屉状态
	const visible = ref(false)
	const emit = defineEmits({ successful: null })
	const formRef = ref()
	// 表单数据
	const formData = ref({})
	const submitLoading = ref(false)

	const positionTypeOptions = ref([
		{ label: '省际检查站', value: '1' },
		{ label: '党政机关', value: '2' },
		{ label: '车站码头', value: '3' },
		{ label: '中心广场', value: '4' },
		{ label: '体育场馆', value: '5' },
		{ label: '商业中心', value: '6' },
		{ label: '宗教场所', value: '7' },
		{ label: '校园周边', value: '8' },
		{ label: '治安复杂区域', value: '9' },
		{ label: '交通干线', value: '10' },
		{ label: '医院周边', value: '11' },
		{ label: '金融机构周边', value: '12' },
		{ label: '危险物品场所周边', value: '13' },
		{ label: '博物馆展览馆', value: '14' },
		{ label: '重点水域、航道', value: '15' },
		{ label: '市际公安检查站', value: '96' },
		{ label: '涉外场所', value: '97' },
		{ label: '边境沿线', value: '98' },
		{ label: '旅游景区', value: '99' }
	])

	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		if (record) {
			let recordData = cloneDeep(record)
			if (recordData.PositionType) {
				recordData.PositionType = recordData.PositionType.split(',')
			} else {
				recordData.PositionType = []
			}
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
		ApeID: [required('请输入设备唯一标识')],
		Name: [required('请输入设备名称')],
		Model: [required('请输入设备型号')],
		IPAddr: [required('请输入IPv4地址')],
		Port: [required('请输入端口号')],
		Longitude: [required('请输入经度')],
		Latitude: [required('请输入纬度')],
		PlaceCode: [required('请输入行政区划代码')],
		FunctionType: [required('请选择功能类型')]
	}
	// 验证并提交数据
	const onSubmit = () => {
		formRef.value.validate().then(() => {
			submitLoading.value = true
			const formDataParam = cloneDeep(formData.value)
			// 移除IsOnline字段，由系统自动管理设备在线状态
			delete formDataParam.IsOnline
			if (formDataParam.PositionType && Array.isArray(formDataParam.PositionType)) {
				formDataParam.PositionType = formDataParam.PositionType.join(',')
			}
			viidApeApi
				.viidApeSubmitForm(formDataParam, formDataParam.ID)
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
