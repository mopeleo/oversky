<template>
    <el-row class="tac" :gutter="20">
        <el-col :span="6">
            <h5>机构列表</h5>
            <el-input clearable style="width:200px"
                placeholder="输入关键字进行过滤"
                v-model="filterText">
            </el-input>
            <el-button type="primary" icon="el-icon-plus" circle></el-button>
            <el-tree ref="orgTree"
                :data="treeData"
                node-key="orgid"
                :filter-node-method="filterNode"
                :props="{children: 'subOrgs',label: 'shortname'}">
            </el-tree>
        </el-col>
        <el-col :span="12">
            <h5>机构信息</h5>
            <el-form ref="detailForm" :model="sysrole" :rules="rules" label-width="80px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                <el-input v-model="sysrole.roleid" type="hidden"></el-input>
                <el-form-item label="角色名称" prop="rolename">
                    <el-input v-model="sysrole.rolename" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                </el-form-item>
                <el-form-item label="角色状态" prop="status">
                    <el-select v-model="sysrole.status" value-key="itemcode" placeholder="请选择">
                        <el-option v-for="item in dictCache['1003']"
                            :key="item.itemcode"
                            :label="item.itemcode + ' - ' + item.itemname"
                            :value="item.itemcode">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="角色类型" prop="roletype">
                    <el-select v-model="sysrole.roletype" value-key="itemcode" placeholder="请选择">
                        <el-option v-for="item in dictCache['2006']"
                            :key="item.itemcode"
                            :label="item.itemcode + ' - ' + item.itemname"
                            :value="item.itemcode">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="有效期" prop="startdate">
                    <el-date-picker type="daterange" range-separator="至"
                        start-placeholder="开始日期" end-placeholder="结束日期"
                        v-model="dateArray" value-format="yyyyMMdd" >
                    </el-date-picker>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
                    <el-button @click="onReset('detailForm')">重填</el-button>
                    <el-button type="primary" @click="dialogFormVisible = false;">关闭</el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </el-row>
</template>

<script>
import * as tools from '@/utils/tools'

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
            roleReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            dialogFormVisible: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            sysrole: {
                roleid:'',
                rolename:'',
                status:'',
                roletype:'',
                startdate:'',
                enddate:'',
                menulist:'',
                creator:''
            },
            dateArray: [],
            unioncode: this.$store.state.pub.user.unioncode,
            operator: this.$store.state.pub.user.userid,
            //验证规则
            rules: {
                rolename: [
                    {required:true, message:'角色名称不能为空', trigger:'blur'}
                ],
                startdate: {
                    required:true, message:'有效期开始日期不能为空',trigger:'blur'
                },
                enddate: {
                    required:true, message:'有效期结束日期不能为空',trigger:'blur'
                }
            }
        }
    },
    mounted(){
        this.loadOrgTree();
        this.loadDict('1003,2006');
    },
    watch: {
        filterText(val) {
            this.$refs.orgTree.filter(val);
        }
    },
    methods:{
        loadOrgTree:function(){
            this.$api.Gurms.orgTree(this.roleReq).then((res)=>{
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
        formatRoleStatus:function(row){
            let dict = this.dictCache['1003'];
            let val = row.status;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode === val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        formatRoleType:function(row){
            let dict = this.dictCache['2006'];
            let val = row.roletype;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode === val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        filterNode(value, data) {
            if (!value) return true;
            return data.menuname.indexOf(value) !== -1;
        },
        getMenuList:function(){
            let ids = this.$refs.orgTree.getCheckedKeys();
            let halfIds = this.$refs.orgTree.getHalfCheckedKeys();
            let orgTreetring = ids.concat(halfIds).join(",");
            return orgTreetring;
        },
        setMenuList:function(orgTree){
            if(orgTree){
                let menuArray = orgTree.split(",");
                this.$refs.orgTree.setCheckedKeys(menuArray);
            }
        },
        handleAdd() {
            this.dialogFormVisible = true;
            this.sysrole = {
                roleid:'',
                rolename:'',
                status:'',
                roletype:'',
                startdate:'',
                enddate:'',
                menulist:'',
                creator:''
            };
            this.dateArray = [];
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
            // let that = this;
            // this.$nextTick(function () {
            //     that.sysrole = res.data;
            // });
        },
        handleDetail(index, row) {
            this.$api.Gurms.roleDetail(row.roleid).then(res =>{
                this.dialogFormVisible = true;
                this.sysrole = res;
                this.dateArray[0] = this.sysrole.startdate;
                this.dateArray[1] = this.sysrole.enddate;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;

                this.$nextTick(function() {
                    this.setMenuList(this.sysrole.menulist);
                })
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit(index, row) {
            this.$api.Gurms.roleDetail(row.roleid).then(res =>{
                this.dialogFormVisible = true;
                this.sysrole = res;
                this.dateArray[0] = this.sysrole.startdate;
                this.dateArray[1] = this.sysrole.enddate;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;

                this.$nextTick(function() {
                    this.setMenuList(this.sysrole.menulist);
                })
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        onSubmit(formName){
            if(this.dateArray.length == 2){
                this.sysrole.startdate = this.dateArray[0];
                this.sysrole.enddate = this.dateArray[1];
            }
            this.sysrole.menulist = this.getMenuList();
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    //从session赋值
                    this.sysrole.unioncode = this.unioncode;
                    this.sysrole.creator = this.operator;
                    var callAPI = null;
                    if(this.editType === this.$pubdefine.EDIT_TYPE_UPDATE){
                        callAPI = this.$api.Gurms.roleUpdate(this.sysrole);
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Gurms.roleAdd(this.sysrole);
                    }
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.success === true){
                            this.dialogFormVisible = false;
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
