<template>
  <a-card
      class="xn-wd"
      :bordered="false"
      :tab-list="tabListNoTitle"
      :active-tab-key="noTitleKey"
      @tabChange="(key) => onTabChange(key, 'noTitleKey')"
  >
    <p v-if="noTitleKey === 'sysConfig'">
      <SysConfig/>
    </p>
    <p v-else-if="noTitleKey === 'fileConfig'">
      <FileConfig />
    </p>
    <p v-else-if="noTitleKey === 'otherConfig'">
      <OtherConfig/>
    </p>
  </a-card>
</template>

<script setup name="devConfig">
import SysConfig from './sysConfig.vue'
import FileConfig from './fileConfig/index.vue'
import OtherConfig from './otherConfig/index.vue'

const key = ref('sysConfig')
const noTitleKey = ref('sysConfig')

const tabListNoTitle = [
  {
    key: 'sysConfig',
    tab: '系统配置'
  },
  {
    key: 'fileConfig',
    tab: '文件配置'
  },
  {
    key: 'otherConfig',
    tab: '其他配置'
  }
]

const onTabChange = (value, type) => {
  if (type === 'key') {
    key.value = value
  } else if (type === 'noTitleKey') {
    noTitleKey.value = value
  }
}
</script>
<style lang="less" scoped>
:deep(.ant-tabs-tab) {
  font-size: 14px !important;
}
</style>
