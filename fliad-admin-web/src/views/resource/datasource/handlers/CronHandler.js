export default {
  /**
   * 处理Cron数据源打开逻辑
   * @param record 数据源记录
   * @returns {{formData: object, typeSpecificData: object}}
   */
  handleOpen(record) {
    const formData = {
      title: record.title,
      subscribeDetail: record.subscribeDetail,
      type: record.type,
      remark: record.remark,
      id: record.id,
      status: record.status
    }
    
    let typeSpecificData = {}
    
    if (record.content && typeof record.content === 'string') {
      try {
        const config = JSON.parse(record.content)
        typeSpecificData = {
          cronExpression: config.cronExpression,
          payload: config.payload
        }
      } catch (e) {
        console.error('解析Cron配置失败', e)
      }
    }
    
    return { formData, typeSpecificData }
  },
  
  /**
   * 处理Cron数据源提交前的数据准备
   * @param formData 通用表单数据
   * @param typeSpecificData 特定类型表单数据
   * @returns {{formDataParam: object}}
   */
  handleSubmit(formData, typeSpecificData) {
    const formDataParam = {...formData, ...typeSpecificData}
    
    // 构造config对象
    const config = {
      cronExpression: formDataParam.cronExpression,
      payload: formDataParam.payload
    }
    
    formDataParam.content = JSON.stringify(config)
    
    // 删除临时字段
    delete formDataParam.cronExpression
    delete formDataParam.payload
    
    return { formDataParam }
  },
  
  /**
   * 获取Cron表单验证规则
   * @returns {object}
   */
  getValidationRules() {
    return {
      cronExpression: [{ required: true, message: '请输入Cron表达式' }]
    }
  }
}