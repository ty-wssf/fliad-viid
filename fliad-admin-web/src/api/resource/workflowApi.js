import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/resource/workflow/` + url, ...arg)

/**
 * VIID工作流API
 */
export default {
	/**
	 * 分页查询VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	workflowPage: (parameter) => {
		return request('page', parameter, 'get')
	},
	/**
	 * 添加或编辑VIID工作流
	 * @param parameter
	 * @param edit
	 * @returns {*}
	 */
	workflowSubmitForm: (parameter, edit = false) => {
		return request(edit ? 'edit' : 'add', parameter)
	},
	/**
	 * 删除VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	workflowDelete: (parameter) => {
		return request('delete', parameter)
	},
	/**
	 * 获取VIID工作流详情
	 * @param parameter
	 * @returns {*}
	 */
	workflowDetail: (parameter) => {
		return request('detail', parameter, 'get')
	},
	/**
	 * 导出工作流为data-init.xml格式
	 * @param parameter
	 * @returns {*}
	 */
	workflowExportDataInit: (parameter) => {
		return request('exportDataInit', parameter, 'get')
	},
	/**
	 * 复制VIID工作流
	 * @param parameter
	 * @returns {*}
	 */
	workflowCopy: (parameter) => {
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
	},
	/**
	 * 安装模板
	 * @param parameter
	 * @returns {*}
	 */
	workflowInstallTemplate: (parameter) => {
		return request('installTemplate', parameter)
	},
	/**
	 * 获取模板列表
	 * @returns {*}
	 */
	workflowTemplateList: () => {
		return request('templateList', {}, 'get')
	},
	/**
	 * 将工作流转换为模板
	 * @param parameter
	 * @returns {*}
	 */
	workflowConvertToTemplate: (parameter) => {
		return request('convertToTemplate', parameter)
	}
}