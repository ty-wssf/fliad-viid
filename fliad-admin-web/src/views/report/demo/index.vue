<template>
	<div class="report-demo-container">
		<a-row :gutter="16" class="full-height-row">
			<a-col :span="collapsed ? 2 : 5" class="left-panel">
				<a-card
					:title="collapsed ? '' : '报表示例列表'"
					:bordered="false"
					class="tree-card"
				>
					<template #extra>
						<a-tooltip :title="collapsed ? '展开面板' : '折叠面板'">
							<a-button type="text" size="small" @click="toggleCollapse">
								<template #icon>
									<menu-fold-outlined v-if="!collapsed" />
									<menu-unfold-outlined v-else />
								</template>
							</a-button>
						</a-tooltip>
					</template>
					<div v-show="!collapsed" class="tree-container">
						<a-input-search
							v-if="reportTreeData.length > 0"
							v-model:value="searchValue"
							placeholder="搜索报表..."
							style="margin-bottom: 12px"
							@search="onSearch"
						/>
						<a-tree
							v-if="filteredTreeData.length > 0"
							:tree-data="filteredTreeData"
							:fieldNames="{ title: 'label', key: 'key', children: 'children' }"
							@select="onSelectReport"
							:defaultExpandAll="true"
							class="report-tree"
						>
							<template #title="{ label }">
								<span class="tree-node-label">{{ label }}</span>
							</template>
						</a-tree>
						<a-empty v-else description="暂无报表示例" />
					</div>
					<div v-show="collapsed" class="collapsed-hint">
						<div class="hint-text">点击展开</div>
					</div>
				</a-card>
			</a-col>

			<a-col :span="collapsed ? 22 : 18" class="right-panel">
				<a-card
					:title="selectedReportName || '报表预览'"
					:bordered="false"
					class="preview-card"
				>
					<template #extra>
						<div class="action-buttons">
							<a-tooltip title="刷新报表">
								<a-button
									type="text"
									size="small"
									:disabled="!selectedReportPath"
									@click="refreshReport"
								>
									<template #icon>
										<reload-outlined />
									</template>
								</a-button>
							</a-tooltip>
							<a-button
								type="primary"
								:disabled="!selectedReportPath"
								@click="exportReport"
							>
								<template #icon>
									<export-outlined />
								</template>
								导出XLSX
							</a-button>
						</div>
					</template>

					<!-- 使用 iframe 替代原来的 v-html 方式 -->
					<div v-if="selectedReportPath" class="report-preview-container">
						<div v-if="loading" class="loading-container">
							<a-spin size="large" tip="报表加载中..." />
						</div>
						<iframe
							v-show="!loading"
							:key="iframeKey"
							:src="iframeSrc"
							class="report-iframe"
							frameborder="0"
							@load="onIframeLoad"
							ref="reportIframe"
						></iframe>
					</div>
					<div v-else class="empty-state">
						<a-empty
							description="请从左侧选择报表示例进行预览"
							:image="simpleImage"
						>
							<template #description>
								<div class="empty-description">
									<div>请从左侧选择报表示例进行预览</div>
									<small class="empty-hint">如果左侧面板已折叠，请点击展开按钮</small>
								</div>
							</template>
						</a-empty>
					</div>
				</a-card>
			</a-col>
		</a-row>
	</div>
</template>

<script>
import {defineComponent, ref, onMounted, computed} from 'vue'
import {
	MenuFoldOutlined,
	MenuUnfoldOutlined,
	ReloadOutlined,
	ExportOutlined
} from '@ant-design/icons-vue'
import { Empty } from 'ant-design-vue'
import reportApi from '@/api/report/demo'
import downloadUtil from "@/utils/downloadUtil";
import sysConfig from '@/config/index'

