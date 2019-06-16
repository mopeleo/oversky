<template>
    <div>
        <el-aside id="asideNav">
            <div class="logo-name">
                <p v-if="$store.state.pub.logoShow">RM</p>
                <p v-else>vue-gurms后台模板</p>
            </div>

            <el-menu router :default-active="$route.path" class="el-menu-vertical"
                @select="selectMenu"
                background-color="#03152A" text-color="rgba(255,255,255,.7)" active-text-color="#ffffff"
                :collapse="$store.state.pub.menuCollapse" :collapse-transition="true">

                <el-menu-item :index="'/home/about'">
                    <i class="el-icon-tickets"></i>
                    <span slot="title">首页</span>
                </el-menu-item>

                <template v-for="(menu,index) in user.menuTree.subMenus">
                    <el-submenu v-if="menu.subMenus && menu.menutype === '0'" :index="index + ''" :key="menu.menuid">
                        <template slot="title">
                            <i :class="menu.menucss?menu.menucss:'fa fa-server'"></i>
                            <span slot="title">{{menu.menuname}}</span>
                        </template>

                        <recursive-menu :menuData="menu.subMenus"></recursive-menu>
                    </el-submenu>

                    <el-menu-item v-else :index="'/home/'+menu.menuurl" :key="menu.menuid">
                        <i :class="menu.menucss?menu.menucss:'fa fa-file'"></i>
                        <span slot="title">{{menu.menuname}}</span>
                    </el-menu-item>
                </template>
            </el-menu>
        </el-aside>
    </div>
</template>

<script>
import RecursiveMenu from './RecursiveMenu';

export default {
    name: 'LeftMenu',
    components: { RecursiveMenu },
    data() {
        return { user: this.$store.state.pub.user };
    },
    methods: {
        selectMenu (key) {
            // alert(key);
            let recursiveMenu = function (path, menuList) {
                let rst = null;
                for (let i = 0; i < menuList.length; i++) {
                    if ((menuList[i].subMenus && menuList[i].subMenus.length > 0) || ('/home/'+menuList[i].menuurl) === path) {
                        if (('/home/'+menuList[i].menuurl) === path) {
                            rst = menuList[i];
                            break;
                        }
                        rst = recursiveMenu(path, menuList[i].subMenus);
                    }
                }
                return rst;
            }
            let selectedMenu = recursiveMenu(key, this.user.menuTree.subMenus);
            let tabObj = {
                tabId: selectedMenu.menuid,
                tabName: selectedMenu.menuname,
                routeName: selectedMenu.menuurl
            };
            this.$store.commit('pub/ADDTAB', tabObj);
        }
    }
}
</script>
<style lang="scss">
$top: top;
$bottom: bottom;
$left: left;
$right: right;

%w100 {
    width: 100%;
}

%h100 {
    height: 100%;
}

%cursor {
    cursor: pointer;
}

@mixin set-value($side, $value) {
    @each $prop in $leftright {
        #{$side}-#{$prop}: $value;
    }
}

#asideNav {
    width: auto !important;
    display: flex;
    flex-direction: column;
    border-right: solid 1px #e6e6e6;

    .logo-name {
        background-color: #03152A !important;
        @extend %w100;
        font-weight: 300;
        z-index: 999;

        p {
            height: 50px;
            line-height: 50px;
            text-align: center;
            font-size: 16px;
            color: #5e6d82;
        }
    }

    .el-menu-vertical:not(.el-menu--collapse) {
        width: 200px;
        @extend %h100;
        overflow-y: scroll;
    }

    .el-menu {
        flex: 1;
        overflow: inherit;
        border-right: none;

        &::-webkit-scrollbar {
            display: none;
        }

        .fa {
            vertical-align: middle;
            margin-right: 5px;
            width: 24px;
            text-align: center;
            font-size: 18px;
        }

        .el-menu-item {
            background-color: #020f1d !important;
            border-bottom: 1px solid #020f1d;

            &:hover {
                color: #ffffff !important;
                background-color: #375573 !important;
            }
        }

        .el-menu-item.is-active {
            background-color: #56a9ff !important
        }

        .is-opened>.el-submenu__title>.el-icon-arrow-down {
            color: #ffffff;
            font-weight: 500;
            font-size: 18px;
        }
    }
}
</style>
