import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/cascadeplatform/` + url, ...arg)

/**
 * 视图库Api接口管理器
 *
 * @author wyl
 * @date  2025/08/14 16:24
 **/
export default {
	// 获取视图库分页
	viidCascadePlatformPage(data) {
		return request('page', data, 'get')
	},
	viidCascadePlatformList(data) {
		return request('list', data, 'get')
	},
	// 提交视图库表单 edit为true时为编辑，默认为新增
	viidCascadePlatformSubmitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},
	// 删除视图库
	viidCascadePlatformDelete(data) {
		return request('delete', data)
	},
	// 获取视图库详情
	viidCascadePlatformDetail(data) {
		return request('detail', data, 'get')
	},
	// 向上级平台注册
	registerSend(systemId) {
		return request('registerSend', { systemid: systemId }, 'post')
	},
	// 向上级平台注销
	unregisterSend(systemId) {
		return request('unregisterSend', { systemid: systemId }, 'post')
	}
}