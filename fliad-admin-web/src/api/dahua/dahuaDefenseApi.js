import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/dahua/defense/` + url, ...arg)

/**
 * 大华布防Api接口管理器
 *
 * @author wyl
 * @date  2025/09/27
 **/
export default {
	// 获取大华布防分页
	dahuaDefensePage(data) {
		return request('page', data, 'get')
	},
	// 提交大华布防表单 edit为true时为编辑，默认为新增
	dahuaDefenseSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除大华布防
	dahuaDefenseDelete(data) {
		return request('delete', data)
	},
	// 获取大华布防详情
	dahuaDefenseDetail(data) {
		return request('detail', data, 'get')
	},
	// 导出大华设备模板
	dahuaDefenseExportTemplate() {
		return request('export-template', {}, 'post', { responseType: 'blob' })
	},
	// 导入大华设备
	dahuaDefenseImport(data) {
		return request('import', data)
	},
	// 导出大华设备
	dahuaDefenseExport(data) {
		return request('export', data, 'get', { responseType: 'blob' })
	}
}