<template>
    <div id="loyout">
        <el-container>
            <left-menu />
            <el-container>
                <TopHeader></TopHeader>
                <el-main id="elmain">
                    <keep-alive :include="cacheTabs">
                        <router-view></router-view>
                    </keep-alive>
                </el-main>
                <el-footer>
                    <Footer/>
                </el-footer>
            </el-container>
        </el-container>
    </div>
</template>
<script>
import TopHeader from "@/components/TopHeader.vue";
import LeftMenu from "@/components/LeftMenu.vue";
import Footer from "@/components/Footer.vue";
import { mapGetters } from 'vuex';

export default {
    components: { TopHeader, LeftMenu, Footer },
    computed: {
        ...mapGetters('pub', ['cacheTabs'])
    }
}
</script>
<style>
.main-enter,.main-leave-to {
    opacity: 0;
    transform: translateY(30px);
}

.main-enter-active {
    transition: all 0.2s;
}

.main-leave-active {
    position: absolute;
    transition: all 0.3s;
}
</style>
<style lang="scss">
* {
    margin: 0px;
    padding: 0px;
}

body {
//    background-color: #f2f2f2;
//    font-size: 14px;
//    color: #333333;
}

li {
    list-style: none;
}

a {
    text-decoration: none;
}

$top: top;
$bottom: bottom;
$left: left;
$right: right;
$leftright: ($left, $right);

%w100 {
    width: 100%;
}

%h100 {
    height: 100%;
}

%cursor {
    cursor: pointer;
}

html,body,#loyout,.el-container,#asideNav,ul.el-menu {
    @extend %h100;
}

@mixin set-value($side, $value) {
    @each $prop in $leftright {
        #{$side}-#{$prop}: $value;
    }
}

#elmain {
//    background-color: #f0f2f5;
}
</style>
