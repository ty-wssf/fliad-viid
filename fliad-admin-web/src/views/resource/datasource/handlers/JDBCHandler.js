export default {
  /**
   * 处理JDBC数据源打开逻辑
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
          jdbcDriverClassName: config.driverClassName,
          jdbcUrl: config.jdbcUrl,
          jdbcUsername: config.username,
          jdbcPassword: config.password,
          jdbcDataSourceName: config.dataSourceName
        }
      } catch (e) {
        console.error('解析JDBC配置失败', e)
      }
    }
    
    return { formData, typeSpecificData }
  },
  
  /**
   * 处理JDBC数据源提交前的数据准备
   * @param formData 通用表单数据
   * @param typeSpecificData 特定类型表单数据
   * @returns {{formDataParam: object}}
   */
  handleSubmit(formData, typeSpecificData) {
    const formDataParam = {...formData, ...typeSpecificData}
    
    // 构造config对象
    const config = {
      driverClassName: formDataParam.jdbcDriverClassName,
      jdbcUrl: formDataParam.jdbcUrl,
      username: formDataParam.jdbcUsername,
      password: formDataParam.jdbcPassword,
      dataSourceName: formDataParam.jdbcDataSourceName
    }
    
    formDataParam.content = JSON.stringify(config)
    
    // 删除临时字段
    delete formDataParam.jdbcDriverClassName
    delete formDataParam.jdbcUrl
    delete formDataParam.jdbcUsername
    delete formDataParam.jdbcPassword
    delete formDataParam.jdbcDataSourceName
    
    return { formDataParam }
  },
  
  /**
   * 获取JDBC表单验证规则
   * @returns {object}
   */
  getValidationRules() {
    return {
      jdbcDriverClassName: [{ required: true, message: '请输入驱动类名' }],
      jdbcUrl: [{ required: true, message: '请输入数据库URL' }],
      jdbcUsername: [{ required: true, message: '请输入用户名' }],
      jdbcPassword: [{ required: true, message: '请输入密码' }],
      jdbcDataSourceName: [{ required: true, message: '请输入数据源名称' }]
    }
  }
}