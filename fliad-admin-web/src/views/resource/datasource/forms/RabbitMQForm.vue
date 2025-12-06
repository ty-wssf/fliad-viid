<template>
  <div>
    <a-row :gutter="24">
      <a-col :span="12">
        <a-form-item label="RabbitMQ地址：" name="rabbitmqHost">
          <a-input v-model:value="formModel.rabbitmqHost" placeholder="请输入RabbitMQ地址" allow-clear/>
        </a-form-item>
      </a-col>
      <a-col :span="12">
        <a-form-item label="RabbitMQ端口：" name="rabbitmqPort">
          <a-input-number
              v-model:value="formModel.rabbitmqPort"
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
          <a-input v-model:value="formModel.rabbitmqUsername" placeholder="请输入用户名" allow-clear/>
        </a-form-item>
      </a-col>
      <a-col :span="12">
        <a-form-item label="密码：" name="rabbitmqPassword">
          <a-input-password v-model:value="formModel.rabbitmqPassword" placeholder="请输入密码"/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="12">
        <a-form-item label="交换机：" name="rabbitmqExchange">
          <a-input v-model:value="formModel.rabbitmqExchange" placeholder="请输入Exchange" allow-clear/>
        </a-form-item>
      </a-col>
      <a-col :span="12">
        <a-form-item label="路由键：" name="rabbitmqRoutingKey">
          <a-input v-model:value="formModel.rabbitmqRoutingKey" placeholder="请输入Routing Key" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="队列名：" name="rabbitmqQueueName">
          <a-input v-model:value="formModel.rabbitmqQueueName" placeholder="请输入队列名" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="脚本过滤器：" name="scriptFilter">
          <a-textarea
            v-model:value="formModel.scriptFilter"
            placeholder="(((age > 18 AND salary < 5000) OR (NOT isMarried)) AND label IN ['aa','bb'] AND title NOT IN ['cc','dd']) OR vip=='l3'"
            :auto-size="{ minRows: 6, maxRows: 12 }"
            allow-clear
          />
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

// Host 格式校验规则
const validateHost = (rule, value) => {
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

defineExpose({
  validateHost
})
</script>