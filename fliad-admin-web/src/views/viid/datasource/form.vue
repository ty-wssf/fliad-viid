<template>
	<a-drawer
		:title="formData.id ? '编辑数据源' : '增加数据源'"
		:width="600"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
			<a-row :gutter="24">
				<a-col :span="24">
					<a-form-item label="标题：" name="title">
						<a-input v-model:value="formData.title" placeholder="请输入标题" allow-clear/>
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="订阅类别：" name="subscribeDetail">
						<a-select
							v-model:value="formData.subscribeDetail"
							placeholder="请选择订阅类别"
							:options="subscribedetailOptions"
						/>
					</a-form-item>
				</a-col>
				<a-col :span="12">
					<a-form-item label="类型：" name="type">
						<a-select
							v-model:value="formData.type"
							placeholder="请选择类型"
							:options="datasourceTypeOptions"
						/>
					</a-form-item>
				</a-col>
			</a-row>
			<template v-if="formData.type === 'rabbitmq'">
				<a-row :gutter="24">
					<a-col :span="12">
						<a-form-item label="RabbitMQ地址：" name="rabbitmqHost">
							<a-input v-model:value="formData.rabbitmqHost" placeholder="请输入RabbitMQ地址"
									 allow-clear/>
						</a-form-item>
					</a-col>
					<a-col :span="12">
						<a-form-item label="RabbitMQ端口：" name="rabbitmqPort">
							<a-input-number
								v-model:value="formData.rabbitmqPort"
								placeholder="请输入RabbitMQ端口"
								style="width: 100%"
								:min="1"
								:max="65535"
								:precision="0"
							/>
						</a-form-item>
					</a-col>
				</a-row>
				<a-row :gutter="24">
					<a-col :span="12">
						<a-form-item label="用户名：" name="rabbitmqUsername">
							<a-input v-model:value="formData.rabbitmqUsername" placeholder="请输入用户名" allow-clear/>
						</a-form-item>
					</a-col>
					<a-col :span="12">
						<a-form-item label="密码：" name="rabbitmqPassword">
							<a-input-password v-model:value="formData.rabbitmqPassword" placeholder="请输入密码"/>
						</a-form-item>
					</a-col>
				</a-row>
				<a-row :gutter="24">
					<a-col :span="12">
						<a-form-item label="交换机：" name="rabbitmqExchange">
							<a-input v-model:value="formData.rabbitmqExchange" placeholder="请输入Exchange"
									 allow-clear/>
						</a-form-item>
					</a-col>
					<a-col :span="12">
						<a-form-item label="路由键：" name="rabbitmqRoutingKey">
							<a-input v-model:value="formData.rabbitmqRoutingKey" placeholder="请输入Routing Key"
									 allow-clear/>
						</a-form-item>
					</a-col>
				</a-row>
				<a-row :gutter="24">
					<a-col :span="24">
						<a-form-item label="队列名：" name="rabbitmqQueueName">
							<a-input v-model:value="formData.rabbitmqQueueName" placeholder="请输入队列名" allow-clear/>
						</a-form-item>
					</a-col>
				</a-row>
			</template>
			<a-row :gutter="24">
				<a-col :span="24">
					<a-form-item label="备注：" name="remark">
						<a-textarea
							v-model:value="formData.remark"
							placeholder="请输入备注"
							:auto-size="{ minRows: 3, maxRows: 6 }"
							allow-clear
						/>
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

<script setup name="viidDatasourceForm">
import {cloneDeep} from 'lodash-es'
import {required} from '@/utils/formRules'
import viidDatasourceApi from '@/api/viid/viidDatasourceApi'
import tool from '@/utils/tool'
// 抽屉状态
const visible = ref(false)
const emit = defineEmits({successful: null})
const formRef = ref()
// 表单数据
const formData = ref({
	config: {}
})
const submitLoading = ref(false)
const datasourceTypeOptions = ref([])
const subscribedetailOptions = ref([])

