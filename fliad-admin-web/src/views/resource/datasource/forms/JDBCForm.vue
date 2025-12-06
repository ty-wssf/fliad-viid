<template>
  <div>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="驱动类名：" name="jdbcDriverClassName">
          <a-input v-model:value="formModel.jdbcDriverClassName" placeholder="请输入驱动类名，如：com.mysql.cj.jdbc.Driver" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="数据库URL：" name="jdbcUrl">
          <a-input v-model:value="formModel.jdbcUrl" placeholder="请输入数据库URL，如：jdbc:mysql://localhost:3306/dbname" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="12">
        <a-form-item label="用户名：" name="jdbcUsername">
          <a-input v-model:value="formModel.jdbcUsername" placeholder="请输入用户名" allow-clear/>
        </a-form-item>
      </a-col>
      <a-col :span="12">
        <a-form-item label="密码：" name="jdbcPassword">
          <a-input-password v-model:value="formModel.jdbcPassword" placeholder="请输入密码"/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="数据源名称：" name="jdbcDataSourceName">
          <a-input v-model:value="formModel.jdbcDataSourceName" placeholder="请输入数据源名称（可选，默认使用数据源ID）" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
  </div>
</template>

<script setup>
import {ref, watch} from 'vue'

const props = defineProps({
  modelValue: {
    type: Object,
    default: () => ({})
  }
})

const emit = defineEmits(['update:modelValue'])

const formModel = ref({...props.modelValue})

watch(formModel, (newVal) => {
  emit('update:modelValue', newVal)
}, {deep: true})

watch(() => props.modelValue, (newVal) => {
  formModel.value = {...newVal}
}, {deep: true})

// 定义校验规则
const validateDataSourceName = (rule, value) => {
  if (!value || value.trim() === '') {
    return Promise.reject('数据源名称不能为空')
  }
  return Promise.resolve()
}

defineExpose({
  validateDataSourceName
})
</script>