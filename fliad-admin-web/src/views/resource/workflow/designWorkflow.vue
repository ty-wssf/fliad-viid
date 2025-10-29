<template>
	<a-drawer
		:title="'设计工作流'"
		:width="1700"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<iframe
			v-if="iframeSrc"
			:src="iframeSrc"
			width="100%"
			height="100%"
			frameborder="0"
			style="min-height: 800px"
		></iframe>
	</a-drawer>
</template>

<script setup name="viidWorkflowForm" lang="ts">
	import '@tinyflow-ai/vue/dist/index.css'
	import sysConfig from '@/config/index'
	import { ref } from 'vue'

	// 抽屉状态
	const visible = ref(false)
	const emit = defineEmits({ successful: null })
	const iframeSrc = ref('') // 存储iframe的src

	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		if (record) {
			iframeSrc.value = sysConfig.API_URL + '/flowgram/index.html?id=' + record.id
		}
	}

	// 关闭抽屉
	const onClose = () => {
		iframeSrc.value = ''
		visible.value = false
	}

	// 抛出函数
	defineExpose({
		onOpen
	})
</script>