// Host 格式校验规则
const validateHost = (rule, value) => {
	debugger
	if (!value) {
		return Promise.reject('')
	}

	// IP 地址正则表达式
	const ipRegex = /^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/

	// 域名正则表达式
	const domainRegex = /^[a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(\.[a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\.[a-zA-Z]{2,6}$/;

	// 检查是否为有效的 IP 地址
	if (ipRegex.test(value)) {
		const parts = value.split('.')
		for (let part of parts) {
			const num = parseInt(part, 10)
			if (num < 0 || num > 255) {
				return Promise.reject('请输入有效的IP地址或域名')
			}
		}
		return Promise.resolve()
	}

	// 检查是否为有效的域名
	if (domainRegex.test(value)) {
		// 确保域名至少有一个点，或者是一个有效的单级域名
		if (value.includes('.') || /^[a-zA-Z0-9]+$/.test(value)) {
			return Promise.resolve()
		}
	}

	return Promise.reject('请输入有效的IP地址或域名')
}

// 端口范围校验规则
// 已使用 a-input-number 组件的 min/max 属性进行范围限制，无需额外校验

onMounted(() => {
	datasourceTypeOptions.value = [
		{label: 'RabbitMQ', value: 'rabbitmq'}
	]
})

// 打开抽屉
const onOpen = (record) => {
	visible.value = true
	if (record) {
		let recordData = cloneDeep(record)
		// 如果存在config且为字符串，则解析为对象
		if (recordData.content && typeof recordData.content === 'string') {
			try {
				const config = JSON.parse(recordData.content)
				recordData.rabbitmqHost = config.host
				recordData.rabbitmqPort = config.port
				recordData.rabbitmqUsername = config.username
				recordData.rabbitmqPassword = config.password
				recordData.rabbitmqExchange = config.exchange
				recordData.rabbitmqRoutingKey = config.routingKey
				recordData.rabbitmqQueueName = config.queueName
			} catch (e) {
				console.error('解析config失败', e)
			}
		}
		formData.value = Object.assign({}, recordData)
	} else {
		// 默认添加空的config对象，并初始化所有属性
		formData.value = {
			rabbitmqHost: undefined,
			rabbitmqPort: undefined,
			rabbitmqUsername: undefined,
			rabbitmqPassword: undefined,
			rabbitmqExchange: undefined,
			rabbitmqRoutingKey: undefined,
			rabbitmqQueueName: undefined
		}
	}
	subscribedetailOptions.value = tool.dictList('VIID_Subscribe_Detail_Type')
}
// 关闭抽屉
const onClose = () => {
	formRef.value.resetFields()
	formData.value = {
		rabbitmqHost: undefined,
		rabbitmqPort: undefined,
		rabbitmqUsername: undefined,
		rabbitmqPassword: undefined,
		rabbitmqExchange: undefined,
		rabbitmqRoutingKey: undefined,
		rabbitmqQueueName: undefined
	}
	visible.value = false
}
// 默认要校验的
const formRules = {
	title: [required('请输入标题')],
	subscribeDetail: [required('请选择订阅类别')],
	type: [required('请选择类型')],
	rabbitmqHost: [required('请输入RabbitMQ地址'), {validator: validateHost, trigger: 'blur'}],
	rabbitmqPort: [required('请输入RabbitMQ端口')],
	rabbitmqUsername: [required('请输入用户名')],
	rabbitmqPassword: [required('请输入密码')],
	rabbitmqExchange: [required('请输入Exchange')],
	rabbitmqRoutingKey: [required('请输入Routing Key')],
	rabbitmqQueueName: [required('请输入队列名')]
}
// 验证并提交数据
const onSubmit = () => {
	formRef.value.validate().then(() => {
		submitLoading.value = true
		const formDataParam = cloneDeep(formData.value)
		// 如果是rabbitmq类型，构造config对象
		if (formDataParam.type === 'rabbitmq') {
			formDataParam.content = JSON.stringify({
				host: formDataParam.rabbitmqHost,
				port: formDataParam.rabbitmqPort,
				username: formDataParam.rabbitmqUsername,
				password: formDataParam.rabbitmqPassword,
				exchange: formDataParam.rabbitmqExchange,
				routingKey: formDataParam.rabbitmqRoutingKey,
				queueName: formDataParam.rabbitmqQueueName
			})
			// 删除临时字段
			delete formDataParam.rabbitmqHost
			delete formDataParam.rabbitmqPort
			delete formDataParam.rabbitmqUsername
			delete formDataParam.rabbitmqPassword
			delete formDataParam.rabbitmqExchange
			delete formDataParam.rabbitmqRoutingKey
			delete formDataParam.rabbitmqQueueName
		}
		viidDatasourceApi
			.viidDatasourceSubmitForm(formDataParam, formDataParam.id)
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
