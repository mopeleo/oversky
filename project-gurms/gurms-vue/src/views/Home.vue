<template>
    <div class="home">
        <el-container>
            <el-header>Header, welcome: {{$store.getters['pub/userinfo'].username}}, 公司123名称： {{$store.state.pub.user.orgid}}</el-header>
            <el-container>
                <el-aside width="200px">
                <!--
                    <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>导航一</span>
                            </template>
                            <el-menu-item-group>
                                <template slot="title">分组一</template>
                                <el-menu-item index="1-1">选项1</el-menu-item>
                                <el-menu-item index="1-2">选项2</el-menu-item>
                            </el-menu-item-group>
                            <el-menu-item-group title="分组2">
                                <el-menu-item index="1-3">选项3</el-menu-item>
                            </el-menu-item-group>
                            <el-submenu index="1-4">
                                <template slot="title">选项4</template>
                                <el-menu-item index="1-4-1">选项1</el-menu-item>
                            </el-submenu>
                        </el-submenu>
                        <el-menu-item index="2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">导航二</span>
                        </el-menu-item>
                        <el-menu-item index="3" disabled>
                            <i class="el-icon-document"></i>
                            <span slot="title">导航三</span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <i class="el-icon-setting"></i>
                            <span slot="title">导航四</span>
                        </el-menu-item>
                    </el-menu>
                    -->



                    <router-link to="/home/sysuser/list">userlist</router-link><br />
                    <router-link to="/home/sysrole/list">rolelist</router-link><br />
                    <router-link to="/home">home</router-link><br />
                    <router-link v-for="menu in user.menus" :key="menu.menuid" :to="{ path: menu.menuurl }">
                            {{menu.menuname + "_" + menu.menuurl}}<br />
                    </router-link>
                </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
export default {
    data() {
        return { user: this.$store.state.pub.user };
    }
}
</script>
