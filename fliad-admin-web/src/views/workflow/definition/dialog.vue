<template>
  <a-drawer
    :title="title"
    :width="800"
    :visible="open"
    :destroy-on-close="true"
    :footer-style="{ textAlign: 'right' }"
    @close="onClose"
  >
    <a-tabs v-model:activeKey="tabsValue">
      <a-tab-pane key="1" tab="基础设置"></a-tab-pane>
      <a-tab-pane key="2" tab="监听器"></a-tab-pane>
    </a-tabs>
    
    <a-form ref="formRef" :model="formData" :rules="formRules" layout="vertical">
      <div v-show="tabsValue === '1'">
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="流程编码" name="flowCode">
              <a-input 
                v-model:value="formData.flowCode" 
                placeholder="请输入流程编码" 
                :maxlength="40"
                :disabled="!!formData.id"
              />
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="流程名称" name="flowName">
              <a-input 
                v-model:value="formData.flowName" 
                placeholder="请输入流程名称" 
                :maxlength="100"
              />
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="设计器模型" name="modelValue">
              <a-radio-group v-model:value="formData.modelValue" :disabled="!!formData.id">
                <a-radio value="CLASSICS">经典模型</a-radio>
                <a-radio value="MIMIC">
                  仿钉钉模型
                  <span style="color: #ff4949; margin-left: 50px;">保存后不支持修改！</span>
                </a-radio>
              </a-radio-group>
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="流程类别" name="category">
              <a-input 
                v-model:value="formData.category" 
                placeholder="请输入流程类别" 
                :maxlength="20"
              />
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24" v-if="disabled">
          <a-col :span="24">
            <a-form-item label="是否发布" name="isPublish">
              <a-select v-model:value="formData.isPublish" placeholder="请选择是否开启流程">
                <a-select-option :value="0">未发布</a-select-option>
                <a-select-option :value="1">已发布</a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24">
          <a-col :span="24">
            <a-form-item label="审批表单是否自定义" name="formCustom">
              <a-select v-model:value="formData.formCustom" placeholder="请选择表单类型" allow-clear>
                <a-select-option value="N">表单路径</a-select-option>
                <!-- <a-select-option value="Y">动态表单</a-select-option> -->
              </a-select>
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24" v-if="formData.formCustom === 'N'">
          <a-col :span="24">
            <a-form-item label="审批表单路径" name="formPath">
              <a-input 
                v-model:value="formData.formPath" 
                placeholder="请输入审批表单路径" 
                :maxlength="100"
              />
            </a-form-item>
          </a-col>
        </a-row>
        
        <a-row :gutter="24" v-else-if="formData.formCustom === 'Y'">
          <a-col :span="24">
            <a-form-item label="审批流程表单" name="formPath">
              <a-select v-model:value="formData.formPath" placeholder="请选择表单">
                <a-select-option 
                  v-for="item in definitionList" 
                  :key="item.id" 
                  :value="item.id"
                >
                  {{ item.formName }} - v{{ item.version }}
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
        </a-row>
      </div>
      
      <div v-show="tabsValue === '2'">
        <a-form-item name="listenerRows">
          <a-table 
            :dataSource="formData.listenerRows" 
            :columns="listenerColumns" 
            :pagination="false"
            size="small"
          >
            <template #bodyCell="{ column, record, index }">
              <template v-if="column.dataIndex === 'listenerType'">
                <a-form-item 
                  :name="['listenerRows', index, 'listenerType']"
                  :rules="formRules.listenerType"
                >
                  <a-select 
                    v-model:value="record.listenerType" 
                    placeholder="请选择类型"
                    style="width: 100%"
                  >
                    <a-select-option value="start">开始</a-select-option>
                    <a-select-option value="assignment">分派</a-select-option>
                    <a-select-option value="finish">完成</a-select-option>
                    <a-select-option value="create">创建</a-select-option>
                  </a-select>
                </a-form-item>
              </template>
              
              <template v-if="column.dataIndex === 'listenerPath'">
                <a-form-item 
                  :name="['listenerRows', index, 'listenerPath']"
                  :rules="formRules.listenerPath"
                >
                  <a-input 
                    v-model:value="record.listenerPath" 
                    placeholder="请输入路径"
                  />
                </a-form-item>
              </template>
              
              <template v-if="column.dataIndex === 'action' && !disabled">
                <a-button 
                  type="danger" 
                  size="small" 
                  @click="handleDeleteRow(index)"
                >
                  删除
                </a-button>
              </template>
            </template>
          </a-table>
          
          <a-button 
            v-if="!disabled" 
            type="primary" 
            @click="handleAddRow" 
            style="margin-top: 10px;"
          >
            增加行
          </a-button>
        </a-form-item>
      </div>
    </a-form>
    
    <template #footer>
      <a-button @click="onClose" v-if="disabled">关 闭</a-button>
      <template v-else>
        <a-button @click="onClose">取 消</a-button>
        <a-button type="primary" @click="submitForm" :loading="submitLoading">确 定</a-button>
      </template>
    </template>
  </a-drawer>