export default defineComponent({
	name: 'ReportDemo',
	components: {
		MenuFoldOutlined,
		MenuUnfoldOutlined,
		ReloadOutlined,
		ExportOutlined
	},
	setup() {
		const reportTreeData = ref([])
		const iframeSrc = ref('')
		const iframeKey = ref(0)
		const selectedReportName = ref('')
		const selectedReportPath = ref('')
		const collapsed = ref(false)
		const loading = ref(false)
		const searchValue = ref('')
		const reportIframe = ref(null)
		const simpleImage = Empty.PRESENTED_IMAGE_SIMPLE

		// 计算属性：过滤树数据
		const filteredTreeData = computed(() => {
			if (!searchValue.value) {
				return reportTreeData.value
			}

			const filterNodes = (nodes) => {
				return nodes.filter(node => {
					// 如果节点本身匹配
					if (node.label && node.label.toLowerCase().includes(searchValue.value.toLowerCase())) {
						return true
					}

					// 如果子节点有匹配的，也保留该节点
					if (node.children && node.children.length > 0) {
						const filteredChildren = filterNodes(node.children)
						if (filteredChildren.length > 0) {
							// 创建新对象避免修改原始数据
							return {
								...node,
								children: filteredChildren
							}
						}
					}

					return false
				}).map(node => {
					// 确保不修改原始节点
					if (node.children && node.children.length > 0) {
						const filteredChildren = filterNodes(node.children)
						return {
							...node,
							children: filteredChildren
						}
					}
					return node
				})
			}

			return filterNodes(reportTreeData.value)
		})

		// 切换收缩状态
		const toggleCollapse = () => {
			collapsed.value = !collapsed.value
		}

		// 获取报表示例列表
		const loadReportList = async () => {
			try {
				const res = await reportApi.getDemoReports()
				// 转换数据格式以适配 Ant Design Vue Tree 组件
				reportTreeData.value = res
			} catch (err) {
				console.error('获取报表示例列表失败:', err)
			}
		}

		// 搜索报表
		const onSearch = () => {
			// 计算属性会自动更新，无需额外操作
		}

		// 选择报表示例
		const onSelectReport = async (selectedKeys, event) => {
			const node = event.node
			if (node.value) {
				selectedReportName.value = node.label
				selectedReportPath.value = node.value
				// 使用 iframe 方式加载报表
				renderReportWithIframe(node.value)
			}
		}

		// 使用 iframe 渲染报表
		const renderReportWithIframe = (reportPath) => {
			loading.value = true
			// 构造后端 renderHtmlGet 接口的 URL
			const baseUrl = sysConfig.API_URL || ''
			const newSrc = `${baseUrl}/report/renderHtml?reportName=${encodeURIComponent(reportPath)}`

			// 如果 iframeSrc 已经有值，则强制刷新 iframe
			if (iframeSrc.value) {
				iframeSrc.value = ''
				// 使用 nextTick 确保 DOM 更新后再设置新值
				setTimeout(() => {
					iframeSrc.value = newSrc
					iframeKey.value++
				}, 10)
			} else {
				iframeSrc.value = newSrc
				iframeKey.value++
			}
		}

		// 刷新报表
		const refreshReport = () => {
			if (selectedReportPath.value) {
				renderReportWithIframe(selectedReportPath.value)
			}
		}

		// 导出报表为XLSX格式
		const exportReport = async () => {
			try {
				const params = {
					reportName: selectedReportPath.value,
					renderType: 'xlsx'
				}

				reportApi.download(params).then((res) => {
					downloadUtil.resultDownload(res)
				})
			} catch (err) {
				console.error('导出报表失败:', err)
				// 使用更友好的提示方式
				message.error('导出报表失败，请稍后重试')
			}
		}

		onMounted(() => {
			loadReportList()
		})

		// iframe 加载完成事件
		const onIframeLoad = () => {
			loading.value = false
			console.log('iframe 加载完成')

			// 尝试调整iframe高度以适应内容
			try {
				const iframe = reportIframe.value
				if (iframe && iframe.contentDocument) {
					const body = iframe.contentDocument.body
					const html = iframe.contentDocument.documentElement

					// 获取内容高度
					const height = Math.max(
						body.scrollHeight,
						body.offsetHeight,
						html.clientHeight,
						html.scrollHeight,
						html.offsetHeight
					)

					// 设置iframe高度，但不超过最大限制
					iframe.style.height = Math.min(height, window.innerHeight - 200) + 'px'
				}
			} catch (e) {
				// 跨域限制，无法访问iframe内部内容
				console.log('无法调整iframe高度:', e)
			}
		}

		return {
			reportTreeData,
			filteredTreeData,
			iframeSrc,
			iframeKey,
			selectedReportName,
			selectedReportPath,
			collapsed,
			loading,
			searchValue,
			reportIframe,
			simpleImage,
			toggleCollapse,
			onSelectReport,
			onSearch,
			refreshReport,
			exportReport,
			onIframeLoad
		}
	}
})
</script>

