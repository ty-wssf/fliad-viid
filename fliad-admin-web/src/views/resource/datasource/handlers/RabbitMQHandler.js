export default {
  /**
   * 处理RabbitMQ数据源打开逻辑
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
          rabbitmqHost: config.host,
          rabbitmqPort: config.port,
          rabbitmqUsername: config.username,
          rabbitmqPassword: config.password,
          rabbitmqExchange: config.exchange,
          rabbitmqRoutingKey: config.routingKey,
          rabbitmqQueueName: config.queueName,
          scriptFilter: record.scriptFilter
        }
      } catch (e) {
        console.error('解析RabbitMQ配置失败', e)
      }
    }
    
    return { formData, typeSpecificData }
  },
  
  /**
   * 处理RabbitMQ数据源提交前的数据准备
   * @param formData 通用表单数据
   * @param typeSpecificData 特定类型表单数据
   * @returns {{formDataParam: object}}
   */
  handleSubmit(formData, typeSpecificData) {
    const formDataParam = {...formData, ...typeSpecificData}
    
    // 构造config对象
    const config = {
      host: formDataParam.rabbitmqHost,
      port: formDataParam.rabbitmqPort,
      username: formDataParam.rabbitmqUsername,
      password: formDataParam.rabbitmqPassword,
      exchange: formDataParam.rabbitmqExchange,
      routingKey: formDataParam.rabbitmqRoutingKey,
      queueName: formDataParam.rabbitmqQueueName
    }
    
    formDataParam.content = JSON.stringify(config)
    
    // 删除临时字段
    delete formDataParam.rabbitmqHost
    delete formDataParam.rabbitmqPort
    delete formDataParam.rabbitmqUsername
    delete formDataParam.rabbitmqPassword
    delete formDataParam.rabbitmqExchange
    delete formDataParam.rabbitmqRoutingKey
    delete formDataParam.rabbitmqQueueName
    
    return { formDataParam }
  },
  
  /**
   * 获取RabbitMQ表单验证规则
   * @returns {object}
   */
  getValidationRules() {
    return {
      rabbitmqHost: [{ required: true, message: '请输入RabbitMQ地址' }],
      rabbitmqPort: [{ required: true, message: '请输入RabbitMQ端口' }],
      rabbitmqUsername: [{ required: true, message: '请输入用户名' }],
      rabbitmqPassword: [{ required: true, message: '请输入密码' }],
      rabbitmqExchange: [{ required: true, message: '请输入Exchange' }],
      rabbitmqRoutingKey: [{ required: true, message: '请输入Routing Key' }],
      rabbitmqQueueName: [{ required: true, message: '请输入队列名' }]
    }
  }
}