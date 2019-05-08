<template>
    <el-row type="flex" class="row-bg" justify="center">
        <el-col :span="8">
            <el-form ref="loginForm" :model="login" :rules="loginRules">
                <el-form-item label="用户名" prop="loginid">
                    <el-input type="text" v-model="login.loginid" placeholder="请输入用户名"></el-input>
                </el-form-item>
                <el-form-item label="密  码" prop="passwd">
                    <el-input type="password" v-model="login.passwd" placeholder="请输入登录密码"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit('loginForm')">登录</el-button>
                    <el-button  @click="onReset('loginForm')">取消</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </el-row>
</template>

<script>
import md5 from 'js-md5';
import * as tools from '@/utils/tools';

export default {
    name: 'login',
    data() {
        return {
            login:{
                loginid:'',
                passwd:''
            },
            loginRules:{
                loginid:[
                    {required:true, message:'用户名不能为空', trigger:'blur'},
                    {min:3, max:8, message:'输入长度在3-8之间', trigger:'blur'}
                ],
                passwd:{
                    required:true, message:'密码不能为空',trigger:'blur'
                }
            }
        };
    },
    methods: {
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    this.login.passwd = md5(this.login.passwd);
                    this.$api.Gurms.login(this.login).then((res)=>{
                        this.$store.commit('pub/LOGIN', res);
                        this.$store.commit('pub/ADDROUTES');
                        this.$router.push({path: '/home'});
                    }).catch((error)=>{
                        tools.errTip(error);
                    });
                }else{
                    return false;
                }
            });
        },
        onReset(formName){
            this.$refs[formName].resetFields();
        }
    }
}
</script>
