<template>
    <div class="app-container">
        <!-- 左侧树 -->
        <div class="left">
            <div class="" style="padding-bottom: 10px;">
                <el-row :gutter="10" type="flex">
                    <el-col :span="12">
                        <el-input clearable style="width:200px" placeholder="输入关键字进行过滤" v-model="filterText"></el-input>
                    </el-col>
                    <el-col :span="6">
                        <el-button type="primary" icon="el-icon-plus" v-permission="$permission.system.org.add" @click="handleAdd">新增</el-button>
                    </el-col>
                    <el-col :span="6">
                    </el-col>
                </el-row>
            </div>
            <el-tree ref="leftOrgTree" :data="treeData" node-key="orgid" :expand-on-click-node="false"
                @node-click="leftTreeHandleNodeClick" :highlight-current="true"
                :filter-node-method="filterNode" :props="{children: 'subOrgs',label: 'shortname'}">

                <span class="custom-tree-node" slot-scope="{ node, data }">
                    <span>{{ node.label }}</span>
                    <div v-if="data.parentorg">
                        <span>
                            <el-button type="text" v-permission="$permission.system.org.edit" @click="() => handleEdit(data)" icon="el-icon-edit"></el-button>
                            <el-button type="text" v-permission="$permission.system.org.delete" @click="() => handleDelete(node, data)" icon="el-icon-delete"></el-button>
                        </span>
                    </div>
                </span>
            </el-tree>
        </div>
        <div class="right">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span class="title">机构信息</span>
                </div>
                <div class="text item">
                    <el-form ref="detailForm" :model="sysorg" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="机构编号" prop="orgid">
                                    {{sysorg.orgid}}
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="多法人编号" prop="unioncode" v-if="this.paramSysMode == '2' && sysorg.parentorg == 1">
                                    <el-input v-model="sysorg.unioncode"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="机构简称" prop="shortname">
                                    <el-input v-model="sysorg.shortname"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="上级机构" prop="parentorg">
                                    <SelectTree :props="{value:'orgid', children: 'subOrgs',label: 'shortname'}" :options="treeData"
                                        :value="sysorg.parentorg" :accordion="true" :clearable="false" @getValue="getOrgId($event)">
                                    </SelectTree>

                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="机构全称" prop="fullname">
                                    <el-input v-model="sysorg.fullname"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="机构类型" prop="orgtype">
                                    <el-select v-model="sysorg.orgtype" value-key="itemcode" placeholder="请选择">
                                        <el-option v-for="item in dictCache['2012']" :key="item.itemcode" :label="item.itemcode + ' - ' + item.itemname" :value="item.itemcode">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="联系电话" prop="linktel">
                                    <el-input v-model="sysorg.linktel"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="传真" prop="faxno">
                                    <el-input v-model="sysorg.faxno"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="联系人" prop="linkman">
                                    <el-input v-model="sysorg.linkman"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="电子邮件" prop="email">
                                    <el-input v-model="sysorg.email"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="联系地址" prop="address">
                                    <el-input v-model="sysorg.address"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="邮政编码" prop="postcode">
                                    <el-input v-model="sysorg.postcode"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="15">
                                <el-form-item label="备注" prop="remark">
                                    <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}"
                                        placeholder="请输入内容" v-model="sysorg.remark">
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row type="flex" justify="center">
                            <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
                            <el-button @click="onCancel">取消</el-button>
                        </el-row>
                    </el-form>
                </div>
            </el-card>
        </div>
    </div>
</template>
<script>
import * as tools from '@/utils/tools';
import SelectTree from '@/components/SelectTree.vue';

export default {
    name: 'sysorg_list',
    components:{SelectTree},
    data() {
        return {
            //表格当前页数据
            treeData: [],
            //当前页面字典
            dictCache: {},
            paramSysMode: null,
            //过滤条件:
            filterText: '',
            //查询条件及分页参数
            orgReq: {
                pageNum: 1
            },
            //对话框表单属性
            editType: this.$pubdefine.EDIT_TYPE_DETAIL, // insert/update
            //临时业务数据
            sysorg: {},
            //验证规则
            rules: {
                shortname: [
                    { required: true, message: '机构名称不能为空', trigger: 'blur' }
                ],
                fullname: {
                    required: true,
                    message: '机构全称不能为空',
                    trigger: 'blur'
                }
            }
        }
    },
    mounted() {
        tools.loadDict('2012', this.dictCache);
        this.loadOrgTree();
        this.getParam('1000');
    },
    watch: {
        filterText(val) {
            this.$refs.leftOrgTree.filter(val);
        }
    },
    methods: {
        loadOrgTree: function() {
            this.$api.Gurms.orgTree(this.orgReq).then((res) => {
                this.treeData = [];
                this.treeData.push(res);
            }).catch((err) => {
                tools.errTip(err);
            });
        },
        getParam:function(keys){
            var unioncode = tools.getUnioncode();
            this.$api.Gurms.getParam(keys, unioncode).then((res) => {
                this.paramSysMode = res.paramvalue;
            }).catch((err) => {
                tools.errTip(err);
            });
        },
        filterNode(value, data) {
            if (!value) return true;
            return data.shortname.indexOf(value) !== -1;
        },
        initOrgInfo() {
            this.sysorg = {
                orgid: '',
                unioncode: '',
                shortname: '',
                fullname: '',
                parentorg: '',
                orgtype: '',
                linkman: '',
                linktel: '',
                faxno: '',
                address: '',
                postcode: '',
                email: '',
                remark: ''
            };
            this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
        },
        getOrgId(value){
            this.sysorg.parentorg = value.parentorg;
            this.sysorg.unioncode = value.unioncode;
        },
        leftTreeHandleNodeClick(data){
            if(data.orgid !== this.sysorg.orgid){
                this.sysorg = data;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            }
        },
        handleAdd() {
            this.initOrgInfo();
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
        },
        handleEdit(data) {
            this.sysorg = data;
            this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
        },
        handleDelete(node, data) {
            let confirm_msg = "即将删除机构[" + data.shortname + "],是否继续?";
            tools.confirmTip(confirm_msg, () => {
                this.$api.Gurms.orgDelete(data).then((res) => {
                    tools.succTip(res.returnmsg);
                    if (res.success === true) {
                        this.loadOrgTree();
                        this.initOrgInfo();
                    }
                }).catch((err) => {
                    tools.errTip(err);
                });
            });
        },
        onSubmit(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    var callAPI = null;
                    if (this.editType === this.$pubdefine.EDIT_TYPE_UPDATE) {
                        callAPI = this.$api.Gurms.orgUpdate(this.sysorg);
                    } else if (this.editType === this.$pubdefine.EDIT_TYPE_INSERT) {
                        if(!this.sysorg.unioncode){
                            if(this.paramSysMode == '1'){
                                this.sysorg.unioncode = tools.getUnioncode();
                            }else{
                                this.sysorg.unioncode;
                            }
                        }
                        callAPI = this.$api.Gurms.orgAdd(this.sysorg);
                    }
                    let that = this;
                    callAPI.then((res) => {
                        tools.succTip(res.returnmsg);
                        if (res.success === true) {
                            that.loadOrgTree();
                            that.initOrgInfo();
                        }
                    }).catch((err) => {
                        tools.errTip(err);
                    });
                } else {
                    return false;
                }
            })
        },
        onCancel() {
            this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
        }
    }
}
</script>
<style scoped lang="scss">
.custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
}

.title {
    font-size: 16px;
    color: red;
}

.left {
    width: 400px;
}

.right {
    margin-left: 410px;
    height: 100%;
    overflow: auto;
}
</style>
