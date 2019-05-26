<template>
    <div>
        <el-form ref="sysuserForm" :model="sysuser" :rules="rules" label-width="80px" :disabled="!edit">
            <el-form-item label="用户姓名" prop="username">
                <el-input v-model="sysuser.username" :disabled="sysuser.userid?true:false"></el-input>
            </el-form-item>
            <el-form-item label="登录名" prop="loginid">
                <el-input v-model="sysuser.loginid" :disabled="sysuser.userid?true:false"></el-input>
            </el-form-item>
            <el-form-item label="登录密码" prop="loginpasswd">
                <el-input v-model="sysuser.loginpasswd"></el-input>
            </el-form-item>
            <el-form-item label="手机号码" prop="mobileno">
                <el-input v-model="sysuser.mobileno"></el-input>
            </el-form-item>
            <el-form-item label="电子邮件" prop="email">
                <el-input v-model="sysuser.email"></el-input>
            </el-form-item>
            <el-form-item label="所属机构" prop="orgid">
                <el-input v-model="sysuser.orgid"></el-input>
            </el-form-item>
            <el-form-item label="证件类型" prop="idtype">
                <el-select v-model="sysuser.idtype" placeholder="请选择证件类型">
                    <el-option label="身份证" value="0"></el-option>
                    <el-option label="户口本" value="1"></el-option>
                    <el-option label="其他" value="2"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="证件号码" prop="idcode">
                <el-input v-model="sysuser.idcode"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('sysuserForm')">保存</el-button>
                <el-button @click="onReset('sysuserForm')">重填</el-button>
                <el-button type="primary" @click="$router.back(-1)">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default {
    name: 'user_detail_form',

    data() {
        return {
            edit:true,
            sysuser:{
                userid:'',
                unioncode:'',
                username:'',
                loginid:'',
                loginpasswd:'',
                mobileno:'',
                email:'',
                orgid:'',
                idtype:'',
                idcode:''
            },
            rules:{
                loginid:[
                    {required:true, message:'用户名不能为空', trigger:'blur'},
                    {min:3, max:8, message:'输入长度在3-8之间', trigger:'blur'}
                ],
                loginpasswd:{
                    required:true, message:'密码不能为空',trigger:'blur'
                }
            }
        }
    },
    mounted(){
        var userid = this.$route.params.userid;
        // var userid = this.$route.query.userid;
        if(userid && userid != 0){
            this.$api.Gurms.userDetail(userid).then((res)=>{
                // alert(JSON.stringify(res));
                this.sysuser.userid = res.userid;
                this.sysuser.unioncode = res.unioncode;
                this.sysuser.username = res.username;
                this.sysuser.loginid = res.loginid;
                this.sysuser.loginpasswd = res.loginpasswd;
                this.sysuser.mobileno = res.mobileno;
                this.sysuser.email = res.email;
                this.sysuser.orgid = res.orgid;
                this.sysuser.idtype = res.idtype;
                this.sysuser.idcode = res.idcode;
            }).catch((err)=>{
                tools.errTip(err);
            });
            this.edit = this.$route.params.edit;
        }
    },
    methods: {
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    var callAPI = null;
                    if(this.edit){
                        if(this.$route.params.userid){
                            callAPI = this.$api.Gurms.userUpdate(this.sysuser);
                        }else{
                            callAPI = this.$api.Gurms.userAdd(this.sysuser);
                        }
                    }
                    callAPI.then((res)=>{
                        if(res.success === true){
                            this.$router.back(-1);
                        }
                    }).catch((err)=>{
                        tools.errTip(err);
                    });
                }else{
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
