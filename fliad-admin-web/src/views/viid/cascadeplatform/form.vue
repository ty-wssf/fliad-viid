<template>
    <a-drawer
        :title="formData.id ? '编辑视图库' : '增加视图库'"
        :width="600"
        :visible="visible"
        :destroy-on-close="true"
        :footer-style="{ textAlign: 'right' }"
        @close="onClose"
    >
        <a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
            <a-form-item label="视图库ID：" name="systemId">
                <a-input v-model:value="formData.systemId" placeholder="请输入视图库ID" allow-clear />
            </a-form-item>
            <a-form-item label="视图库名称：" name="name">
                <a-input v-model:value="formData.name" placeholder="请输入视图库名称" allow-clear />
            </a-form-item>
            <a-form-item label="IP地址：" name="ipAddr">
                <a-input v-model:value="formData.ipAddr" placeholder="请输入IP地址" allow-clear />
            </a-form-item>
            <a-form-item label="端口：" name="port">
                <a-input-number v-model:value="formData.port" placeholder="请输入端口" :min="1" :max="65535" style="width: 100%" />
            </a-form-item>
            <a-form-item label="视图库类型：" name="type">
                <a-select v-model:value="formData.type" placeholder="请选择视图库类型" :options="typeOptions" />
            </a-form-item>
            <a-form-item label="授权用户：" name="userId">
                <a-input v-model:value="formData.userId" placeholder="请输入授权用户" allow-clear />
            </a-form-item>
            <a-form-item label="授权密码：" name="password">
                <a-input v-model:value="formData.password" placeholder="请输入授权密码" allow-clear />
            </a-form-item>
        </a-form>
        <template #footer>
            <a-button style="margin-right: 8px" @click="onClose">关闭</a-button>
            <a-button type="primary" @click="onSubmit" :loading="submitLoading">保存</a-button>
        </template>
    </a-drawer>
</template>

<script setup name="viidCascadePlatformForm">
    import tool from '@/utils/tool'
    import { cloneDeep } from 'lodash-es'
    import { required } from '@/utils/formRules'
    import viidCascadePlatformApi from '@/api/viid/viidCascadePlatformApi'
    // 抽屉状态
    const visible = ref(false)
    const emit = defineEmits({ successful: null })
    const formRef = ref()
    // 表单数据
    const formData = ref({})
    const submitLoading = ref(false)
    const isOnlineOptions = ref([])
    const typeOptions = ref([])

    // 打开抽屉
    const onOpen = (record) => {
        visible.value = true
        if (record) {
            let recordData = cloneDeep(record)
            formData.value = Object.assign({}, recordData)
        }
        isOnlineOptions.value = tool.dictList('VIID_ONLINE')
        typeOptions.value = tool.dictList('VIID_TYPE')
    }
    // 关闭抽屉
    const onClose = () => {
        formRef.value.resetFields()
        formData.value = {}
        visible.value = false
    }
    // 默认要校验的
    const formRules = {
        systemId: [required('请输入视图库ID')],
        name: [required('请输入视图库名称')],
        ipAddr: [required('请输入IP地址')],
        port: [required('请输入端口')],
        type: [required('请输入视图库类型')],
    }
    // 验证并提交数据
    const onSubmit = () => {
        formRef.value
            .validate()
            .then(() => {
                submitLoading.value = true
                const formDataParam = cloneDeep(formData.value)
                viidCascadePlatformApi
                    .viidCascadePlatformSubmitForm(formDataParam, formDataParam.id)
                    .then(() => {
                        onClose()
                        emit('successful')
                    })
                    .finally(() => {
                        submitLoading.value = false
                    })
            })
    }
    // 抛出函数
    defineExpose({
        onOpen
    })
</script>
