export default {
  /**
   * 处理HTTP数据源打开逻辑
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
          httpPath: config.path,
          httpMethod: config.method,
          scriptFilter: record.scriptFilter
        }
      } catch (e) {
        console.error('解析HTTP配置失败', e)
      }
    }

    return { formData, typeSpecificData }
  },

  /**
   * 处理HTTP数据源提交前的数据准备
   * @param formData 通用表单数据
   * @param typeSpecificData 特定类型表单数据
   * @returns {{formDataParam: object}}
   */
  handleSubmit(formData, typeSpecificData) {
    const formDataParam = {...formData, ...typeSpecificData}

    // 构造config对象
    const config = {
      path: formDataParam.httpPath,
      method: formDataParam.httpMethod
    }

    formDataParam.content = JSON.stringify(config)

    // 删除临时字段
    delete formDataParam.httpPath
    delete formDataParam.httpMethod

    return { formDataParam }
  },

  /**
   * 获取HTTP表单验证规则
   * @returns {object}
   */
  getValidationRules() {
    return {
      httpPath: [{ required: true, message: '请输入接口路径' }]
    }
  }
}
