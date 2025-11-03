import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/hikvision/defense/` + url, ...arg)

/**
 * 海康布防Api接口管理器
 *
 * @author yubaoshan
 * @date  2025/09/27
 **/
export default {
	// 获取海康布防分页
	hikvisionDefensePage(data) {
		return request('page', data, 'get')
	},
	// 提交海康布防表单 edit为true时为编辑，默认为新增
	hikvisionDefenseSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除海康布防
	hikvisionDefenseDelete(data) {
		return request('delete', data)
	},
	// 获取海康布防详情
	hikvisionDefenseDetail(data) {
		return request('detail', data, 'get')
	},
	// 导出海康设备模板
	hikvisionDefenseExportTemplate() {
		return request('export-template', {}, 'post', { responseType: 'blob' })
	},
	// 导入海康设备
	hikvisionDefenseImport(data) {
		return request('import', data)
	}
}