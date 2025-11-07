<template>
	<div class="report-demo-container">
		<a-row :gutter="16">
			<a-col :span="collapsed ? 1 : 4" class="left-panel">
				<a-card :title="collapsed ? '' : '报表示例列表'" :bordered="false">
					<template #extra>
						<a-button type="text" size="small" @click="toggleCollapse">
							<template #icon>
								<menu-fold-outlined v-if="!collapsed" />
								<menu-unfold-outlined v-else />
							</template>
						</a-button>
					</template>
					<div v-show="!collapsed">
						<a-tree
							v-if="reportTreeData.length > 0"
							:tree-data="reportTreeData"
							:fieldNames="{ title: 'label', key: 'key', children: 'children' }"
							@select="onSelectReport"
							default-expand-all
						>
							<template #title="{ label }">
								<span>{{ label }}</span>
							</template>
						</a-tree>
						<a-empty v-else description="暂无报表示例"/>
					</div>
				</a-card>
			</a-col>

			<a-col :span="collapsed ? 23 : 20">
				<a-card :title="selectedReportName || '报表预览'" :bordered="false">
					<div v-if="selectedReportPath" style="margin-bottom: 16px;">
						<a-button type="primary" @click="exportReport">导出XLSX</a-button>
					</div>
					<div v-if="reportHtml" v-html="reportHtml" class="report-preview"></div>
					<a-empty v-else description="请选择报表示例进行预览"/>
				</a-card>
			</a-col>
		</a-row>
	</div>
</template>

<script>
import {defineComponent, ref, onMounted} from 'vue'
import { MenuFoldOutlined, MenuUnfoldOutlined } from '@ant-design/icons-vue'
import reportApi from '@/api/report/demo'
import bizUserApi from "@/api/biz/bizUserApi";
import downloadUtil from "@/utils/downloadUtil";

export default defineComponent({
	name: 'ReportDemo',
	components: {
		MenuFoldOutlined,
		MenuUnfoldOutlined
	},
	setup() {
		const reportTreeData = ref([])
		const reportHtml = ref('')
		const selectedReportName = ref('')
		const selectedReportPath = ref('')
		const collapsed = ref(false)

		// 切换收缩状态
		const toggleCollapse = () => {
			collapsed.value = !collapsed.value
		}

		// 获取报表示例列表
		const loadReportList = async () => {
			try {
				const res = await reportApi.getDemoReports()
				debugger
				// 转换数据格式以适配 Ant Design Vue Tree 组件
				reportTreeData.value = res
			} catch (err) {
				console.error('获取报表示例列表失败:', err)
			}
		}

		// 选择报表示例
		const onSelectReport = async (selectedKeys, event) => {
			const node = event.node
			if (node.value) {
				selectedReportName.value = node.label
				selectedReportPath.value = node.value
				await renderReport(node.value)
			}
		}

		// 渲染报表
		const renderReport = async (reportPath) => {
			try {
				// 可以在这里传递报表需要的参数
				const params = {
					reportName: reportPath
				}

				const res = await reportApi.renderHtml(params)

				reportHtml.value = res
			} catch (err) {
				console.error('渲染报表失败:', err)
				reportHtml.value = '<div style="color: red;">报表渲染失败</div>'
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
				alert('导出报表失败')
			}
		}

		onMounted(() => {
			loadReportList()
		})

		return {
			reportTreeData,
			reportHtml,
			selectedReportName,
			selectedReportPath,
			collapsed,
			toggleCollapse,
			onSelectReport,
			exportReport
		}
	}
})
</script>

<style scoped>
.report-demo-container {
	padding: 16px;
	background: #fff;
	min-height: calc(100vh - 120px);
}

.left-panel {
	transition: all 0.3s ease;
}

.report-preview {
	min-height: 500px;
	/* 解决滚动条遮挡内容的问题 */
	overflow: auto;
}

.report-preview :deep(table) {
	border-collapse: collapse;
	width: 100%;
}

.report-preview :deep(th),
.report-preview :deep(td) {
	border: 1px solid #000;
	padding: 4px 8px;
	text-align: center;
}

.report-preview :deep(th) {
	background-color: #f0f0f0;
	font-weight: bold;
}

/* 已移除 .scrollable-report 样式，合并到 .report-preview 中 */

/* 美化滚动条样式，使其更符合Ant Design风格 */
.scrollable-report::-webkit-scrollbar {
	width: 6px;
	height: 6px;
}

.scrollable-report::-webkit-scrollbar-thumb {
	background-color: rgba(0, 0, 0, 0.2);
	border-radius: 4px;
}

.scrollable-report::-webkit-scrollbar-thumb:hover {
	background-color: rgba(0, 0, 0, 0.3);
}

.scrollable-report::-webkit-scrollbar-track {
	background-color: rgba(0, 0, 0, 0.06);
	border-radius: 4px;
}
</style>