</template>

<script setup name="Dialog">
import { ref, reactive, onMounted } from 'vue'
import { message } from 'ant-design-vue'
import { cloneDeep } from 'lodash-es'
import workflowDefinitionApi from '@/api/workflow/definition'

// 抽屉状态
const open = ref(false)
const submitLoading = ref(false)
const disabled = ref(false)
const title = ref("")
const tabsValue = ref("1")

// 表单引用
const formRef = ref()

// 表单数据
const formData = ref({
  listenerRows: []
})

// 定义列表（用于表单选择）
const definitionList = ref([])

// 监听器表格列
const listenerColumns = [
  {
    title: '类型',
    dataIndex: 'listenerType',
    width: '150px'
  },
  {
    title: '路径',
    dataIndex: 'listenerPath'
  },
  {
    title: '操作',
    dataIndex: 'action',
    width: '80px'
  }
]

// 表单校验规则
const formRules = {
  flowCode: [
    { required: true, message: "流程编码不能为空", trigger: "blur" }
  ],
  flowName: [
    { required: true, message: "流程名称不能为空", trigger: "blur" }
  ],
  isPublish: [
    { required: true, message: "是否开启流程不能为空", trigger: "change" }
  ],
  formCustom: [
    { required: true, message: "请选择审批表单是否自定义", trigger: "change" }
  ],
  listenerType: [
    { required: true, message: '监听器类型不能为空', trigger: ['change', 'blur'] }
  ],
  listenerPath: [
    { required: true, message: '监听器路径不能为空', trigger: ['change', 'blur'] }
  ]
}

// 打开流程定义弹框
const show = async (id, isDisabled = false) => {
  reset()
  disabled.value = isDisabled
  
  if (id) {
    try {
      const response = await workflowDefinitionApi.getDefinition(id)
      formData.value = response.data
      
      // 处理监听器数据
      if (formData.value.listenerType) {
        const listenerTypes = formData.value.listenerType.split(",")
        const listenerPaths = formData.value.listenerPath.split("@@")
        formData.value.listenerRows = listenerTypes.map((type, index) => ({
          listenerType: type,
          listenerPath: listenerPaths[index]
        }))
      } else {
        formData.value.listenerRows = []
      }
    } catch (error) {
      message.error("获取流程定义详情失败")
      return
    }
  }
  
  open.value = true
  title.value = isDisabled ? "详情" : (id ? "修改" : "新增")
}

// 查询表单定义列表
const getDefinition = () => {
  // TODO: 实现获取已发布的流程定义列表
  console.log("获取已发布的流程定义列表")
}

// 取消按钮
const onClose = () => {
  open.value = false
  reset()
}

// 表单重置
const reset = () => {
  formData.value = {
    id: null,
    flowCode: null,
    flowName: null,
    modelValue: '',
    version: null,
    isPublish: null,
    formCustom: null,
    formPath: null,
    createTime: null,
    updateTime: null,
    delFlag: null,
    listenerRows: []
  }
  
  if (formRef.value) {
    formRef.value.resetFields()
  }
  
  tabsValue.value = "1"
}

// 提交按钮
const submitForm = () => {
  formRef.value.validate().then(() => {
    submitLoading.value = true
    
    // 处理监听器数据
    const form = cloneDeep(formData.value)
    if (form.listenerRows && form.listenerRows.length > 0) {
      form.listenerType = form.listenerRows.map(row => row.listenerType).join(",")
      form.listenerPath = form.listenerRows.map(row => row.listenerPath).join("@@")
    }
    
    // 提交数据
    const request = form.id 
      ? workflowDefinitionApi.updateDefinition(form)
      : workflowDefinitionApi.addDefinition(form)
      
    request.then(() => {
      message.success(form.id ? "修改成功" : "新增成功")
      open.value = false
      emits('refresh')
    }).catch(() => {
      message.error(form.id ? "修改失败" : "新增失败")
    }).finally(() => {
      submitLoading.value = false
    })
  }).catch(error => {
    console.log("表单校验失败:", error)
    // 切换到包含错误的标签页
    tabsValue.value = "1"
  })
}

// 增加行
const handleAddRow = () => {
  formData.value.listenerRows.push({ listenerType: '', listenerPath: '' })
  if (formRef.value) {
    formRef.value.clearValidate("listenerRows")
  }
}

// 删除行
const handleDeleteRow = (index) => {
  formData.value.listenerRows.splice(index, 1)
}

// 定义 emits
const emits = defineEmits(['refresh'])

// 暴露方法给父组件
defineExpose({
  show
})

onMounted(() => {
  // 组件挂载后执行
})
</script>

<style scoped>
:deep(.ant-tabs) {
  margin-top: -20px;
}

:deep(.ant-form-item) {
  margin-bottom: 12px;
}
</style>