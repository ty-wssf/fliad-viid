import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/report/` + url, ...arg)

/**
 * 报表演示相关接口
 *
 * @author wyl
 * @date  2025/09/24 20:24
 **/
export default {
	// 获取报表示例列表
	getDemoReports(data) {
		return request('getDemoReports', data, 'get')
	},
	// 渲染报表HTML
	renderHtml(data) {
		return request('renderHtml', data)
	}
}
