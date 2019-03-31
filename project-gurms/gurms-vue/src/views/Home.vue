<template>
    <div class="home">
        <el-container>
            <el-header>Header, welcome: {{$store.getters['pub/userinfo'].username}}, 公司123名称： {{$store.state.pub.user.orgid}}</el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu router :default-active="$route.path" class="el-menu-vertical-demo" theme="dark" @open="handleOpen" @close="handleClose">

                    <template v-for="(menu,index) in user.menuTree.subMenus">
                        <el-submenu v-if='menu.subMenus' :index="index + ''" :key="menu.menuid">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>{{menu.menuname}}</span>
                            </template>
                            <template v-for="(menu2, index2) in menu.subMenus">
                                <el-submenu v-if='menu2.subMenus' :index="index + '-' + index2" :key="menu2.menuid">
                                    <template slot="title">{{menu2.menuname}}</template>
                                    <el-menu-item v-for="(menu3) in menu2.subMenus" :index="'/home/'+menu3.menuurl" :key="menu3.menuid">{{menu3.menuname}}</el-menu-item>
                                </el-submenu>
                                <el-menu-item v-else :index="'/home/'+menu2.menuurl" :key="menu2.menuid">
                                    {{menu2.menuname}}
                                </el-menu-item>
                            </template>
                        </el-submenu>
                        <el-menu-item v-else :index="index + ''" :key="menu.menuid">
                            <i class="el-icon-menu"></i>
                            <span slot="title">{{menu.menuname}}</span>
                        </el-menu-item>
                    </template>

                    </el-menu>
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
    },
    methods:{
        //点击行响应
        handleOpen: function(){
            console.log(1);
        },
        handleClose: function(){
            console.log(2);
        }
    }
}
</script>
