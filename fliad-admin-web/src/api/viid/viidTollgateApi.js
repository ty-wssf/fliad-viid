import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/viid/tollgate/` + url, ...arg)

/**
 * 视频卡口API
 */
export default {
	/**
	 * 分页查询视频卡口
	 * @param parameter
	 * @returns {*}
	 */
	viidTollgatePage: (parameter) => {
		return request('page', parameter, 'get')
	},
	/**
	 * 添加或编辑视频卡口
	 * @param parameter
	 * @param edit
	 * @returns {*}
	 */
	viidTollgateSubmitForm: (parameter, edit = false) => {
		return request(edit ? 'edit' : 'add', parameter)
	},
	/**
	 * 删除视频卡口
	 * @param parameter
	 * @returns {*}
	 */
	viidTollgateDelete: (parameter) => {
		return request('delete', parameter)
	},
	/**
	 * 获取视频卡口详情
	 * @param parameter
	 * @returns {*}
	 */
	viidTollgateDetail: (parameter) => {
		return request('detail', parameter, 'get')
	}
}