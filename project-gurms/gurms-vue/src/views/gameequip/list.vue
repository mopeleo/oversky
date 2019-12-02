<template>
    <div>
        <el-form ref="listForm" :model="custInfoReq">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="客户名称">
                        <el-input v-model="custInfoReq.custname" placeholder="客户名称" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="手机号码">
                        <el-input v-model="custInfoReq.mobileno" placeholder="手机号码" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="客户状态">
                        <el-select v-model="custInfoReq.status" value-key="itemcode" clearable placeholder="请选择">
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
                        <el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%"
                @row-click="handleClick">
                <el-table-column type="index" width="50"></el-table-column>
                <el-table-column prop="custname" label="客户名称" sortable></el-table-column>
                <el-table-column prop="loginid" label="登录名" sortable></el-table-column>
                <el-table-column prop="custtype" label="客户类型" :formatter="((row)=>formatTableCol(row.custtype, '2007'))"></el-table-column>
                <el-table-column prop="mobileno" width="120" label="手机号码"></el-table-column>
                <el-table-column prop="status" width="100" label="客户状态" :formatter="((row)=>formatTableCol(row.status, '2001'))"></el-table-column>
                <el-table-column prop="regdate" width="120" label="注册日期"></el-table-column>
                <el-table-column prop="lastlogindate" width="120" label="登录日期"></el-table-column>
                <el-table-column prop="lastlogintime" width="100" label="登录时间"></el-table-column>
                <el-table-column prop="email" label="电子邮件" show-overflow-tooltip></el-table-column>
                <el-table-column fixed="right" width="180" label="操作">
                    <template slot-scope="scope" v-if="scope.row.custno !== $store.state.pub.user.custno">
                    <el-row :gutter="5">
                    <el-col :span="10">
                        <el-button type="danger" size="mini" @click="handleDetail(scope.$index, scope.row)">注销</el-button>
                    </el-col>
                    <el-col :span="14">
                        <el-dropdown split-button type="primary" size="mini" @command="handleCommand"
                            @click="handleDetail(scope.$index, scope.row)" trigger="click">详情
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item :command="composeValue('a', scope.row)">修改信息</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.game.custinfo.resetpassword" :command="composeValue('c', scope.row)">重置密码</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.game.custinfo.freeze" :command="composeValue('d', scope.row)" v-if="scope.row.status=='1'">冻结账户</el-dropdown-item>
                                <el-dropdown-item v-permission="$permission.game.custinfo.unfreeze" :command="composeValue('e', scope.row)" v-if="scope.row.status=='3'">解冻账户</el-dropdown-item>
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
                    :current-page="custInfoReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="custInfoReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>


        <el-drawer ref="drawer" title="客户信息" custom-class="demo-drawer" size="40%"
            :wrapperClosable="drawerCloseFlag" :visible.sync="userDetailDrawer">

            <div class="demo-drawer__content">
                <el-form ref="drawerForm" :model="custinfo" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="客户姓名" prop="custname">
                                <el-input v-model="custinfo.custname" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="登录名" prop="loginid">
                                <el-input v-model="custinfo.loginid" :disabled="editType === this.$pubdefine.EDIT_TYPE_UPDATE"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="手机号码" prop="mobileno">
                                <el-input v-model="custinfo.mobileno"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="电子邮件" prop="email">
                                <el-input v-model="custinfo.email"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="客户类型" prop="custtype">
                                <el-select v-model="custinfo.custtype" value-key="itemcode" placeholder="请选择" @change="changeCustType">
                                    <el-option v-for="item in dictCache['2007']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                           </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="证件姓名" prop="idname">
                                <el-input v-model="custinfo.idname"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="证件类型" prop="idtype">
                                <el-select v-model="custinfo.idtype" value-key="itemcode" clearable placeholder="请选择">
                                    <el-option v-for="item in dictIdType"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="证件号码" prop="idcode">
                                <el-input v-model="custinfo.idcode"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-divider><i class="el-icon-mobile-phone"></i></el-divider>

                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="性别" prop="sex">
                                <el-select v-model="custinfo.sex" value-key="itemcode" placeholder="请选择">
                                    <el-option v-for="item in dictCache['2000']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="生日" prop="birthday">
                                <el-date-picker v-model="custinfo.birthday" type="date" placeholder="选择日期" value-format="yyyyMMdd" style="width:190px"></el-date-picker>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="邮政编码" prop="postcode">
                                <el-input v-model="custinfo.postcode"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="联系地址" prop="address">
                                <el-input v-model="custinfo.address"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="固定电话" prop="phone">
                                <el-input v-model="custinfo.phone"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="民族" prop="ethnicity">
                                <el-input v-model="custinfo.ethnicity"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="所在省份" prop="province">
                                <el-input v-model="custinfo.province"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="所在城市" prop="city">
                                <el-input v-model="custinfo.city"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="教育程度" prop="education">
                                <el-input v-model="custinfo.education"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="职业" prop="profession">
                                <el-input v-model="custinfo.profession"></el-input>
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
    name: 'custinfo_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //当前页面字典
            dictCache: {},
            dictIdType:[],
            //查询条件及分页参数
            custInfoReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            userDetailDrawer: false,
            drawerCloseFlag: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            custinfo: {
                custno:'',
                unioncode:'',
                custname:'',
                loginid:'',
                mobileno:'',
                email:'',
                custtype:'',
                idname:'',
                idtype:'',
                idcode:'',
                sex:'',
                birthday:'',
                postcode:'',
                address:'',
                phone:'',
                ethnicity:'',
                province:'',
                city:'',
                education:'',
                profession:''
            }
        }
    },
    mounted(){
        tools.loadComDict('2000,2001,2004,2005,2007', this.dictCache);
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Game.custInfoList(this.custInfoReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        formatTableCol:function(val, dictcode){
            let dict = this.dictCache[dictcode];
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode == val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        changeCustType:function(){
            this.custinfo.idtype = '';
            if(this.custinfo.custtype == '0'){
                this.dictIdType=this.dictCache['2005'];
            }else{
                this.dictIdType=this.dictCache['2004'];
            }
        },
        //点击行响应
        handleClick: function(row, column, event){
            console.log(row.custno + column + event);
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.custInfoReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.custInfoReq.pageNum = val;
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
                alert(JSON.stringify(command));
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
        resetPassword(userInfo){
            this.$api.Game.custInfoResetPasswd(userInfo).then(res =>{
                tools.succTip(res.returnmsg);
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        freezeUser(userInfo){
            this.$api.Game.custInfoFreeze(userInfo).then(res =>{
                tools.succTip(res.returnmsg);
                if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                    userInfo.status ='3';
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        unfreezeUser(userInfo){
            this.$api.Game.custInfoUnfreeze(userInfo).then(res =>{
                tools.succTip(res.returnmsg);
                if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                    userInfo.status ='1';
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },

        handleAdd() {
            this.userDetailDrawer = true;
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
            this.custinfo = {
                custno:'',
                unioncode:'',
                username:'',
                loginid:'',
                mobileno:'',
                email:'',
                custtype:'',
                idname:'',
                idtype:'',
                idcode:'',
                sex:'',
                birthday:'',
                postcode:'',
                address:'',
                phone:'',
                ethnicity:'',
                province:'',
                city:'',
                education:'',
                profession:''
            }
        },
        handleDetail(index, row) {
            this.$api.Game.custInfoDetail(row.custno).then(res =>{
                this.userDetailDrawer = true;
                this.custinfo = res;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
                var idtype = res.idtype;
                this.changeCustType();
                this.custinfo.idtype = idtype;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit(index, row) {
            this.$api.Game.custInfoDetail(row.custno).then(res =>{
                this.userDetailDrawer = true;
                this.custinfo = res;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    var callAPI = null;
                    if(this.editType === this.$pubdefine.EDIT_TYPE_UPDATE){
                        callAPI = this.$api.Game.custInfoUpdate(this.custinfo);
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Game.custInfoAdd(this.custinfo);
                    }
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
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