<style scoped>
.report-demo-container {
	height: calc(100vh - 120px);
	padding: 16px;
	background: #f0f2f5;
	box-sizing: border-box;
}

.full-height-row {
	height: 100%;
}

.left-panel {
	height: 100%;
	transition: all 0.3s ease;
}

.tree-card {
	height: 100%;
	display: flex;
	flex-direction: column;
}

.tree-card :deep(.ant-card-head) {
	flex-shrink: 0;
}

.tree-card :deep(.ant-card-body) {
	flex: 1;
	overflow: hidden;
	display: flex;
	flex-direction: column;
	padding: 16px;
}

.tree-container {
	flex: 1;
	overflow: hidden;
	display: flex;
	flex-direction: column;
}

.report-tree {
	flex: 1;
	overflow: auto;
}

.report-tree :deep(.ant-tree-node-content-wrapper) {
	width: 100%;
}

.tree-node-label {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	display: block;
}

.collapsed-hint {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100%;
	color: #999;
	font-size: 12px;
}

.right-panel {
	height: 100%;
}

.preview-card {
	height: 100%;
	display: flex;
	flex-direction: column;
}

.preview-card :deep(.ant-card-head) {
	flex-shrink: 0;
}

.preview-card :deep(.ant-card-body) {
	flex: 1;
	overflow: hidden;
	padding: 0;
	display: flex;
	flex-direction: column;
}

.action-buttons {
	display: flex;
	gap: 8px;
}

.report-preview-container {
	flex: 1;
	display: flex;
	flex-direction: column;
	overflow: hidden;
	position: relative;
}

.loading-container {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100%;
}

.report-iframe {
	width: 100%;
	height: 100%;
	border: none;
	background: white;
}

.empty-state {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 40px 0;
}

.empty-description {
	text-align: center;
}

.empty-hint {
	color: #999;
	margin-top: 8px;
	display: block;
}

/* 美化滚动条样式 */
.report-tree::-webkit-scrollbar,
.report-iframe::-webkit-scrollbar {
	width: 6px;
	height: 6px;
}

.report-tree::-webkit-scrollbar-thumb,
.report-iframe::-webkit-scrollbar-thumb {
	background-color: rgba(0, 0, 0, 0.2);
	border-radius: 4px;
}

.report-tree::-webkit-scrollbar-thumb:hover,
.report-iframe::-webkit-scrollbar-thumb:hover {
	background-color: rgba(0, 0, 0, 0.3);
}

.report-tree::-webkit-scrollbar-track,
.report-iframe::-webkit-scrollbar-track {
	background-color: rgba(0, 0, 0, 0.06);
	border-radius: 4px;
}

/* 响应式调整 */
@media (max-width: 768px) {
	.report-demo-container {
		padding: 8px;
		height: calc(100vh - 100px);
	}

	.left-panel {
		position: absolute;
		z-index: 100;
		height: calc(100% - 32px);
		box-shadow: 2px 0 8px rgba(0, 0, 0, 0.15);
	}

	.right-panel {
		width: 100%;
	}
}
</style>
