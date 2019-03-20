<template>
    <div id="app">
        <div v-if="!$store.state.pub.network">
            <h3>服务器无响应或超时</h3>
            <div @click="onRefresh">刷新</div>
        </div>
        <router-view />
    </div>
</template>
<script>
export default {
            // {{this.$message({message: '服务器无响应或超时', type: 'error', showClose: true, duration: 0})}}

    methods: {
        // 通过跳转一个空页面再返回的方式来实现刷新当前页面数据的目的
        onRefresh() {
            this.$router.replace({
                path: '/refresh',
                query: {
                    t: Date.now()
                }
            })
        }
    }
}
</script>
