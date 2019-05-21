<template>
    <div>
        <el-container>
            <el-header>
                Header, welcome: {{$store.getters['pub/userinfo'].username}}, 公司123名称： {{$store.state.pub.user.orgid}}
                <el-button type="primary" @click="logout">注销</el-button>
            </el-header>
            <el-container>
                <el-aside :width="asideWidth">
                    <el-button type="primary" :icon="iconCollapse" @click="collapseClick"></el-button>
                    <el-menu router :default-active="$route.path" class="el-menu-vertical-demo" theme="dark" @open="handleOpen" @close="handleClose" :collapse="isCollapse">

                    <el-menu-item :index="'/home/about'" @click="clickMenu({menuid:'index',menuname:'首页',menuurl:'about'})">
                        <i class="el-icon-menu"></i>
                        <span slot="title">首页</span>
                    </el-menu-item>

                    <template v-for="(menu,index) in user.menuTree.subMenus">
                        <el-submenu v-if='menu.subMenus' :index="index + ''" :key="menu.menuid">
                            <template slot="title">
                                <i class="el-icon-location"></i>
                                <span>{{menu.menuname}}</span>
                            </template>
                            <template v-for="(menu2, index2) in menu.subMenus">
                                <el-submenu v-if='menu2.subMenus' :index="index + '-' + index2" :key="menu2.menuid">
                                    <template slot="title">{{menu2.menuname}}</template>
                                    <el-menu-item v-for="(menu3) in menu2.subMenus" :index="'/home/'+menu3.menuurl" :key="menu3.menuid" @click="clickMenu(menu3)">{{menu3.menuname}}</el-menu-item>
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
                    <menuTab></menuTab>
                    <keep-alive :include="cacheTabs">
                        <router-view></router-view>
                    </keep-alive>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
import menuTab from "@/components/TopTab.vue";
import { mapGetters } from 'vuex';

export default {
    components:{menuTab},
    data() {
        return {
            //动态样式
            asideWidth: '200px',
            iconCollapse: 'el-icon-d-arrow-left',
            isCollapse: false,
            //数据
            user: this.$store.state.pub.user
        };
    },
    computed:{
        ...mapGetters('pub',['cacheTabs'])
    },
    methods:{
        logout:function(){
            //根据jwt判断，服务器不保存状态，所以无需发请求到服务器
            this.$store.commit('pub/LOGOUT');
            this.$router.push({path: '/login'});
            // this.$api.Gurms.logout(this.user.userid).then((res)=>{
            //     if(res.data === true){
            //         this.$store.commit('pub/LOGOUT');
            //         this.$router.push({path: '/login'});
            //     }
            // }).catch((error)=>{
            //     tools.errTip(error);
            // });
        },
        collapseClick(){
            if(this.isCollapse == true){
                this.isCollapse = false;
                this.iconCollapse = 'el-icon-d-arrow-left';
                this.asideWidth = '200px';
            }else{
                this.isCollapse = true;
                this.iconCollapse = 'el-icon-d-arrow-right';
                this.asideWidth = 'auto';
            }
        },
        clickMenu: function(menuObj){
            let tabObj = {
                tabId: menuObj.menuid,
                tabName: menuObj.menuname,
                routeName: menuObj.menuurl
            };
            this.$store.commit('pub/ADDTAB', tabObj);
        },
        //点击行响应
        handleOpen: function(){

        },
        handleClose: function(){

        }
    }
}
</script>

