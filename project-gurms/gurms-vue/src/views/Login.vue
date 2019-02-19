<template>
    <div id="main">
        <div id="nav">
            <router-link to="/home">System Login</router-link>
        </div>

        <el-form ref="loginForm" :model="login" :rules="rules">
            <el-form-item label="用户名" prop="userid">
                <el-input v-model="login.userid"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="passwd">
                <el-input v-model="login.passwd"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('loginForm')">登录</el-button>
                <el-button  @click="onReset('loginForm')">取消</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
export default {
    data() {
        return {
            login:{
                userid:'',
                passwd:''
            },
            rules:{
                userid:[
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
                    alert("valid success");
                    this.axios({
                        type: 'post',
                        path: '/login',
                        data: this.login,
                        fn: data=>{

                        },
                        errFn: err=>{

                        }
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

