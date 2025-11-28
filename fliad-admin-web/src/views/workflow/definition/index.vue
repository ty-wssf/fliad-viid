<template>
  <a-card :bordered="false">
    <a-form ref="searchFormRef" :model="searchFormState" class="ant-advanced-search-form mb-4">
      <a-row :gutter="24">
        <a-col :span="6">
          <a-form-item label="流程编码" name="flowCode">
            <a-input v-model:value="searchFormState.flowCode" placeholder="请输入流程编码" />
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label="流程名称" name="flowName">
            <a-input v-model:value="searchFormState.flowName" placeholder="请输入流程名称" />
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label="流程类别" name="category">
            <a-input v-model:value="searchFormState.category" placeholder="请输入流程类别" />
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
          <a-button type="primary" @click="handleAdd1" v-if="hasPerm('flow:definition:add')">
            <template #icon><plus-outlined /></template>
            新增①
          </a-button>
          <a-button type="primary" @click="handleAdd2" v-if="hasPerm('flow:definition:add')">
            <template #icon><plus-outlined /></template>
            新增②
          </a-button>
          <a-button @click="handleImport" v-if="hasPerm('flow:definition:importDefinition')">
            <template #icon><upload-outlined /></template>
            导入流程定义
          </a-button>
        </a-space>
      </template>

      <template #bodyCell="{ column, record }">
        <template v-if="column.dataIndex === 'flowCode'">
          <span :title="record.flowCode">{{ record.flowCode }}</span>
        </template>

        <template v-if="column.dataIndex === 'flowName'">
          <span :title="record.flowName">{{ record.flowName }}</span>
        </template>

        <template v-if="column.dataIndex === 'version'">
          <a-tag>{{ record.version }}</a-tag>
        </template>

        <template v-if="column.dataIndex === 'modelValue'">
          <a-tag v-if="record.modelValue === 'CLASSICS'">经典模型</a-tag>
          <a-tag v-else-if="record.modelValue === 'MIMIC'">仿钉钉模型</a-tag>
          <span v-else>{{ record.modelValue }}</span>
        </template>

        <template v-if="column.dataIndex === 'category'">
          <span :title="record.category">{{ record.category }}</span>
        </template>

        <template v-if="column.dataIndex === 'isPublish'">
          <a-tag :color="record.isPublish === 1 ? 'green' : 'red'">
            {{ record.isPublish === 1 ? '已发布' : '未发布' }}
          </a-tag>
        </template>

        <template v-if="column.dataIndex === 'activityStatus'">
          <a-tag :color="record.activityStatus === 1 ? 'green' : 'orange'">
            {{ record.activityStatus === 1 ? '已激活' : '已挂起' }}
          </a-tag>
        </template>

        <template v-if="column.dataIndex === 'createTime'">
          {{ parseTime(record.createTime) }}
        </template>

        <template v-if="column.dataIndex === 'action'">
          <a @click="handleUpdate(record.id)" v-if="record.isPublish === 0 && hasPerm('flow:definition:edit')">修改</a>
          <a-divider type="vertical" v-if="record.isPublish === 0 && hasPerm('flow:definition:edit')" />

          <a @click="handleDesign(record.id)" v-if="hasPerm('flow:definition:queryDesign')">流程设计①</a>
          <a-divider type="vertical" v-if="hasPerm('flow:definition:queryDesign')" />

          <a @click="handleDesign(record.id, true)" v-if="hasPerm('flow:definition:queryDesign')">流程设计②</a>
          <a-divider type="vertical" v-if="hasPerm('flow:definition:queryDesign')" />

          <a @click="handleDesign(record.id, false, true)" v-if="hasPerm('flow:definition:queryDesign')">查看流程图①</a>
          <a-divider type="vertical" v-if="hasPerm('flow:definition:queryDesign')" />

          <a @click="handleDesign(record.id, true, true)" v-if="hasPerm('flow:definition:queryDesign')">查看流程图②</a>
          <a-divider type="vertical" v-if="hasPerm('flow:definition:queryDesign') && record.isPublish === 0" />

          <a @click="handlePublish(record.id)" v-if="record.isPublish === 0 && hasPerm('flow:definition:publish')">发布</a>
          <a-divider type="vertical" v-if="record.isPublish === 0 && hasPerm('flow:definition:publish') && record.isPublish === 1" />

          <a @click="handleUpPublish(record.id)" v-if="record.isPublish === 1 && hasPerm('flow:definition:upPublish')">取消发布</a>
          <a-divider type="vertical" v-if="record.isPublish === 1 && hasPerm('flow:definition:upPublish') && record.activityStatus === 0" />

          <a @click="toActive(record.id)" v-if="record.activityStatus === 0">激活</a>
          <a-divider type="vertical" v-if="record.activityStatus === 0 && record.activityStatus === 1" />

          <a @click="toUnActive(record.id)" v-if="record.activityStatus === 1">挂起</a>
          <a-divider type="vertical" v-if="record.activityStatus === 1" />

          <a @click="handleCopyDef(record.id)" v-if="hasPerm('flow:definition:upPublish')">复制流程</a>
          <a-divider type="vertical" v-if="hasPerm('flow:definition:upPublish')" />

          <a @click="handleExport(record)" v-if="hasPerm('flow:definition:exportDefinition')">导出流程</a>
          <a-divider type="vertical" v-if="hasPerm('flow:definition:exportDefinition') && record.isPublish === 0" />

          <a-popconfirm
            v-if="record.isPublish === 0 && hasPerm('flow:definition:remove')"
            title="确定要删除吗？"
            @confirm="handleDelete(record)">
            <a-button type="link" danger size="small">删除</a-button>
          </a-popconfirm>
        </template>
      </template>
    </s-table>

    <Dialog ref="dialogRef" @refresh="table.refresh(true)" />

    <!-- 导入对话框 -->
    <a-modal
      :title="upload.title"
      :visible="upload.open"
      :confirm-loading="upload.isUploading"
      @ok="submitFileForm"
      @cancel="upload.open = false"
      :maskClosable="false"
    >
      <a-upload-dragger
        ref="uploadRef"
        :multiple="true"
        :max-count="20"
        accept=".json"
        :headers="upload.headers"
        :action="upload.url"
        :disabled="upload.isUploading"
        @change="handleFileChange"
        :before-upload="beforeUpload"
        :show-upload-list="true"
      >
        <p class="ant-upload-drag-icon">
          <inbox-outlined />
        </p>
        <p class="ant-upload-text">将文件拖到此处，或点击上传</p>
        <p class="ant-upload-hint">仅允许导入json格式文件。</p>
      </a-upload-dragger>
    </a-modal>

    <a-modal
      title="流程图"
      :visible="flowChart.visible"
      :footer="null"
      @cancel="flowChart.visible = false"
      width="80%"
    >
      <img :src="flowChart.imgUrl" width="100%" style="margin:0 auto"/>
    </a-modal>
  </a-card>
