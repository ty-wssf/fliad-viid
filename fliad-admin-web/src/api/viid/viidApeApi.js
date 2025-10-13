import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/ape/` + url, ...arg)

/**
 * 采集设备Api接口管理器
 *
 * @author wyl
 * @date  2025/09/19
 **/
export default {
	// 获取采集设备分页
	viidApePage(data) {
		return request('page', data, 'get')
	},
	// 提交采集设备表单 edit为true时为编辑，默认为新增
	viidApeSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除采集设备
	viidApeDelete(data) {
		return request('delete', data)
	},
	// 获取采集设备详情
	viidApeDetail(data) {
		return request('detail', data, 'get')
	}
}