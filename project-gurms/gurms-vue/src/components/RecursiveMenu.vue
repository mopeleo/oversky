<template>
    <div>
        <template v-for="(menu,index) in menuData">
            <el-submenu v-if="menu.subMenus && menu.menutype === '0'" :index="index + '-' + menu.menuid" :key="menu.menuid">
                <template slot="title">
                    <i :class="menu.menucss ? menu.menucss : 'fa fa-server'"></i>
                    <span slot="title">{{menu.menuname}}</span>
                </template>
                <recursive-menu :menuData="menu.subMenus"></recursive-menu>
            </el-submenu>
            <el-menu-item v-else :index="'/home/'+menu.menuurl" :key="menu.menuid">
                <i :class="menu.menucss ? menu.menucss : 'fa fa-file'"></i>
                <span slot="title">{{menu.menuname}}</span>
            </el-menu-item>
        </template>
    </div>
</template>

<script>
export default {
    name: 'recursiveMenu',
    props: ['menuData']
}
</script>
