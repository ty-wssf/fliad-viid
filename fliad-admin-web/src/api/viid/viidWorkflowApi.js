import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/workflow/` + url, ...arg)

/**
 * VIID工作流API
 */
export default {
	/**
	 * 分页查询VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	viidWorkflowPage: (parameter) => {
		return request('page', parameter, 'get')
	},
	/**
	 * 添加或编辑VIID工作流
	 * @param parameter
	 * @param edit
	 * @returns {*}
	 */
	viidWorkflowSubmitForm: (parameter, edit = false) => {
		return request(edit ? 'edit' : 'add', parameter)
	},
	/**
	 * 删除VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	viidWorkflowDelete: (parameter) => {
		return request('delete', parameter)
	},
	/**
	 * 获取VIID工作流详情
	 * @param parameter
	 * @returns {*}
	 */
	viidWorkflowDetail: (parameter) => {
		return request('detail', parameter, 'get')
	},
	/**
	 * 复制VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	viidWorkflowCopy: (parameter) => {
		return request('copy', parameter)
	},
	/**
	 * 禁用VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	disableWorkflow: (parameter) => {
		return request('disableWorkflow', parameter)
	},
	/**
	 * 启用VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	enableWorkflow: (parameter) => {
		return request('enableWorkflow', parameter)
	}
}