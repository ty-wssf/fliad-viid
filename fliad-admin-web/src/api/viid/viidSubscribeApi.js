import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/subscribe/` + url, ...arg)

/**
 * 订阅下发Api接口管理器
 *
 * @author wyl
 * @date  2025/08/22 15:00
 **/
export default {
	// 获取订阅下发分页
	viidSubscribePage(data) {
		return request('page', data, 'get')
	},
	// 提交订阅下发表单 edit为true时为编辑，默认为新增
	viidSubscribeSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除订阅下发
	viidSubscribeDelete(data) {
		return request('delete', data)
	},
	// 获取订阅下发详情
	viidSubscribeDetail(data) {
		return request('detail', data, 'get')
	},
	// 向下级发送订阅请求
	subscribeSend(data) {
		return request('send', data, 'post')
	},
	// 向下级发送取消订阅请求
	subscribeCancel(data) {
		return request('cancel', data, 'post')
	}
}
