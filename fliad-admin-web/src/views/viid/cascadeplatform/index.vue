<template>
    <a-card :bordered="false">
        <a-form ref="searchFormRef" name="advanced_search" :model="searchFormState" class="ant-advanced-search-form mb-4">
            <a-row :gutter="24">
                <a-col :span="6">
                    <a-form-item label="视图库名称" name="name">
                        <a-input v-model:value="searchFormState.name" placeholder="请输入视图库名称" />
                    </a-form-item>
                </a-col>
                <a-col :span="6">
                    <a-form-item label="是否在线" name="isOnline">
                        <a-select v-model:value="searchFormState.isOnline" placeholder="请选择是否在线" :options="isOnlineOptions" />
                    </a-form-item>
                </a-col>
                <a-col :span="6">
                    <a-form-item label="视图库类型" name="type">
                        <a-select v-model:value="searchFormState.type" placeholder="请选择视图库类型" :options="typeOptions" />
                    </a-form-item>
                </a-col>
                <a-col :span="6">
                    <a-button type="primary" @click="table.refresh(true)">查询</a-button>
                    <a-button style="margin: 0 8px" @click="() => searchFormRef.resetFields()">重置</a-button>
                </a-col>
            </a-row>
        </a-form>
        <s-table
            ref="table"
            :columns="columns"
            :data="loadData"
            :alert="options.alert.show"
            bordered
            :row-key="(record) => record.id"
            :tool-config="toolConfig"
            :row-selection="options.rowSelection"
        >
            <template #operator class="table-operator">
           <a-space>
                <a-button type="primary" @click="formRef.onOpen()" v-if="hasPerm('viidCascadePlatformAdd')">
                    <template #icon><plus-outlined /></template>
                    新增
                </a-button>
                <xn-batch-button
                    v-if="hasPerm('viidCascadePlatformBatchDelete')"
                    buttonName="批量删除"
                       icon="DeleteOutlined"
                    :selectedRowKeys="selectedRowKeys"
                    @batchCallBack="deleteBatchViidCascadePlatform"
                />
            </a-space>
            </template>
            <template #bodyCell="{ column, record }">
                <template v-if="column.dataIndex === 'isRegister'">
                    {{ $TOOL.dictTypeData('VIID_REGISTER', record.isRegister) }}
                </template>
                <template v-if="column.dataIndex === 'isOnline'">
                    {{ $TOOL.dictTypeData('VIID_ONLINE', record.isOnline) }}
                </template>
                <template v-if="column.dataIndex === 'type'">
                    {{ $TOOL.dictTypeData('VIID_TYPE', record.type) }}
                </template>
                <template v-if="column.dataIndex === 'action'">
                    <a @click="formRef.onOpen(record)" v-if="hasPerm('viidCascadePlatformEdit')">编辑</a>
                    <a-divider type="vertical" v-if="hasPerm(['viidCascadePlatformEdit', 'viidCascadePlatformDelete'], 'and')" />
                    <a v-if="record.type === '0'" @click="register(record)">注册</a>
                    <a-divider type="vertical" v-if="record.type === '0'" />
                    <a v-if="record.type === '0'" @click="unregister(record)">注销</a>
                    <a-divider type="vertical" v-if="record.type === '0' && hasPerm('viidCascadePlatformDelete')" />
                    <a-popconfirm title="确定要删除吗？" @confirm="deleteViidCascadePlatform(record)">
                        <a-button type="link" danger size="small" v-if="hasPerm('viidCascadePlatformDelete')">删除</a-button>
                    </a-popconfirm>
                </template>
            </template>
        </s-table>
    </a-card>
    <Form ref="formRef" @successful="table.refresh(true)" />
</template>

<script setup name="cascadeplatform">
    import { message } from 'ant-design-vue'
    import tool from '@/utils/tool'
    import Form from './form.vue'
    import viidCascadePlatformApi from '@/api/viid/viidCascadePlatformApi'
    let searchFormState = reactive({})
    const searchFormRef = ref()
    const table = ref()
    const formRef = ref()
    const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }
    const columns = [
        {
            title: '视图库ID',
            dataIndex: 'systemId'
        },
        {
            title: '视图库名称',
            dataIndex: 'name'
        },
        {
            title: 'IP地址',
            dataIndex: 'ipAddr'
        },
        {
            title: '端口',
            dataIndex: 'port'
        },
        {
            title: '是否注册',
            dataIndex: 'isRegister'
        },
        {
            title: '是否在线',
            dataIndex: 'isOnline'
        },
        {
            title: '最后在线时间',
            dataIndex: 'lastOnlineTime'
        },
        {
            title: '视图库类型',
            dataIndex: 'type'
        },
    ]
    // 操作栏通过权限判断是否显示
    if (hasPerm(['viidCascadePlatformEdit', 'viidCascadePlatformDelete'])) {
        columns.push({
            title: '操作',
            dataIndex: 'action',
            align: 'center',
            width: '200px'
        })
    }
    let selectedRowKeys = ref([])
    // 列表选择配置
    const options = {
        alert: {
            show: false,
            clear: () => {
                selectedRowKeys = ref([])
            }
        },
        rowSelection: {
            onChange: (selectedRowKey, selectedRows) => {
                selectedRowKeys.value = selectedRowKey
            }
        }
    }
    const loadData = (parameter) => {
        const searchFormParam = JSON.parse(JSON.stringify(searchFormState))
        return viidCascadePlatformApi.viidCascadePlatformPage(Object.assign(parameter, searchFormParam)).then((data) => {
            return data
        })
    }
    // 删除
    const deleteViidCascadePlatform = (record) => {
        let params = [
            {
                id: record.id
            }
        ]
        viidCascadePlatformApi.viidCascadePlatformDelete(params).then(() => {
            table.value.refresh(true)
        })
    }
    // 批量删除
    const deleteBatchViidCascadePlatform = () => {
        if (selectedRowKeys.value.length < 1) {
            message.warning('请选择一条或多条数据')
            return false
        }
        const params = selectedRowKeys.value.map((m) => {
            return {
                id: m
            }
        })
        viidCascadePlatformApi.viidCascadePlatformDelete(params).then(() => {
            table.value.clearRefreshSelected()
        })
    }
    // 注册功能
    const register = (record) => {
        viidCascadePlatformApi.registerSend(record.systemId).then(res => {
            if (res.success) {
                message.success(res.message)
                table.value.refresh()
            } else {
                message.error(res.message)
            }
        })
    }
    // 注销功能
    const unregister = (record) => {
        viidCascadePlatformApi.unregisterSend(record.systemId).then(res => {
            if (res.success) {
                message.success(res.message)
                table.value.refresh()
            } else {
                message.error(res.message)
            }
        })
    }
    const isOnlineOptions = tool.dictList('VIID_ONLINE')
    const typeOptions = tool.dictList('VIID_TYPE')
</script>
