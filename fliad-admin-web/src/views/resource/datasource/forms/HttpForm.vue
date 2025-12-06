<template>
  <div>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="接口路径：" name="httpPath">
          <a-input v-model:value="formModel.httpPath" placeholder="请输入接口路径，如：/api/data/receive" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="12">
        <a-form-item label="请求方法：" name="httpMethod">
          <a-select
            v-model:value="formModel.httpMethod"
            placeholder="请选择请求方法"
            :options="methodOptions"
          />
        </a-form-item>
      </a-col>
      <a-col :span="12">
        <a-form-item label="脚本过滤器：" name="scriptFilter">
          <a-input v-model:value="formModel.scriptFilter" placeholder="请输入脚本过滤器表达式" allow-clear/>
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

const methodOptions = [
  { label: 'GET', value: 'GET' },
  { label: 'POST', value: 'POST' },
  { label: 'PUT', value: 'PUT' },
  { label: 'DELETE', value: 'DELETE' },
  { label: 'PATCH', value: 'PATCH' }
]

watch(formModel, (newVal) => {
  emit('update:modelValue', newVal)
}, {deep: true})

watch(() => props.modelValue, (newVal) => {
  formModel.value = {...newVal}
}, {deep: true})
</script>