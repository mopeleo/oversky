<template>
    <div>
        <el-form ref="sysparamForm" :model="sysuser" :rules="rules" label-width="80px" :disabled="!edit">
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
            <el-form-item>
                <el-button type="primary" @click="onSubmit('sysparamForm')">保存</el-button>
                <el-button @click="onReset('sysparamForm')">重填</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default {
    name: 'sysparam_list',

    data() {
        return {
            tableData:[]
        }
    },
    mounted(){
        this.loadData();
    },
    methods: {
        loadData:function(){
            this.$api.Gurms.paramPage().then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleRest() {
            this.$api.Gurms.paramReset().then(res =>{
                tools.succTip(res.returnmsg);
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit() {
            var paramList = null;
            this.$api.Gurms.paramUpdate(paramList).then(res =>{
                tools.succTip(res.returnmsg);
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        onReset(formName){
            this.$refs[formName].resetFields();
        }
    }
}
</script>
