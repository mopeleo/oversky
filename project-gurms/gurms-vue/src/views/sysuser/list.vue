<template>
    <div>
        <el-form ref="listForm" :model="userReq">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="用户姓名">
                        <el-input v-model="userReq.username" placeholder="姓名" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="手机号码">
                        <el-input v-model="userReq.mobileno" placeholder="手机号码" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="用户状态">
                        <el-select v-model="userReq.status" value-key="itemcode" clearable placeholder="请选择">
                            <el-option v-for="item in dictCache['2001']"
                                :key="item.itemcode"
                                :label="item.itemcode + ' - ' + item.itemname"
                                :value="item.itemcode">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item>
                        <el-button type="primary" icon="el-icon-search" @click="loadData">查询</el-button>
                        <el-button type="primary" v-permission="$permission.system.user.add" icon="el-icon-plus" @click="handleAdd">新增</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%"
                @row-click="handleClick">
                <el-table-column type="index" width="50"></el-table-column>
                <el-table-column prop="username" label="姓名" sortable></el-table-column>
                <el-table-column prop="loginid" label="登录名" sortable></el-table-column>
                <el-table-column prop="mobileno" width="120" label="手机号码"></el-table-column>
                <el-table-column prop="email" label="电子邮件" show-overflow-tooltip></el-table-column>
                <el-table-column prop="orgid" label="所属机构" sortable :formatter="formatOrgName"></el-table-column>
                <el-table-column prop="status" width="100" label="用户状态" :formatter="formatUserStatus"></el-table-column>
                <el-table-column prop="logindate" width="120" label="登录日期" sortable></el-table-column>
                <el-table-column prop="logintime" width="100" label="登录时间"></el-table-column>
                <el-table-column prop="passwdvaliddate" width="120" label="密码失效日期"></el-table-column>
                <el-table-column fixed="right" width="180" label="操作">
                    <template slot-scope="scope" v-if="scope.row.userid !== $store.state.pub.user.userid">
                    <el-row :gutter="5">
                    <el-col :span="10">
                        <el-button type="danger" size="mini"
                            v-permission="$permission.system.user.delete" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </el-col>
                    <el-col :span="14">
                        <el-dropdown split-button type="primary" size="mini" @command="handleCommand"
                            @click="handleDetail(scope.$index, scope.row)" trigger="click">详情
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item v-permission="$permission.system.user.edit" :command="composeValue('a', scope.row)">修改信息</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.system.user.grantrole" :command="composeValue('b', scope.row)">分配角色</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.system.user.resetpassword" :command="composeValue('c', scope.row)">重置密码</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.system.user.freeze" :command="composeValue('d', scope.row)" v-if="scope.row.status=='1'">冻结账户</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.system.user.unfreeze" :command="composeValue('e', scope.row)" v-if="scope.row.status=='3'">解冻账户</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </el-col>
                    </el-row>
                    </template>
                </el-table-column>
            </el-table>
            <div class="block">
                <el-pagination layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="userReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="userReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>

<!--
        <el-dialog title="用户信息" v-if="dialogFormVisible" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
            <el-form ref="detailForm" :model="sysuser" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="用户姓名" prop="username">
                            <el-input v-model="sysuser.username" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="登录名" prop="loginid">
                            <el-input v-model="sysuser.loginid" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="手机号码" prop="mobileno">
                            <el-input v-model="sysuser.mobileno"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="电子邮件" prop="email">
                            <el-input v-model="sysuser.email"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="所属机构" prop="orgid">
                            <el-cascader :options="treeData" :show-all-levels="false" v-model="sysuser.orgid"
                                :props="{value:'orgid', children:'subOrgs', label:'shortname', checkStrictly:true, emitPath:false}"></el-cascader>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="证件姓名" prop="idname">
                            <el-input v-model="sysuser.idname"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="证件类型" prop="idtype">
                            <el-select v-model="sysuser.idtype" value-key="itemcode" clearable placeholder="请选择">
                                <el-option v-for="item in dictCache['2004']"
                                    :key="item.itemcode"
                                    :label="item.itemcode + ' - ' + item.itemname"
                                    :value="item.itemcode">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="证件号码" prop="idcode">
                            <el-input v-model="sysuser.idcode"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row type="flex" justify="end">
                    <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
                    <el-button type="primary" @click="dialogFormVisible = false;">关闭</el-button>
                </el-row>
            </el-form>

        </el-dialog>
