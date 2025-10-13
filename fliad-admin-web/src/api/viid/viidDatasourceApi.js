import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/datasource/` + url, ...arg)

/**
 * 数据源Api接口管理器
 *
 * @author wyl
 * @date  2025/09/24 20:24
 **/
export default {
	// 获取数据源分页
	viidDatasourcePage(data) {
		return request('page', data, 'get')
	},
	// 提交数据源表单 edit为true时为编辑，默认为新增
	viidDatasourceSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除数据源
	viidDatasourceDelete(data) {
		return request('delete', data)
	},
	// 获取数据源详情
	viidDatasourceDetail(data) {
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
	viidDatasourceCopy(data) {
		return request('copy', data)
	}
}