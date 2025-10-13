import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/notification/` + url, ...arg)

/**
 * 订阅通知Api接口管理器
 *
 * @author wyl
 * @date  2025/09/22
 **/
export default {
	// 获取订阅通知分页
	viidSubscribeNotificationsPage(data) {
		return request('page', data, 'get')
	},
	// 提交订阅通知表单 edit为true时为编辑，默认为新增
	viidSubscribeNotificationsSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除订阅通知
	viidSubscribeNotificationsDelete(data) {
		return request('delete', data)
	},
	// 获取订阅通知详情
	viidSubscribeNotificationsDetail(data) {
		return request('detail', data, 'get')
	}
}