-->

        <el-dialog title="分配角色" v-if="dialogGrantRole" :visible.sync="dialogGrantRole" :close-on-click-modal="false" width="35%">
            <el-row type="flex" justify="center" class="row-role">
                待分配用户姓名：{{this.sysuser.username}}({{this.sysuser.loginid}})
            </el-row>
            <el-row type="flex" justify="center" class="row-role">
                <el-transfer filterable :filter-method="filterMethod"
                    filter-placeholder="请输入角色"
                    :titles="['待分配角色', '已选择角色']"
                    v-model="selectRoles"
                    :props="{key: 'roleid',label: 'rolename'}"
                    :data="allRoles">
                </el-transfer>
            </el-row>
            <el-row type="flex" justify="center" class="row-role">
                <el-button type="primary" @click="handGrantRoles">确定</el-button>
                <el-button @click="dialogGrantRole = false;selectRoles=[];">取消</el-button>
            </el-row>
        </el-dialog>

        <el-drawer ref="drawer" title="用户信息" custom-class="demo-drawer" size="40%"
            :wrapperClosable="drawerCloseFlag" :visible.sync="userDetailDrawer">

            <div class="demo-drawer__content">
                <el-form ref="drawerForm" :model="sysuser" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="用户姓名" prop="username">
                                <el-input v-model="sysuser.username" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="登录名" prop="loginid">
                                <el-input v-model="sysuser.loginid" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="手机号码" prop="mobileno">
                                <el-input v-model="sysuser.mobileno"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="电子邮件" prop="email">
                                <el-input v-model="sysuser.email"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="所属机构" prop="orgid">
                                <el-cascader :options="treeData" :show-all-levels="false" v-model="sysuser.orgid"
                                    :props="{value:'orgid', children:'subOrgs', label:'shortname', checkStrictly:true, emitPath:false}"></el-cascader>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="证件姓名" prop="idname">
                                <el-input v-model="sysuser.idname"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="证件类型" prop="idtype">
                                <el-select v-model="sysuser.idtype" value-key="itemcode" clearable placeholder="请选择">
                                    <el-option v-for="item in dictCache['2004']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="证件号码" prop="idcode">
                                <el-input v-model="sysuser.idcode"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="邮政编码" prop="postcode">
                                <el-input v-model="sysuser.postcode"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="性别" prop="sex">
                                <el-select v-model="sysuser.sex" value-key="itemcode" placeholder="请选择">
                                    <el-option v-for="item in dictCache['2000']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="20">
                            <el-form-item label="联系地址" prop="address">
                                <el-input type="textarea" v-model="sysuser.address"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
                <div class="demo-drawer__footer">
                    <el-row type="flex" justify="center" v-if="editType !== this.$pubdefine.EDIT_TYPE_DETAIL">
                        <el-button type="primary" @click="onSubmit('drawerForm')">保存</el-button>
                        <el-button type="primary" @click="userDetailDrawer = false;">关闭</el-button>
                    </el-row>
                </div>
            </div>
        </el-drawer>

    </div>
</template>

<script>
import * as tools from '@/utils/tools';

