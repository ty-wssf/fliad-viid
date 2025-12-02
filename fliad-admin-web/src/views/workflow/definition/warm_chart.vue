<template>
  <div :style="'height:' + height">
    <iframe 
      id="warmChart" 
      :src="url" 
      style="width: 100%; height: 100%; border: none;"
      ref="iframeRef"
    />
  </div>
</template>

<script setup name="WarmChart">
import { ref, watch, onMounted } from 'vue'
import tool from "@/utils/tool"

// Props
const props = defineProps({
  // 组件调用时传入的流程实例ID
  insId: { type: [String, Number], default: null }
})

const iframeRef = ref()

// 页面高度
const height = ref(document.documentElement.clientHeight - 200 + "px")

// iframe URL
const url = ref("")

// 监听 insId 变化
watch(() => props.insId, (newVal) => {
  if (newVal) {
    const baseUrl = `${process.env.VUE_APP_FLOW_API}/warm-flow-ui/index.html`
    const params = new URLSearchParams({
      id: newVal,
      type: 'FlowChart'
    }).toString()
    
    url.value = `${baseUrl}?${params}&Authorization=Bearer ${tool.data.get('TOKEN')}`
  }
}, { immediate: true })

// 设置主题
const handleTheme = (theme) => {
  // 获取目标窗口对象
  const targetWindow = iframeRef.value?.contentWindow
  if (targetWindow) {
    targetWindow.postMessage({type: theme}, "*")
  }
}

onMounted(() => {
  // 组件挂载后执行
})
</script>