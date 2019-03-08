<template>
    <div id="main">
        <div id="nav">
            <router-link to="/home">System Login</router-link>
        </div>

        <el-form ref="loginForm" :model="login" :rules="rules">
            <el-form-item label="用户名" prop="loginid">
                <el-input type="text" v-model="login.loginid" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="passwd">
                <el-input type="password" v-model="login.passwd"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('loginForm')">登录</el-button>
                <el-button  @click="onReset('loginForm')">取消</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
import md5 from 'js-md5';
import * as pub from '@/utils/pub';

export default {
    data() {
        return {
            login:{
                loginid:'',
                passwd:''
            },
            rules:{
                loginid:[
                    {required:true, message:'用户名不能为空', trigger:'blur'},
                    {min:3, max:8, message:'输入长度在3-8之间', trigger:'blur'}
                ],
                passwd:{
                    required:true, message:'密码不能为空',trigger:'blur'
                }
            }
        }
    },
    methods: {
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    this.login.passwd = md5(this.login.passwd);
                    this.$api.Gurms.login(this.login).then((res)=>{
                        // alert(JSON.stringify(res.data));
                        let routes = pub.addDynamicMenuRoutes(res.data.menuTree.subMenus);
                        for (var i = 0; i < routes.length; i++) {
                            this.$router.options.routes[0].children.push(routes[i]);
                        }
                        this.$router.addRoutes(this.$router.options.routes);
                        this.$store.commit('pub/LOGIN', res.data);
                        this.$router.push({name: 'home'})
                    }).catch((err)=>{
                        alert(err.data.message);
                    });
                }else{
                    alert("valid failure");
                    return false;
                }
            })
        },
        onReset(formName){
            this.$refs[formName].resetFields();
        }
    }
}
</script>

