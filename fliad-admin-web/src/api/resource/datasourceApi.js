import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/resource/datasource/` + url, ...arg)

/**
 * 数据源Api接口管理器
 *
 * @author wyl
 * @date  2025/09/24 20:24
 **/
export default {
	// 获取数据源分页
	datasourcePage(data) {
		return request('page', data, 'get')
	},
	// 提交数据源表单 edit为true时为编辑，默认为新增
	datasourceSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除数据源
	datasourceDelete(data) {
		return request('delete', data)
	},
	// 获取数据源详情
	datasourceDetail(data) {
		return request('detail', data, 'get')
	},
	// 禁用数据源
	disableDatasource(data) {
		return request('disableDatasource', data)
	},
	// 启用数据源
	enableDatasource(data) {
		return request('enableDatasource', data)
	},
	// 复制数据源
	datasourceCopy(data) {
		return request('copy', data)
	},
	// 安装模板
	datasourceInstallTemplate(data) {
		return request('installTemplate', data)
	},
	// 获取模板列表
	datasourceTemplateList() {
		return request('templateList', {}, 'get')
	},
	// 将数据源转换为模板
	datasourceConvertToTemplate(data) {
		return request('convertToTemplate', data)
	}
}