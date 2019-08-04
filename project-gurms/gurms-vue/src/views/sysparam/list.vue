<template>
    <div>
        <el-form ref="sysparamForm" label-width="300px">
            <template v-for="param in tableData">
                <el-form-item :label="param.paramname" :key="param.paramid">
                    {{param.texttitle}}
                    <template v-if="param.edittype === '1'">
                        <el-input v-model="param.value" style="width:200px" :disabled="true"></el-input>
                    </template>
                    <template v-else-if="param.edittype === '2'">
                        <el-input v-model="param.value" :maxlength="param.valuelength" style="width:200px"></el-input>
                    </template>
                    <template v-else-if="param.edittype === '3'">
                        <el-select v-model="param.value" style="width:200px">
                            <el-option v-for="item in param.options" :key="item.value" :label="item.value + ' - ' + item.lable" :value="item.value"></el-option>
                        </el-select>
                    </template>
                    <template v-else>
                        <el-input v-model="param.value" style="width:200px" :disabled="true"></el-input>
                    </template>
                    {{param.texttail}}
                </el-form-item>
            </template>

            <el-form-item>
                <el-button type="primary" v-permission="$permission.system.param.edit" @click="onSubmit('sysparamForm')">保存</el-button>
                <el-button @click="onCancel()">取消</el-button>
                <el-button type="danger" v-permission="$permission.system.param.reset" @click="handleReset()">恢复出厂设置</el-button>
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
            var unioncode = tools.getUnioncode();
            this.$api.Gurms.paramPage(unioncode).then((res)=>{
                this.tableData = res.results;
                for(var i = 0; i< this.tableData.length; i++){
                    var paraminfo = this.tableData[i];
                    if(paraminfo.valuelist){
                        var optString = paraminfo.valuelist.split(";");
                        var options = new Array();
                        for(var j = 0; j < optString.length; j++){
                            var items = optString[j].split("|");
                            var option = {};
                            option.value=items[0];
                            option.lable=items[1];
                            options.push(option);
                        }
                        paraminfo.options = options;
                    }
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleReset() {
            var unioncode = tools.getUnioncode();
            this.$api.Gurms.paramReset(unioncode).then(res =>{
                tools.succTip(res.returnmsg);
                this.loadData();
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        onSubmit(formName) {
            // paramList =  key1:value1;key2:value2
            tools.confirmTip("是否确定恢复出厂设置?", ()=>{
                var paramList = '';
                var unioncode = tools.getUnioncode();
                for(var i = 0; i< this.tableData.length; i++){
                    var param = this.tableData[i];
                    paramList += param.paramid + ':' + param.value + ';';
                }
                if(paramList.length > 1){
                    paramList = paramList.substring(0, paramList.length-1);
                }
                // alert(paramList);
                this.$api.Gurms.paramUpdate(unioncode, paramList).then(res =>{
                    tools.succTip(res.returnmsg);
                }).catch((err)=>{
                    tools.errTip(err);
                });
            });
        },
        onCancel(){
            this.loadData();
        }
    }
}
</script>
