<template>
    <div>
        <div class="tabnavBox">
            <transition-group name="list" tag="ul">
                <li v-for="(item, index) in $store.getters['pub/openTabs']"
                    @contextmenu.prevent="openMenu(item,$event,index)"
                    :key="item.tabId" class="tabnav"
                    :class="{ active: $route.name === item.routeName }">

                    <router-link :to="{name:item.routeName}">{{item.tabName}}</router-link>
                    <i @click="closeTab(item.tabId)" class="el-icon-error" v-if="index !== 0"></i>
                </li>
            </transition-group>
        </div>
        <ul v-show="this.rightMenuShow" :style="{left:this.left+'px',top:this.top+'px'}" class="menuBox">
            <li @click="removeTab"><i class="fa fa-remove"></i>关闭</li>
            <li @click="removeOtherTab">关闭其他</li>
            <li @click="removeAllTab">关闭所有</li>
        </ul>
    </div>
</template>
<script>
export default {
    name: 'menuTab',
    data() {
        return {
            rightTabId:'',
            rightMenuShow: false,
            left: 0,
            top: 0
        }
    },
    methods: {
        openMenu(item, e, index) {
            if (index === 0) {
                return false;
            }
            this.rightMenuShow = true;
            this.left = e.clientX + 10;
            this.top = e.clientY;
            this.rightTabId = item.tabId;
        },
        closeTab(tabId) {
            this.$store.commit('pub/DELTAB', tabId);
        },
        removeTab() {
            this.$store.commit('pub/DELTAB', this.rightTabId);
        },
        removeOtherTab() {
            this.$store.commit('pub/DELOTHERTAB', this.rightTabId);
        },
        removeAllTab() {
            this.$store.commit('pub/DELALLTAB');
            this.$router.push({ name: 'about' });
        }
    },
    watch: {
        rightMenuShow(value) {
            if (value) {
                document.body.addEventListener('click', () => {
                    this.rightMenuShow = false
                })
            } else {
                document.body.removeEventListener('click', () => {
                    this.rightMenuShow = false
                })
            }
        }
    }
}
</script>
<style>
.tabnav {
    display: inline-block;
    transition: all 0.5s;
}

.list-enter,.list-leave-to{
    opacity: 0;
    transform: translateY(30px);
}

.list-enter-active {
    transition: all 0.5s;
}

.list-leave-active {
    position: absolute;
    transition: all 1s;
}
</style>
<style lang="scss">
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

@mixin set-value($side, $value) {
    @each $prop in $leftright {
        #{$side}-#{$prop}: $value;
    }
}

.tabnavBox {
    @extend %w100;
    height: 42px;
    min-height: 42px;
    overflow: hidden;
    border-#{$top}: 1px solid #f6f6f6;
    border-#{$bottom}: 1px solid #d8dce5;

    -webkit-box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 0 3px 0 rgba(0, 0, 0, 0.04);
    box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 0 3px 0 rgba(0, 0, 0, 0.04);

    ul {
        display: flex;
        justify-content: flex-start;
        padding-#{$left}: 20px;
        flex-wrap: nowrap;
        overflow-x: auto;

        li {
            height: 30px;
            line-height: 31px;
            @extend %cursor;
            margin-#{$top}: 6px;
            margin-#{$right}: 5px;

            border: 1px solid #cccccc;

            overflow: hidden;

            &:not(:first-child) {
                padding-#{$right}: 10px;
                min-width: 80px;
            }

            a {
                @include set-value(padding, 13px);
                display: inline-block;
                @extend %h100;
                font-size: 12px;
                color: #999999;
            }

            &:nth-child(n+2) {
                a {
                    padding-#{$right}: 15px;
                }
            }

            i {
                @extend %cursor;
                &:hover {
                    color: red;
                }
            }
        }

        li.active {
            background: #409eff;
            color: #ffffff;
            a {
                color: #ffffff;
            }
        }
    }
}

.menuBox {
    margin: 0;
    background: #fff;
    z-index: 999;
    position: absolute;
    padding: 5px 0;
    border: 1px solid #cccccc;
    font-size: 12px;
    font-weight: 400;
    color: #333;
    box-shadow: 2px 1px 6px 0 rgba(0, 0, 0, .3);

    li {
        margin: 0;
        padding: 7px 16px;
        @extend %cursor;

        &:hover {
            background: #e1e6ea;
        }
    }
}
</style>