export default{
    name: 'sysuser_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            treeData: [],
            //当前页面字典
            dictCache: {},
            dictOrg: [],
            //查询条件及分页参数
            userReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            userDetailDrawer: false,
            drawerCloseFlag: false,
            dialogFormVisible: false,
            dialogGrantRole: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            sysuser: {
                userid:'',
                unioncode:'',
                username:'',
                loginid:'',
                mobileno:'',
                email:'',
                orgid:'',
                orgname:'',
                idname:'',
                idtype:'',
                idcode:'',
                sex:'',
                postcode:'',
                address:''
            },
            allRoles:[],    //所有角色
            selectRoles:[], //已选角色
            rules:{
                loginid:[
                    {required:true, message:'登录名不能为空', trigger:'blur'},
                    {min:4, max:32, message:'登录名长度在4-32之间', trigger:'blur'}
                ],
                username:[
                    {required:true, message:'用户姓名不能为空', trigger:'blur'},
                    {min:2, max:16, message:'用户姓名长度在2-16之间', trigger:'blur'}
                ],
                mobileno:{required:true, message:'手机号码不能为空', trigger:'blur'},
                orgid:{required:true, message:'所属机构不能为空', trigger:'blur'},
                birthday:{type:'date', message:'请输入正确的日期', trigger:'blur'},
                email:[
                    {max:64, message:'email长度不能超过64位', trigger:'blur'},
                    {type:'email', message:'请输入正确的email地址', trigger:'blur'}
                ]
            }
        }
    },
    mounted(){
        tools.loadDict('2000,2001,2004', this.dictCache);
        this.loadOrgTree();
        this.loadDict({type:'T01'});
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Gurms.userList(this.userReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        loadDict:function(keys){
            this.$api.Gurms.getDictType(keys).then((res)=>{
                this.dictOrg = res.results;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        formatOrgName:function(row){
            let dict = this.dictOrg;
            let val = row.orgid;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode == val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        formatUserStatus:function(row){
            let dict = this.dictCache['2001'];
            let val = row.status;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode == val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        loadOrgTree:function(){
            this.$api.Gurms.orgTree(this.userReq).then((res)=>{
                this.treeData = [];
                this.treeData.push(res);
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        loadCanGrantRoles:function(){
            let operator = this.$store.getters['pub/userinfo'].userid;
            this.$api.Gurms.canGrantRoles(operator, this.sysuser.unioncode).then((res)=>{
                this.allRoles = [];
                this.allRoles = res.results;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        loadSelectRoles:function(){
            this.$api.Gurms.hasRoles(this.sysuser.userid, this.sysuser.unioncode).then((res)=>{
                this.selectRoles = [];
                for(var i = 0; i < res.results.length; i++){
                    this.selectRoles[i] = res.results[i].roleid;
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        getOrgId(value){
            this.sysuser.orgid = value.orgid;
        },
        parentTreeHandleNodeClick(data){
            if(this.editType !== this.$pubdefine.EDIT_TYPE_DETAIL){
                this.sysuser.orgid = data.orgid;
                this.sysuser.orgname = data.orgid + " - " + data.shortname;
            }
        },
        filterMethod(query, item) {
            return item.rolename.indexOf(query) > -1;
        },
        //点击行响应
        handleClick: function(row, column, event){
            console.log(row.userid + column + event);
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.userReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.userReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
        composeValue(index, row) {
            return {
                'index': index,
                'row': row
            }
        },
        handleCommand(command) {
            if(command.index === 'a'){
                this.handleEdit(command.index, command.row);
            }else if(command.index === 'b'){
                this.grantRoles(command.row);
            }else if(command.index === 'c'){
                this.resetPassword(command.row);
            }else if(command.index === 'd'){
                this.freezeUser(command.row);
            }else if(command.index === 'e'){
                this.unfreezeUser(command.row);
            }else{
                alert(JSON.stringify(command));
            }
        },
        grantRoles(userInfo){
            this.sysuser = userInfo;
            this.dialogGrantRole = true;
            this.loadCanGrantRoles();
            this.loadSelectRoles();
        },
        resetPassword(userInfo){
            this.$api.Gurms.userResetPassword(userInfo).then(res =>{
                tools.succTip(res.returnmsg);
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        freezeUser(userInfo){
            this.$api.Gurms.userFreeze(userInfo).then(res =>{
                tools.succTip(res.returnmsg);
                if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                    userInfo.status ='3';
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        unfreezeUser(userInfo){
            this.$api.Gurms.userUnfreeze(userInfo).then(res =>{
                tools.succTip(res.returnmsg);
                if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                    userInfo.status ='1';
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handGrantRoles(){
            if(this.selectRoles && this.selectRoles.length > 0){
                this.sysuser.roleList = this.selectRoles.join(',');
            }
            this.$api.Gurms.userGrantRoles(this.sysuser).then(res =>{
                tools.succTip(res.returnmsg);
                if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                    this.dialogGrantRole = false;
                    this.selectRoles = [];
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleAdd() {
            // this.dialogFormVisible = true;
            this.userDetailDrawer = true;
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
            this.sysuser = {
                userid:'',
                unioncode:'',
                username:'',
                loginid:'',
                mobileno:'',
                email:'',
                orgid:'',
                orgname:'',
                idname:'',
                idtype:'',
                idcode:'',
                sex:'',
                postcode:'',
                address:''
            }
        },

        handleDetail(index, row) {
            // this.$router.push({name: 'sysuser/detail', params: {userid: row.userid, edit: false}});
            this.$api.Gurms.userDetail(row.userid).then(res =>{
                // this.dialogFormVisible = true;
                this.userDetailDrawer = true;
                this.sysuser = res;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit(index, row) {
            // this.$router.push({name: 'sysuser/detail', params: {userid: row.userid, edit: true}});
            this.$api.Gurms.userDetail(row.userid).then(res =>{
                // this.dialogFormVisible = true;
                this.userDetailDrawer = true;
                this.sysuser = res;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleDelete(index, row) {
            tools.confirmTip("是否确定删除用户?", ()=>{
                this.sysuser = {
                    userid : row.userid
                },
                this.$api.Gurms.userDelete(this.sysuser).then((res)=>{
                    tools.succTip(res.returnmsg);
                    this.$options.methods.loadData.bind(this)();
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
                        callAPI = this.$api.Gurms.userUpdate(this.sysuser);
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Gurms.userAdd(this.sysuser);
                    }
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                            // this.dialogFormVisible = true;
                            this.userDetailDrawer = false;
                            this.$options.methods.loadData.bind(this)();
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
<style>
.row-role {
    margin-bottom: 20px;
    &:last-child {
        margin-bottom: 0;
    }
}
</style>
