<template>
	<a-modal
		:visible="visible"
		:title="title"
		:width="800"
		:footer="null"
		:destroy-on-close="true"
		@cancel="onClose"
	>
		<a-descriptions bordered size="small" :column="{ xs: 1, sm: 1, md: 2, lg: 2, xl: 2, xxl: 2 }">
			<a-descriptions-item label="通知标识">{{ formData.NotificationID }}</a-descriptions-item>
			<a-descriptions-item label="订阅标识">{{ formData.SubscribeID }}</a-descriptions-item>
			<a-descriptions-item label="订阅标题">{{ formData.Title }}</a-descriptions-item>
			<a-descriptions-item label="触发时间">{{ formData.TriggerTime }}</a-descriptions-item>
			<a-descriptions-item label="信息标识" :span="2">{{ formData.InfoIDs }}</a-descriptions-item>
			<a-descriptions-item label="请求字段数据" :span="2">
				<a-textarea v-model:value="formData.RequestData" :rows="4" read-only />
			</a-descriptions-item>
			<a-descriptions-item label="响应字段数据" :span="2">
				<a-textarea v-model:value="formData.ResponseData" :rows="4" read-only />
			</a-descriptions-item>
			<a-descriptions-item label="请求耗时">{{ formData.RequestCost }} ms</a-descriptions-item>
			<a-descriptions-item label="创建时间">{{ formData.CreateTime }}</a-descriptions-item>
			<a-descriptions-item label="更新时间">{{ formData.UpdateTime }}</a-descriptions-item>
		</a-descriptions>
	</a-modal>
</template>

<script setup name="viidNotificationUpDetail">
	import { message } from 'ant-design-vue'
	// 抽屉状态
	const visible = ref(false)
	const title = ref('')
	const formData = ref({})
	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		title.value = '通知详情'
		formData.value = Object.assign({}, record)
	}
	// 关闭抽屉
	const onClose = () => {
		visible.value = false
		formData.value = {}
	}
	// 抛出函数
	defineExpose({
		onOpen
	})
</script>