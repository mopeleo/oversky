<template>
    <el-form ref="sysuserForm" :model="sysuser" label-width="80px">
        <el-form-item label="用户姓名">
            <el-input v-model="sysuser.username"></el-input>
        </el-form-item>
        <el-form-item label="登录名">
            <el-input v-model="sysuser.loginid"></el-input>
        </el-form-item>
        <el-form-item label="登录密码">
            <el-input v-model="sysuser.loginpasswd"></el-input>
        </el-form-item>
        <el-form-item label="手机号码">
            <el-input v-model="sysuser.mobileno"></el-input>
        </el-form-item>
        <el-form-item label="电子邮件">
            <el-input v-model="sysuser.email"></el-input>
        </el-form-item>
        <el-form-item label="所属机构">
            <el-input v-model="sysuser.orgid"></el-input>
        </el-form-item>
        <el-form-item label="证件类型">
            <el-select v-model="sysuser.idtype" placeholder="请选择证件类型">
                <el-option label="身份证" value="0"></el-option>
                <el-option label="户口本" value="1"></el-option>
                <el-option label="其他" value="2"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="证件号码">
            <el-input v-model="sysuser.idcode"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit('sysuserForm')">保存</el-button>
            <el-button @click="onReset('sysuserForm')">取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
export default {
    data() {
        return {
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
        var userid = this.$route.query.userid;
        alert(userid);
    },
    methods: {
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    this.$api.Gurms.userSave(this.sysuser).then((res)=>{
                        this.$store.commit('pub/LOGIN', res.data);
                        this.$store.commit('pub/ADDROUTES');
                        this.$router.push({name: 'home'})
                    }).catch((err)=>{
                        alert(err);
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