</template>

<script setup name="Definition">
import { ref, reactive, onMounted } from 'vue'
import { message } from 'ant-design-vue'
import Dialog from "./dialog.vue"
import tool from '@/utils/tool'
import workflowDefinitionApi from '@/api/workflow/definition'

const searchFormRef = ref()
const table = ref()
const dialogRef = ref()
const uploadRef = ref()

// 搜索表单状态
const searchFormState = reactive({})

// 工具栏配置
const toolConfig = { refresh: true, height: true, columnSetting: true, striped: false }

// 表格列定义
const columns = [
  {
    title: '序号',
    dataIndex: 'id',
    customRender: ({ index }) => `${index + 1}`
  },
  {
    title: '流程编码',
    dataIndex: 'flowCode',
    ellipsis: true
  },
  {
    title: '流程名称',
    dataIndex: 'flowName',
    ellipsis: true
  },
  {
    title: '流程版本',
    dataIndex: 'version'
  },
  {
    title: '模型类型',
    dataIndex: 'modelValue'
  },
  {
    title: '流程类别',
    dataIndex: 'category',
    ellipsis: true
  },
  {
    title: '是否发布',
    dataIndex: 'isPublish'
  },
  {
    title: '激活状态',
    dataIndex: 'activityStatus'
  },
  {
    title: '创建时间',
    dataIndex: 'createTime'
  },
  {
    title: '操作',
    dataIndex: 'action',
    align: 'center',
    width: '300px'
  }
]

