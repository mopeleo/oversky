<template>
    <div>
        <el-header id="header">
            <span class="hideAside" @click="collapse"><i :class="isCollapse == true ? 'el-icon-d-arrow-left' : 'el-icon-d-arrow-right'"></i></span>
            <ul class="personal">
                <li class="fullScreen" @click="fullScreen">
                    <el-tooltip class="item" effect="dark" content="全屏" placement="bottom">
                        <i class="fa fa-arrows-alt fa-lg"></i>
                    </el-tooltip>
                </li>
                <li>
                    <langSelect></langSelect>
                </li>
                <li>{{$store.getters['pub/userinfo'].orgid}}</li>
                <li>
                    <el-dropdown @command="handleCommand">
                        <span class="el-dropdown-link">{{$store.getters['pub/userinfo'].username}}
                            <i class="el-icon-arrow-down el-icon--right"></i>
                        </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="a">修改密码</el-dropdown-item>
                            <el-dropdown-item command="b">个人信息</el-dropdown-item>
                            <el-dropdown-item command="c" divided>退出</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </li>
                <li class="icon"><img src="../assets/icon.jpg"/></li>
            </ul>

            <el-dialog title="修改密码" v-if="dialogFormVisible" :visible.sync="dialogFormVisible" :close-on-click-modal="false" width="35%">
                <el-form ref="detailForm" :model="sysuser" :rules="rules" label-width="120px">
                    <el-row>
                        <el-form-item label="用户姓名">
                            {{$store.getters['pub/userinfo'].username}}
                        </el-form-item>
                    </el-row>
                    <el-row>
                        <el-col :span="15">
                            <el-form-item label="原密码" prop="loginpasswd">
                                <el-input type="password" v-model="sysuser.loginpasswd"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="15">
                            <el-form-item label="新密码" prop="newpasswd">
                                <el-input type="password" v-model="sysuser.newpasswd"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="15">
                            <el-form-item label="确认新密码" prop="newpasswd2">
                                <el-input type="password" v-model="sysuser.newpasswd2"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row type="flex" justify="end">
                        <el-button type="primary" @click="onSubmit('detailForm')">修改</el-button>
                        <el-button type="primary" @click="dialogFormVisible = false;">关闭</el-button>
                    </el-row>
                </el-form>
            </el-dialog>

        </el-header>
        <tabNav></tabNav>
    </div>
</template>
<script>
import langSelect from '@/components/lang/langSelect';
import tabNav from './TransitionNav';
import * as tools from '@/utils/tools';
import md5 from 'js-md5';

export default {
    name: 'Header',
    components: { tabNav, langSelect },
    data() {
        var validateNewPasswd = (rule, value, callback) => {
            if (value && value === this.sysuser.loginpasswd) {
                callback(new Error("新密码不能与原密码相同"));
            } else {
                callback();
            }
        };
        var validateNewPasswdAgain = (rule, value, callback) => {
            if (value && value !== this.sysuser.newpasswd) {
                callback(new Error("两次输入密码不一致!"));
            } else {
                callback();
            }
        };
        return {
            dialogFormVisible: false,
            //临时业务数据
            sysuser: {
                loginpasswd:'',
                newpasswd:'',
                newpasswd2:''
            },
            isCollapse:true,
            isfullScreen: true,
            rules:{
                loginpasswd:[
                    {required:true, message:'原密码不能为空', trigger:'blur'},
                    {min:8, max:16, message:'输入长度在8-16之间', trigger:'blur'}
                ],
                newpasswd:[
                    {required:true, message:'新密码不能为空', trigger:'blur'},
                    {min:8, max:16, message:'输入长度在8-16之间', trigger:'blur'},
                    {validator: validateNewPasswd, trigger:'blur'}
                ],
                newpasswd2:[
                    {required:true, message:'再次输入新密码不能为空', trigger:'blur'},
                    {min:8, max:16, message:'输入长度在8-16之间', trigger:'blur'},
                    {validator: validateNewPasswdAgain, trigger:'blur'}
                ]
            }
        }
    },
    methods: {
        collapse() {
            if(this.isCollapse){
                this.isCollapse = false;
            }else{
                this.isCollapse = true;
            }
            this.$store.commit('pub/COLLAPSE_LEFT');
        },
        fullScreen() {
            if (this.isfullScreen) {
                var docElm = document.documentElement;
                if (docElm.requestFullscreen) {
                    docElm.requestFullscreen();
                } else if (docElm.mozRequestFullScreen) {
                    docElm.mozRequestFullScreen();
                } else if (docElm.webkitRequestFullScreen) {
                    docElm.webkitRequestFullScreen();
                } else if (docElm.msRequestFullscreen) {
                    docElm.msRequestFullscreen();
                }
                this.isfullScreen = false
            } else {
                if (document.exitFullscreen) {
                    document.exitFullscreen();
                } else if (document.mozCancelFullScreen) {
                    document.mozCancelFullScreen();
                } else if (document.webkitCancelFullScreen) {
                    document.webkitCancelFullScreen();
                } else if (document.msExitFullscreen) {
                    document.msExitFullscreen();
                }
                this.isfullScreen = true;
            }
        },
        handleCommand(command) {
            if (command === 'a') {
                this.sysuser = {};
                this.dialogFormVisible = true;
            } else if(command === 'c'){
                this.logout();
            } else {
                alert(command);
            }
        },
        logout: function() {
            //根据jwt判断，服务器不保存状态，所以无需发请求到服务器
            this.$store.commit('pub/LOGOUT');
            this.$router.push({ path: '/login' });
            // this.$api.Gurms.logout(this.user.userid).then((res)=>{
            //     if(res.data === true){
            //         this.$store.commit('pub/LOGOUT');
            //         this.$router.push({path: '/login'});
            //     }
            // }).catch((error)=>{
            //     tools.errTip(error);
            // });
        },
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    //从session赋值
                    var userReq = {};
                    userReq.userid = this.$store.state.pub.user.userid;
                    userReq.loginpasswd = md5(this.sysuser.loginpasswd);
                    userReq.newpasswd = md5(this.sysuser.newpasswd);
                    this.$api.Gurms.userUpdatePassword(userReq).then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.success === true){
                            this.dialogFormVisible = false;
                        }
                    }).catch((err)=>{
                        tools.errTip(err);
                    });
                }else{
                    return false;
                }
            })
        }

    }
}
</script>
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

html,body,#app,.el-container,#asideNav,ul.el-menu {
    @extend %h100;
}

@mixin set-value($side, $value) {
    @each $prop in $leftright {
        #{$side}-#{$prop}: $value;
    }
}

#header {
    max-height: 50px;
    line-height: 50px;
    box-shadow: 0 1px 2px 0 rgba(0, 0, 0, .05);
    display: flex;
    justify-content: space-between;

    .hideAside {
        @extend %cursor;
    }

    .personal {
        display: flex;
        flex-direction: row;

        li {
            @include set-value(margin, 13px);
            font-size: 12px;
        }

        .fullScreen {
            @extend %cursor;
        }

        .el-dropdown-link {
            @extend %cursor;
        }

        .icon img {
            margin-#{$top}: 7px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            width: 40px;
            height: 40px;
        }
    }
}
</style>
