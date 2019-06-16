<template>
    <div id="login">
        <div class="loginConbox">
            <div class="header">
                <!--<div class="logo">-->
                <!--<img src="../../assets/logo.png">-->
                <!--</div>-->
            </div>
            <div class="loginBox">
                <div class="loginCon">
                    <p class="title">通用角色权限管理系统</p>
                    <el-card shadow="always" class="login-module" v-if="smdl">
                        <div slot="header" class="clearfix formTitlt">
                            <span>密码登录</span>
                            <span class="titIconbox">
                                <i class="iconfont xu-saomadenglu2 fa-lg iconcolor"></i>
                                <i class="iconfont xu-saomadenglu01 el-icon--right fa-lg pointer" @click="smdl = !smdl"></i>
                            </span>
                        </div>
                        <el-form ref="loginForm" :model="login" :rules="loginRules" status-icon label-width="100px" class="demo-ruleForm">
                            <el-form-item prop="loginid">
                                <el-input type="text" v-model="login.loginid" placeholder="请输入登录账号" @keyup.enter.native="goToPwdInput"></el-input>
                            </el-form-item>
                            <el-form-item prop="passwd">
                                <el-input type="password" v-model="login.passwd" placeholder="请输入登录密码" @keyup.enter.native="onSubmit" ref="pwd"></el-input>
                            </el-form-item>
                            <el-form-item label="记住我" label-width="80px">
                                <el-switch v-model="login.remember"></el-switch>
                            </el-form-item>
                            <el-form-item>
                                <el-button class="subBtn" type="primary" @click="onSubmit">登录</el-button>
                            </el-form-item>
                            <p class="smalltxt">
                                <router-link class="a" to="#">忘记密码</router-link>
                                <router-link class="a" to="#">免费注册</router-link>
                            </p>
                        </el-form>
                    </el-card>
                    <el-card shadow="always" class="login-module" v-else>
                        <div slot="header" class="clearfix formTitlt">
                            <span>扫码登录</span>
                            <span class="titIconbox">
                                <i class="iconfont xu-mimadenglu1 fa-lg iconcolor"></i>
                                <i class="iconfont xu-imagevector el-icon--right fa-lg pointer" @click="smdl = !smdl"></i>
                            </span>
                        </div>
                        <div class="ewmbox">
                            <div class="ewm">
                                <img src="https://img.alicdn.com/tfscom/TB1ivYYyHvpK1RjSZFqwu3XUVXa.png"/>
                            </div>
                            <div class="ewmicon">
                                <i class="iconfont xu-saomadenglu fa-2x iconcolor"></i>
                                <p>打开 微信 扫一扫登录</p>
                            </div>
                            <p class="smalltxt">
                                <router-link class="a" to="#">免费注册</router-link>
                            </p>
                        </div>
                    </el-card>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import md5 from 'js-md5';
import * as tools from '@/utils/tools';

export default {
    name: 'login',
    data() {
        return {
            smdl: true,
            login: {
                loginid: 'admin',
                passwd: '1',
                remember: false
            },
            loginRules: {
                loginid: [
                    { required: true, message: '用户名不能为空', trigger: 'blur' },
                    { min: 3, max: 8, message: '输入长度在3-8之间', trigger: 'blur' }
                ],
                passwd: {
                    required: true,
                    message: '密码不能为空',
                    trigger: 'blur'
                }
            }
        };
    },
    methods: {
        // 用户名输入框回车后切换到密码输入框
        goToPwdInput() {
            this.$refs.pwd.$el.getElementsByTagName('input')[0].focus();
        },
        onSubmit() {
            this.$refs.loginForm.validate((valid) => {
                if (valid) {
                    this.login.passwd = md5(this.login.passwd);
                    this.$api.Gurms.login(this.login).then((res) => {
                        this.$store.commit('pub/LOGIN', res);
                        this.$store.commit('pub/ADDROUTES');
                        this.$router.push({ name: 'about' });
                    }).catch((error) => {
                        tools.errTip(error);
                    });
                } else {
                    return false;
                }
            });
        },
        onReset(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>
<style lang="scss">
#login {
    width: 100%;
    height: 100%;
    background-color: #2d3a4b;

    .loginConbox {
        background: #2d3a4b;
    }

    .header {
        height: 60px;
        position: relative;
        background: #2d3a4b;

        /*border-bottom: 1px solid rgba(255, 255, 255, 0.3);*/
        .logo {
            margin-left: 30px;
            width: 500px;
            float: left;
            height: 40px;
            padding-top: 10px;

            img {
                height: 100%;
            }
        }
    }

    .loginBox {
        .iconcolor {
            color: #409EFF;
        }

        padding: 74px 0 118px;

        .loginCon {
            width: 990px;
            margin: auto;
            position: relative;
            height: 388px;

            .el-card__header {
                border-bottom: 0px;
            }

            .title {
                font-size: 36px;
                font-weight: 600;
                color: #ffffff;
                width: 500px;
                float: left;
                margin-top: 0px;

                &:first-child {
                    font-size: 34px;
                    margin-top: 50px;
                    margin-bottom: 30px;
                }
            }

            .login-module {
                width: 380px;
                height: 345px;
                margin-top: 60px;
                border: none;
                position: absolute;
                right: 0;

                .formTitlt {
                    font-size: 18px;
                    font-weight: 400;

                    .titIconbox {
                        float: right;

                        .pointer {
                            cursor: pointer;
                        }
                    }
                }

                .smalltxt {
                    text-align: right;

                    .a {
                        text-decoration: none;
                        color: #999999;
                        font-size: 12px;
                        margin-left: 8px;
                    }
                }
            }

            .el-form-item__content {
                margin-left: 0px !important;

                .subBtn {
                    width: 100%;
                }
            }
        }

        .el-input__inner, .el-button, .el-card, .el-message {
            border-radius: 0px !important;
        }

        .el-form-item__content .ico {
            position: absolute;
            top: 0px;
            left: 0px;
            z-index: 999;
            width: 40px;
            height: 39px;
            text-align: center;
            border-right: 1px solid #ccc;
        }

        .ewmbox {
            width: 100%;
            height: 240px;
            margin-top: -25px;

            .ewm {
                width: 140px;
                height: 140px;
                margin: 20px auto;

                p {
                    font-size: 12px;
                    padding-left: 40px;
                    margin: 0;
                }
            }

            .ewmicon {
                width: 140px;
                margin: 20px auto 0;

                .iconfont {
                    float: left;
                }

                p {
                    font-size: 12px;
                    padding-left: 40px;
                    margin: 0;
                }
            }
        }
    }
}
</style>
