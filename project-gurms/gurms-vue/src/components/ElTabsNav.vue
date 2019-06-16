<!--本页为tab标签-->
<template>
    <el-tabs v-model="$store.state.pub.activeTab" type="card" closable @tab-remove="removeTab" @tab-click="handleClickTab($event.name)">
        <el-tab-pane :key="item.tabId" v-for="item in $store.state.pub.openTabs" :label="item.tabName" :name="item.tabId">
        </el-tab-pane>
    </el-tabs>
</template>

<script>
export default {
    name: 'menuTab',
    methods: {
        handleClickTab(tabId) {
            this.$store.commit('pub/CHANGETAB', tabId);
        },
        removeTab(tabId) {
            this.$store.commit('pub/DELTAB', tabId);
        }
/**
    },
    computed: {
        getOpenedTab() {
            return this.$store.state.pub.openTabs;
        },
        changeTab() {
            return this.$store.state.pub.activeTab;
        }
    },
    watch: {
        getOpenedTab(val) {
            if (val.length > this.openedTab.length) {
                // 添加了新的tab页
                // 导致$store.state中的openedTab长度
                // 大于
                // 标签页中的openedTab长度
                // 因此需要新增标签页
                let newTab = val[val.length - 1]; // 新增的肯定在数组最后一个
                this.tabIndex++;
                this.editableTabs.push({
                    title: newTab,
                    name: newTab,
                    content: ''
                })
                this.editableTabsValue = newTab;
                this.openedTab.push(newTab);
            }
        },
        changeTab(val) {
            // 监听activetab以实现点击左侧栏时激活已存在的标签
            if (val !== this.editableTabsValue) {
                this.editableTabsValue = val;
            }
        }
    },
    created() {
        // 刷新页面时（F11)
        // 因为<router-view>的<keep-alive>，会保留刷新时所在的router
        // 但是tab标签页因为刷新而被重构了，tab没有了
        // 因此需要将router回到index
        this.$router.push('index');
*/
    }
}
</script>
