import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/flow/definition/` + url, ...arg)

/**
 * 流程定义API
 */
export default {
  /**
   * 分页查询流程定义列表
   * @param parameter
   * @returns {*}
   */
  listDefinition: (parameter) => {
    return request('list', parameter, 'get')
  },

  /**
   * 获取流程定义详情
   * @param id
   * @returns {*}
   */
  getDefinition: (id) => {
    return request(id, {}, 'get')
  },

  /**
   * 新增流程定义
   * @param parameter
   * @returns {*}
   */
  addDefinition: (parameter) => {
    return request('', parameter, 'post')
  },

  /**
   * 修改流程定义
   * @param parameter
   * @returns {*}
   */
  updateDefinition: (parameter) => {
    return request('', parameter, 'put')
  },

  /**
   * 删除流程定义
   * @param ids
   * @returns {*}
   */
  delDefinition: (ids) => {
    return request(ids, {}, 'delete')
  },

  /**
   * 发布流程定义
   * @param id
   * @returns {*}
   */
  publish: (id) => {
    return request(`publish/${id}`, {}, 'get')
  },

  /**
   * 取消发布流程定义
   * @param id
   * @returns {*}
   */
  unPublish: (id) => {
    return request(`unPublish/${id}`, {}, 'get')
  },

  /**
   * 复制流程定义
   * @param id
   * @returns {*}
   */
  copyDef: (id) => {
    return request(`copyDef/${id}`, {}, 'get')
  },

  /**
   * 激活流程
   * @param id
   * @returns {*}
   */
  active: (id) => {
    return request(`active/${id}`, {}, 'get')
  },

  /**
   * 挂起流程
   * @param id
   * @returns {*}
   */
  unActive: (id) => {
    return request(`unActive/${id}`, {}, 'get')
  },

  /**
   * 导入流程定义
   * @param formData
   * @returns {*}
   */
  importDefinition: (formData) => {
    return request('importDefinition', formData, 'formdata')
  },

  /**
   * 导出流程定义
   * @param id
   * @returns {*}
   */
  exportDefinition: (id) => {
    return request(`exportDefinition/${id}`, {}, 'post')
  }
}