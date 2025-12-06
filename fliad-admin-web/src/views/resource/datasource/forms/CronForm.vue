<template>
  <div>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="Cron表达式：" name="cronExpression">
          <a-input v-model:value="formModel.cronExpression" placeholder="请输入Cron表达式，如：*/5 * * * * * （每5秒执行一次）" allow-clear/>
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="24">
      <a-col :span="24">
        <a-form-item label="触发消息：" name="payload">
          <a-textarea
              v-model:value="formModel.payload"
              placeholder='{"event": "定时任务触发"}'
              :auto-size="{ minRows: 4, maxRows: 8 }"
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
</script>
