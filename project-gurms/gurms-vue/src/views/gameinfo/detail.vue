<template>
    <div>
        <el-form ref="gameinfoForm" :model="gameinfo" :rules="rules" label-width="120px"  :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
        <el-collapse v-model="activeNames">
        <el-collapse-item title="基本信息" name="1">
            <el-row :gutter="24">
                <el-col :span="12">
                    <el-form-item label="游戏简称" prop="gamename">
                        <el-input v-model="gameinfo.gamename" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="游戏编号" prop="gamecode">
                        <el-input v-model="gameinfo.gamecode" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="24">
                <el-col :span="12">
                    <el-form-item label="英文简称" prop="englishname">
                        <el-input v-model="gameinfo.englishname"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="游戏全称" prop="fullname">
                        <el-input v-model="gameinfo.fullname"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            </el-collapse-item>
            <el-collapse-item title="周期信息" name="2">
            <el-row :gutter="24">
                <el-col :span="12">
                    <el-form-item label="封测日期" prop="alphatest">
                        <el-input v-model="gameinfo.alphatest"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="公测日期" prop="betatest">
                        <el-input v-model="gameinfo.betatest"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            </el-collapse-item>
            <el-collapse-item title="其他信息" name="3">
            <el-row :gutter="24">
                <el-col :span="12">
                    <el-form-item label="游戏状态" prop="status">
                        <el-input v-model="gameinfo.status"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                </el-col>
            </el-row>
            <el-row :gutter="24">
                <el-col :span="20">
                    <el-form-item label="备注" prop="summary">
                        <el-input v-model="gameinfo.summary"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            </el-collapse-item>
            </el-collapse>
            <el-row :gutter="24">
                <el-col :span="20">
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit('gameinfoForm')">保存</el-button>
                        <el-button @click="onReset('gameinfoForm')">重填</el-button>
                        <el-button type="primary" @click="$router.back(-1)">返回</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default {
    name: 'gameinfo_detail',

    data() {
        return {
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            activeNames: ['1'],
            //当前页面字典
            dictCache: {},
            gameinfo:{
                gameid:'',
                unioncode:'',
                gamecode:'',
                gamename:'',
                englishname:'',
                fullname:'',
                status:'',
                alphatest:'',
                betatest:''
            },
            rules:{
                gamecode:[
                    {required:true, message:'游戏编号不能为空', trigger:'blur'},
                    {min:3, max:8, message:'输入长度在3-8之间', trigger:'blur'}
                ],
                gamename:{
                    required:true, message:'游戏简称不能为空',trigger:'blur'
                }
            }
        }
    },
    mounted(){
        tools.loadComDict('2000,2001', this.dictCache);
        var gameid = this.$route.params.gameid;
        alert(gameid);
        // var gameid = this.$route.query.gameid;
        if(gameid && gameid != 0){
            this.$api.Game.gameInfoDetail(gameid).then((res)=>{
                // alert(JSON.stringify(res));
                this.gameinfo.gameid = res.gameid;
                this.gameinfo.unioncode = res.unioncode;
                this.gameinfo.gamename = res.gamename;
                this.gameinfo.gamecode = res.gamecode;
                this.gameinfo.englishname = res.englishname;
                this.gameinfo.fullname = res.fullname;
                this.gameinfo.alphatest = res.alphatest;
                this.gameinfo.betatest = res.betatest;
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
                        if(this.$route.params.gameid){
                            callAPI = this.$api.Game.gameInfoUpdate(this.gameinfo);
                        }else{
                            callAPI = this.$api.Game.gameInfoAdd(this.gameinfo);
                        }
                    callAPI.then((res)=>{
                        if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
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
