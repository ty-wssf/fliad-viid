<template>
	<div>
		<a-row :gutter="24">
			<a-col :span="24">
				<a-form-item label="接口路径：" name="httpPath">
					<a-input v-model:value="formModel.httpPath" placeholder="请输入接口路径，如：/api/data/receive"
							 allow-clear/>
				</a-form-item>
			</a-col>
		</a-row>
		<a-row :gutter="24">
			<a-col :span="24">
				<a-form-item label="脚本：" name="script">
					<a-textarea
						v-model:value="formModel.script"
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

const getDefaultScript = () => {
	return props.modelValue.script || `<c:script><![CDATA[

]]></c:script>`;
};

const formModel = ref({
	...props.modelValue,
	script: getDefaultScript()
})

const methodOptions = [
	{label: 'GET', value: 'GET'},
	{label: 'POST', value: 'POST'},
	{label: 'PUT', value: 'PUT'},
	{label: 'DELETE', value: 'DELETE'},
	{label: 'PATCH', value: 'PATCH'}
]

watch(formModel, (newVal) => {
	emit('update:modelValue', newVal)
}, {deep: true})

watch(() => props.modelValue, (newVal) => {
	formModel.value = {...newVal, script: newVal.script || getDefaultScript()}
}, {deep: true})
</script>
