<template>
    <div>

        <el-container style="border: 1px solid #eee">
            <el-aside width="400px">
                <h5>机构列表</h5>
                <el-input clearable style="width:200px"
                    placeholder="输入关键字进行过滤"
                    v-model="filterText">
                </el-input>
                <el-button type="primary" icon="el-icon-plus" circle @click="handleAdd"></el-button>
                <el-button type="danger" icon="el-icon-delete" circle @click="handleDelete"></el-button>
                <el-tree ref="leftOrgTree"
                    :data="treeData"
                    node-key="orgid"
                    @node-click="leftTreeHandleNodeClick"
                    :filter-node-method="filterNode"
                    :props="{children: 'subOrgs',label: 'shortname'}">
                </el-tree>
            </el-aside>
            <el-main>
                <h5>机构信息</h5>
                <el-form ref="detailForm" :model="sysorg" :rules="rules" label-width="80px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                    <el-input v-model="sysorg.orgid" type="hidden"></el-input>
                    <el-form-item label="机构联号" prop="unioncode">
                        <el-input v-model="sysorg.unioncode" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                    </el-form-item>
                    <el-form-item label="机构简称" prop="shortname">
                        <el-input v-model="sysorg.shortname"></el-input>
                    </el-form-item>
                    <el-form-item label="机构全称" prop="fullname">
                        <el-input v-model="sysorg.fullname"></el-input>
                    </el-form-item>
                    <el-form-item label="上级机构" prop="parentorg">
                        <el-input v-model="sysorg.parentorg" type="hidden"></el-input>
                        <el-input v-model="parentname"></el-input>
                        <el-tree ref="parentOrgTree"
                            :data="treeData"
                            node-key="orgid"
                            @node-click="parentTreeHandleNodeClick"
                            :props="{children: 'subOrgs',label: 'shortname'}">
                        </el-tree>
                    </el-form-item>
                    <el-form-item label="机构类型" prop="orgtype">
                        <el-select v-model="sysorg.orgtype" value-key="itemcode" placeholder="请选择">
                            <el-option v-for="item in dictCache['2012']"
                                :key="item.itemcode"
                                :label="item.itemcode + ' - ' + item.itemname"
                                :value="item.itemcode">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="联系人" prop="linkman">
                        <el-input v-model="sysorg.linkman"></el-input>
                    </el-form-item>
                    <el-form-item label="联系电话" prop="linktel">
                        <el-input v-model="sysorg.linktel"></el-input>
                    </el-form-item>
                    <el-form-item label="传真" prop="faxno">
                        <el-input v-model="sysorg.faxno"></el-input>
                    </el-form-item>
                    <el-form-item label="联系地址" prop="address">
                        <el-input v-model="sysorg.address"></el-input>
                    </el-form-item>
                    <el-form-item label="邮政编码" prop="postcode">
                        <el-input v-model="sysorg.postcode"></el-input>
                    </el-form-item>
                    <el-form-item label="电子邮件" prop="email">
                        <el-input v-model="sysorg.email"></el-input>
                    </el-form-item>
                    <el-form-item label="备注" prop="remark">
                        <el-input v-model="sysorg.remark"></el-input>
                    </el-form-item>
                </el-form>
                <el-button type="primary" @click="handleEdit">修改</el-button>
                <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
                <el-button @click="onReset('detailForm')">重填</el-button>
            </el-main>
        </el-container>
    </div>
</template>

<script>
import * as tools from '@/utils/tools';

export default{
    name: 'sysorg_list',
    data(){
        return {
            //表格当前页数据
            treeData: [],
            //当前页面字典
            dictCache: {},
            //过滤条件:
            filterText: '',
            //查询条件及分页参数
            orgReq: {
                pageNum:1
            },
            //对话框表单属性
            editType: this.$pubdefine.EDIT_TYPE_DETAIL,   // insert/update
            //临时业务数据
            sysorg: {},
            parentname: '',
            //验证规则
            rules: {
                shortname: [
                    {required:true, message:'机构名称不能为空', trigger:'blur'}
                ],
                fullname: {
                    required:true, message:'机构全称不能为空', trigger:'blur'
                }
            }
        }
    },
    mounted(){
        this.loadOrgTree();
        this.loadDict('2012');
    },
    watch: {
        filterText(val) {
            this.$refs.leftOrgTree.filter(val);
        }
    },
    methods:{
        loadOrgTree:function(){
            this.$api.Gurms.orgTree(this.orgReq).then((res)=>{
                this.treeData = [];
                this.treeData.push(res);
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        loadDict:function(keys){
            this.$api.Gurms.getDictMap(keys).then((res)=>{
                this.dictCache = res.results;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        filterNode(value, data) {
            if (!value) return true;
            return data.menuname.indexOf(value) !== -1;
        },
        leftTreeHandleNodeClick(data){
            this.sysorg = data;
            this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            this.parentname = data.parentorg + " - ";
            // let node = this.$refs.leftOrgTree.getNode(data.parentorg);
            // alert(JSON.stringify(node));
        },
        parentTreeHandleNodeClick(data){
            if(this.editType !== this.$pubdefine.EDIT_TYPE_DETAIL){
                this.sysorg.parentorg = data.orgid;
                this.parentname = data.orgid + " - " + data.shortname;
            }
        },
        initOrgInfo(){
            this.sysorg = {
                orgid:'',
                unioncode:'',
                shortname:'',
                fullname:'',
                parentorg:'',
                orgtype:'',
                linkman:'',
                linktel:'',
                faxno:'',
                address:'',
                postcode:'',
                email:'',
                remark:''
            };
            this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            this.parentname = '';
        },
        handleAdd() {
            this.initOrgInfo();
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
        },
        handleDetail(index, row) {
            this.$api.Gurms.orgDetail(row.orgid).then(res =>{
                this.sysorg = res;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit() {
            this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
        },
        handleDelete() {
            let confirm_msg = "即将删除机构["+ this.sysorg.shortname + "],是否继续?";
            let that = this;
            tools.confirmTip(confirm_msg, function(){
                that.$api.Gurms.orgDelete(that.sysorg).then((res)=>{
                    tools.succTip(res.returnmsg);
                    if(res.success === true){
                        that.loadOrgTree();
                        that.initOrgInfo();
                    }
                }).catch((err)=>{
                    tools.errTip(err);
                });
            });
        },
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    var callAPI = null;
                    if(this.editType === this.$pubdefine.EDIT_TYPE_UPDATE){
                        callAPI = this.$api.Gurms.orgUpdate(this.sysorg);
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Gurms.orgAdd(this.sysorg);
                    }
                    let that = this;
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.success === true){
                            that.loadOrgTree();
                            that.initOrgInfo();
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
            if(this.$refs[formName]){
                this.$refs[formName].resetFields();
            }
        }
    }
}
</script>
