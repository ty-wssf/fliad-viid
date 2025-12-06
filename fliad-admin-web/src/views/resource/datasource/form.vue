<template>
	<a-drawer
		:title="formData.id ? '编辑数据源' : isTemplateMode ? '新增模板' : '增加数据源'"
		:width="600"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-form ref="formRef" :model="combinedFormData" :rules="formRules" layout="vertical">
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
							@change="handleTypeChange"
						/>
					</a-form-item>
				</a-col>
				<!-- 移除了"是否为模板"选项，因为根据需求无论是普通数据源还是模板数据源新增时都不显示该选项 -->
			</a-row>
			
			<!-- 动态加载不同类型的数据源表单组件 -->
			<component 
				:is="formComponents[formData.type]" 
				v-model="typeSpecificData"
				v-if="formData.type && formComponents[formData.type]"
			/>
			
			<a-row :gutter="24" v-if="formData.type !== 'rabbitmq'">
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
import viidDatasourceApi from '@/api/resource/datasourceApi'
import tool from '@/utils/tool'
// 引入各数据源类型的表单组件
import formComponents from './forms/index.js'
// 引入各数据源类型的处理器
import datasourceHandlers from './handlers/index.js'

// 抽屉状态
const visible = ref(false)
const emit = defineEmits({successful: null})
const formRef = ref()
// 表单数据
const formData = ref({
	config: {}
})

// 特定类型数据源的数据
const typeSpecificData = ref({})

// 计算属性：合并通用数据和特定类型数据，用于表单验证
const combinedFormData = computed(() => {
  return {...formData.value, ...typeSpecificData.value}
})

const submitLoading = ref(false)
const datasourceTypeOptions = ref([])
const subscribedetailOptions = ref([])
// 是否为模板模式
const isTemplateMode = ref(false)
// 移除了showTemplateSwitch变量，因为不再需要控制"是否为模板"选项的显示

onMounted(() => {
	datasourceTypeOptions.value = [
		{label: 'RabbitMQ', value: 'rabbitmq'},
		{label: '定时任务', value: 'cron'},
		{label: 'JDBC数据库', value: 'jdbc'}
	]
})

// 处理类型变更
const handleTypeChange = (value) => {
  // 当类型改变时，清空之前特定类型的表单数据
  typeSpecificData.value = {}
  
  // 更新表单验证规则
  updateFormRules()
}

// 更新表单验证规则
const updateFormRules = () => {
  // 先重置为基本规则
  formRules.title = [required('请输入标题')]
  formRules.subscribeDetail = [required('请选择订阅类别')]
  formRules.type = [required('请选择类型')]
  
  // 根据类型添加特定规则
  if (formData.value.type && datasourceHandlers[formData.value.type]) {
    const typeRules = datasourceHandlers[formData.value.type].getValidationRules()
    Object.assign(formRules, typeRules)
  }
}

// 打开抽屉
const onOpen = (record, templateMode = false) => {
	visible.value = true
	isTemplateMode.value = templateMode
	// 移除了showTemplateSwitch的设置，因为不再需要控制"是否为模板"选项的显示

	if (record) {
		let recordData = cloneDeep(record)
    const dataType = recordData.type
        
    // 使用对应数据源类型的处理器处理打开逻辑
    if (dataType && datasourceHandlers[dataType]) {
      const { formData: processedFormData, typeSpecificData: processedTypeData } = datasourceHandlers[dataType].handleOpen(recordData)
      formData.value = processedFormData
      typeSpecificData.value = processedTypeData
    } else {
      formData.value = Object.assign({}, recordData)
    }
	} else {
		// 默认添加空的config对象，并初始化所有属性
		formData.value = {}
    typeSpecificData.value = {}
	}
	subscribedetailOptions.value = tool.dictList('RESOURCE_Subscribe_Detail_Type')
  
  // 初始化表单验证规则
  updateFormRules()
}
// 关闭抽屉
const onClose = () => {
	formRef.value.resetFields()
	formData.value = {}
  typeSpecificData.value = {}
	isTemplateMode.value = false
	visible.value = false
}

// 默认要校验的
const formRules = {
	title: [required('请输入标题')],
	subscribeDetail: [required('请选择订阅类别')],
	type: [required('请选择类型')]
}

// 验证并提交数据
const onSubmit = () => {
	formRef.value.validate().then(() => {
		submitLoading.value = true
		
    // 使用对应数据源类型的处理器处理提交逻辑
    let formDataParam
    if (formData.value.type && datasourceHandlers[formData.value.type]) {
      const { formDataParam: processedFormData } = datasourceHandlers[formData.value.type].handleSubmit(
        formData.value, 
        typeSpecificData.value
      )
      formDataParam = processedFormData
    } else {
      formDataParam = {...formData.value, ...typeSpecificData.value}
    }
    
		viidDatasourceApi
			.datasourceSubmitForm(formDataParam, formDataParam.id)
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