// 选中行的键值
const selectedRowKeys = ref([])

// 列表选择配置
const options = {
  alert: {
    show: false,
    clear: () => {
      selectedRowKeys.value = []
    }
  },
  rowSelection: {
    onChange: (selectedRowKey, selectedRows) => {
      selectedRowKeys.value = selectedRowKey
    }
  }
}

// 上传参数
const upload = reactive({
  open: false,
  title: '',
  isUploading: false,
  headers: { Authorization: "Bearer " + tool.data.get('TOKEN') },
  url: process.env.VUE_APP_BASE_API + "/flow/definition/importDefinition"
})

// 流程图查看
const flowChart = reactive({
  visible: false,
  imgUrl: ""
})

// 加载数据
const loadData = (parameter) => {
  const searchFormParam = JSON.parse(JSON.stringify(searchFormState))
  return workflowDefinitionApi.listDefinition(Object.assign(parameter, searchFormParam)).then((data) => {
    return data
  })
}

// 搜索
const handleQuery = () => {
  table.value.refresh(true)
}

// 重置搜索
const resetQuery = () => {
  searchFormRef.value.resetFields()
  handleQuery()
}

// 新增按钮操作①
const handleAdd1 = () => {
  // TODO: 实现流程设计页面跳转
  console.log('新增流程定义①')
}

// 新增按钮操作②
const handleAdd2 = () => {
  dialogRef.value.show()
}

// 修改按钮操作
const handleUpdate = (id) => {
  dialogRef.value.show(id)
}

// 设计按钮
const handleDesign = (id, onlyDesignShow, disabled) => {
  // TODO: 实现流程设计页面跳转
  console.log('流程设计', id, onlyDesignShow, disabled)
}

// 发布按钮操作
const handlePublish = (id) => {
  workflowDefinitionApi.publish(id).then(() => {
    message.success("发布成功")
    table.value.refresh(true)
  })
}

// 取消发布按钮操作
const handleUpPublish = (id) => {
  workflowDefinitionApi.unPublish(id).then(() => {
    message.success("取消发布成功")
    table.value.refresh(true)
  })
}

// 删除按钮操作
const handleDelete = (record) => {
  const ids = record.id
  workflowDefinitionApi.delDefinition(ids).then(() => {
    message.success("删除成功")
    table.value.refresh(true)
  })
}

// 复制流程按钮操作
const handleCopyDef = (id) => {
  workflowDefinitionApi.copyDef(id).then(() => {
    message.success("复制成功")
    table.value.refresh(true)
  })
}

// 导入按钮操作
const handleImport = () => {
  upload.title = "导入流程定义"
  upload.open = true
}

// 导出按钮操作
const handleExport = (record) => {
  // TODO: 实现导出功能
  console.log('导出流程', record)
}

// 文件上传处理
const handleFileChange = ({ file, fileList }) => {
  if (file.status === 'done') {
    message.success(`${file.name} 上传成功`);
    upload.open = false
    table.value.refresh(true)
  } else if (file.status === 'error') {
    message.error(`${file.name} 上传失败`);
  }
}

// 上传前检查
const beforeUpload = (file) => {
  const isJson = file.type === 'application/json' || file.name.endsWith('.json')
  if (!isJson) {
    message.error('只能上传JSON文件!')
  }
  return isJson
}

// 提交上传文件
const submitFileForm = () => {
  uploadRef.value.$refs.uploadRef.post()
}

// 激活流程
const toActive = (id) => {
  workflowDefinitionApi.active(id).then(() => {
    message.success("激活成功")
    table.value.refresh(true)
  })
}

// 挂起流程
const toUnActive = (id) => {
  workflowDefinitionApi.unActive(id).then(() => {
    message.success("挂起成功")
    table.value.refresh(true)
  })
}

// 时间格式化工具函数
const parseTime = (time) => {
  if (!time) return ''
  const date = new Date(time)
  return date.toLocaleString()
}

onMounted(() => {
  // 页面加载完成后获取数据
})
</script>
