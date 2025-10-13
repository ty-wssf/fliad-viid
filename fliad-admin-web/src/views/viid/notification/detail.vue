<template>
	<a-drawer
		title="订阅通知详情"
		:width="700"
		:visible="visible"
		:destroy-on-close="true"
		:footer-style="{ textAlign: 'right' }"
		@close="onClose"
	>
		<a-descriptions bordered size="small" :column="1">
			<a-descriptions-item label="主键">
				{{ formData.ID }}
			</a-descriptions-item>
			<a-descriptions-item label="通知标识">
				{{ formData.NotificationID }}
			</a-descriptions-item>
			<a-descriptions-item label="订阅标识">
				{{ formData.SubscribeID }}
			</a-descriptions-item>
			<a-descriptions-item label="订阅标题">
				{{ formData.Title }}
			</a-descriptions-item>
			<a-descriptions-item label="触发时间">
				{{ formData.TriggerTime }}
			</a-descriptions-item>
			<a-descriptions-item label="信息标识">
				{{ formData.InfoIDs }}
			</a-descriptions-item>
			<a-descriptions-item label="请求数据">
				<pre class="json-pre">{{ formData.RequestData }}</pre>
			</a-descriptions-item>
			<a-descriptions-item label="响应数据">
				<pre class="json-pre">{{ formData.ResponseData }}</pre>
			</a-descriptions-item>
			<a-descriptions-item label="请求耗时（毫秒）">
				{{ formData.RequestCost }}
			</a-descriptions-item>
			<a-descriptions-item label="创建时间">
				{{ formData.CreateTime }}
			</a-descriptions-item>
			<a-descriptions-item label="更新时间">
				{{ formData.UpdateTime }}
			</a-descriptions-item>
		</a-descriptions>
		<template #footer>
			<a-button style="margin-right: 8px" @click="onClose">关闭</a-button>
		</template>
	</a-drawer>
</template>

<script setup name="viidNotificationDetail">
	import viidNotificationApi from '@/api/viid/viidNotificationApi'
	// 抽屉状态
	const visible = ref(false)
	const formRef = ref()
	// 表单数据
	const formData = ref({})

	// 打开抽屉
	const onOpen = (record) => {
		visible.value = true
		if (record) {
			// 如果传入的是完整记录，则直接显示
			if (record.ID) {
				formData.value = Object.assign({}, record)
			} else {
				// 如果传入的是ID，则请求详细信息
				getDetail(record.ID)
			}
		}
	}
	
	// 获取详情
	const getDetail = (id) => {
		const param = { ID: id }
		viidNotificationApi.viidSubscribeNotificationsDetail(param).then((data) => {
			formData.value = Object.assign({}, data)
		})
	}
	
	// 关闭抽屉
	const onClose = () => {
		formData.value = {}
		visible.value = false
	}
	
	// 抛出函数
	defineExpose({
		onOpen
	})
</script>

<style scoped>
.json-pre {
	white-space: pre-wrap;
	word-wrap: break-word;
	margin: 0;
}
</style>