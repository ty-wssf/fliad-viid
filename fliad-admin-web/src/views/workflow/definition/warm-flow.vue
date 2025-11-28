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

<script setup name="WarmFlow">
import { ref, onMounted, onBeforeUnmount } from 'vue'
import { useRoute } from 'vue-router'
import tool from "@/utils/tool"

const route = useRoute()
const iframeRef = ref()

// 页面高度
const height = ref(document.documentElement.clientHeight - 94.5 + "px")

// iframe URL
const url = ref("")

// 消息处理
const handleMessage = (event) => {
  console.log(event.data.method, event)
  switch (event.data.method) {
    case "close":
      close()
      break
  }
}

// 关闭页面
const close = () => {
  // TODO: 实现页面关闭逻辑
  console.log("关闭流程设计器")
}

// 设置主题
const handleTheme = (theme) => {
  // 获取目标窗口对象
  const targetWindow = iframeRef.value?.contentWindow
  if (targetWindow) {
    targetWindow.postMessage({type: theme}, "*")
  }
}

onMounted(() => {
  // 获取路由参数
  const id = route.params?.id
  const onlyDesignShow = route.query?.onlyDesignShow
  const disabled = route.query?.disabled
  
  // 构造URL
  const baseUrl = `${process.env.VUE_APP_FLOW_API}/warm-flow-ui/index.html`
  const params = new URLSearchParams({
    id: id || '',
    onlyDesignShow: onlyDesignShow || '',
    disabled: disabled || ''
  }).toString()
  
  url.value = `${baseUrl}?${params}&Authorization=Bearer ${tool.data.get('TOKEN')}`
  
  // 添加消息监听器
  window.addEventListener("message", handleMessage)
})

onBeforeUnmount(() => {
  // 移除消息监听器
  window.removeEventListener("message", handleMessage)
})
</script>