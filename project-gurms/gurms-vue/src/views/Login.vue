<template>
    <el-container class="login-container">
        <el-card class="animated flipInY">
            <div slot="header" class="el-card-header">
                <LangSelect class="lang-select"></LangSelect>
                <div style="clear: both;"></div>
                <img src="../assets/img/login-logo.png" alt="">
                <h2 class="login-title">{{$t('login.title')}}</h2>
            </div>
            <el-form ref="loginForm" :model="login" :rules="loginRules" label-width="60px">
                <el-form-item :label="$t('login.account')" prop="loginid" style="position:relative">
                    <el-input type="text" v-model="login.loginid" placeholder="请输入用户名" @keyup.enter.native="goToPwdInput"></el-input>
                    <span class="svg-container svg-container_user">
                        <svg-icon icon-class="user" />
                    </span>
                </el-form-item>
                <el-form-item :label="$t('login.password')" prop="passwd">
                    <el-input type="password" v-model="login.passwd" placeholder="请输入登录密码" @keyup.enter.native="onSubmit" ref="pwd"></el-input>
                    <span class="svg-container svg-container_password">
                        <svg-icon icon-class="password" />
                    </span>
                </el-form-item>
                <el-form-item :label="$t('login.remember')" label-width="80px">
                    <el-switch v-model="login.remember"></el-switch>
                </el-form-item>
                <el-button type="primary" @click="onSubmit">{{$t('login.login')}}</el-button>
            </el-form>
        </el-card>
    </el-container>
</template>
<script>
import md5 from 'js-md5';
import * as tools from '@/utils/tools';
import LangSelect from '@/components/lang-select';

export default {
    name: 'login',
    components: {
        LangSelect
    },
    data() {
        return {
            login: {
                loginid: '',
                passwd: '',
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
                        this.$router.push({ path: '/home' });
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
<style scoped lang="stylus">
.login-container {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: mix(#494166, #424b50) url('../assets/img/login-bg.jpg') center no-repeat;
    background-size: cover;
    overflow: hidden;

    .show-account {
        position: absolute;
        left: 15px;
        bottom: 20px;
        color: red;
    }

    .el-card {
        position: absolute;
        top: 50%;
        left: 50%;
        margin: -300px 0 0 -200px;
        width: 400px;
        height: 450px;
        background: #fff;

        .el-card-header {
            text-align: center
            .lang-select {
                float right
            }
        }

        .login-title {
            margin: 0;
            text-align: center;
        }

        .el-input /deep/ .el-input__inner {
            text-indent: 12px;
        }

        .svg-container {
            position: absolute;
            top: 0;
            left: 5px;
            color: #889aa4;

            &_user {
                font-size: 20px;
            }

            &_password {
                left: 7px;
                font-size: 16px;
            }
        }

        .el-button--primary {
            width: 100%;
        }
    }
}

</style>
