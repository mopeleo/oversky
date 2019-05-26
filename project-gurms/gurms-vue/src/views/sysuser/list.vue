<template>
    <div>
        <el-form ref="listForm" :model="userReq">
            <el-row>
                <el-col :span="6">
                    <el-form-item label="姓名">
                        <el-input v-model="userReq.username" placeholder="姓名" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="手机号码">
                        <el-input v-model="userReq.mobileno" placeholder="手机号码" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
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
                <el-col :span="6">
                    <el-form-item>
                        <el-button type="primary" @click="loadData">查询</el-button>
                        <el-button type="primary" @click="handleAdd">新增</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%"
                @row-click="handleClick">
                <el-table-column type="index" width="50"></el-table-column>
                <el-table-column prop="username" label="姓名" sortable></el-table-column>
                <el-table-column prop="loginid" label="登录名" sortable></el-table-column>
                <el-table-column prop="mobileno" label="手机号码" sortable></el-table-column>
                <el-table-column prop="email" label="电子邮件" show-overflow-tooltip></el-table-column>
                <el-table-column prop="orgid" label="所属机构" sortable></el-table-column>
                <el-table-column prop="status" label="用户状态" :formatter="formatUserStatus"></el-table-column>
                <el-table-column prop="logindate" label="登录日期" sortable></el-table-column>
                <el-table-column prop="logintime" label="登录时间" sortable></el-table-column>
                <el-table-column prop="passwdvaliddate" label="密码失效日期"></el-table-column>
                <el-table-column fixed="right" width="200" label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                        <el-dropdown split-button size="mini" type="primary" @command="handleCommand"
                            @click="handleEdit(scope.$index, scope.row)">编辑
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item :command="composeValue('a', scope.row)">详细信息</el-dropdown-item>
                                <el-dropdown-item :command="composeValue('b', scope.row)">分配角色</el-dropdown-item>
                                <el-dropdown-item :command="composeValue('c', scope.row)">重置密码</el-dropdown-item>
                                <el-dropdown-item :command="composeValue('d', scope.row)">冻结账户</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
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

        <el-dialog title="用户信息" v-if="dialogFormVisible" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
            <el-form ref="detailForm" :model="sysuser" :rules="rules" label-width="80px"
                :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                <el-input v-model="sysuser.userid" type="hidden"></el-input>
                <el-input v-model="sysuser.orgid" type="hidden"></el-input>
                <el-form-item label="用户姓名" prop="username">
                    <el-input v-model="sysuser.username" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                </el-form-item>
                <el-form-item label="登录名" prop="loginid">
                    <el-input v-model="sysuser.loginid" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                </el-form-item>
                <el-form-item label="手机号码" prop="mobileno">
                    <el-input v-model="sysuser.mobileno"></el-input>
                </el-form-item>
                <el-form-item label="电子邮件" prop="email">
                    <el-input v-model="sysuser.email"></el-input>
                </el-form-item>
                <el-form-item label="所属机构" prop="orgid">
                    <el-input v-model="sysuser.orgname"></el-input>
                    <el-tree ref="parentOrgTree"
                        :data="treeData"
                        node-key="orgid"
                        @node-click="parentTreeHandleNodeClick"
                        :props="{children: 'subOrgs',label: 'shortname'}">
                    </el-tree>
                </el-form-item>
                <el-form-item label="证件类型" prop="idtype">
                    <el-select v-model="sysuser.idtype" value-key="itemcode" clearable placeholder="请选择">
                        <el-option v-for="item in dictCache['2004']"
                            :key="item.itemcode"
                            :label="item.itemcode + ' - ' + item.itemname"
                            :value="item.itemcode">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="证件号码" prop="idcode">
                    <el-input v-model="sysuser.idcode"></el-input>
                </el-form-item>
            </el-form>
            <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
            <el-button @click="onReset('detailForm')">重填</el-button>
            <el-button type="primary" @click="dialogFormVisible = false;">关闭</el-button>

        </el-dialog>

    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    name: 'sysuser_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            treeData: [],
            //当前页面字典
            dictCache: {},
            //查询条件及分页参数
            userReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            dialogFormVisible: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            sysuser: null,
            rules:{
                loginid:[
                    {required:true, message:'用户名不能为空', trigger:'blur'},
                    {min:3, max:8, message:'输入长度在3-8之间', trigger:'blur'}
                ],
                username:{
                    required:true, message:'用户姓名不能为空',trigger:'blur'
                }
            }
        }
    },
    mounted(){
        tools.loadDict('2001,2004', this.dictCache);
        this.loadOrgTree();
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
        formatUserStatus:function(row){
            let dict = this.dictCache['2001'];
            let val = row.status;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode === val){
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
        parentTreeHandleNodeClick(data){
            if(this.editType !== this.$pubdefine.EDIT_TYPE_DETAIL){
                this.sysuser.orgid = data.orgid;
                this.sysuser.orgname = data.orgid + " - " + data.shortname;
            }
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
                this.handleDetail(command.index, command.row);
            }else{
                alert(JSON.stringify(command));
            }
        },
        handleAdd() {
            // this.$router.push({name: 'sysuser/detail'});
            this.dialogFormVisible = true;
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
                idtype:'',
                idcode:''
            }
        },

        handleDetail(index, row) {
            // this.$router.push({name: 'sysuser/detail', params: {userid: row.userid, edit: false}});
            this.$api.Gurms.userDetail(row.userid).then(res =>{
                this.dialogFormVisible = true;
                this.sysuser = res;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit(index, row) {
            // this.$router.push({name: 'sysuser/detail', params: {userid: row.userid, edit: true}});
            this.$api.Gurms.userDetail(row.userid).then(res =>{
                this.dialogFormVisible = true;
                this.sysuser = res;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleDelete(index, row) {
            tools.confirmTip("是否确定删除用户?", ()=>{
                this.$api.Gurms.userDelete(row.userid).then((res)=>{
                    if(res === true){
                        tools.succTip('删除成功');
                        this.$options.methods.loadData.bind(this)();
                    }else{
                        tools.succTip('删除失败');
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
                        callAPI = this.$api.Gurms.userUpdate(this.sysuser);
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Gurms.userAdd(this.sysuser);
                    }
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.success === true){
                            this.dialogFormVisible = false;
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
