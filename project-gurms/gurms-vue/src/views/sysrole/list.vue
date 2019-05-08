<template>
    <div>
        <el-form ref="listForm" :model="roleReq">
            <el-row>
                <el-col :span="8">
                    <el-form-item label="角色名称">
                        <el-input v-model="roleReq.rolename" placeholder="角色名称" style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="角色状态">
                        <el-select v-model="roleReq.status" placeholder="角色状态">
                            <el-option label="无效" value="0"></el-option>
                            <el-option label="有效" value="1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item>
                        <el-button type="primary" @click="loadData">查询</el-button>
                        <el-button type="primary" @click="handleAdd">新增</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%"
                @selection-change="handleSelectionChange"
                @row-click="handleClick">

                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="roleid" label="角色ID" sortable></el-table-column>
                <el-table-column prop="rolename" label="角色名称" sortable></el-table-column>
                <el-table-column prop="status" label="角色状态"></el-table-column>
                <el-table-column prop="roletype" label="角色类型"></el-table-column>
                <el-table-column prop="startdate" label="生效日期" sortable></el-table-column>
                <el-table-column prop="enddate" label="失效日期" sortable></el-table-column>
                <el-table-column prop="creator" label="创建人"></el-table-column>
                <el-table-column fixed="right" width="240" label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" type="primary" @click="handleDetail(scope.$index, scope.row)">查看</el-button>
                        <el-button size="mini" type="primary" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="block">
                <el-pagination layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="roleReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="roleReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>

        <el-dialog title="角色信息" v-if="dialogFormVisible" :visible.sync="dialogFormVisible">
            <el-form ref="detailForm" :model="sysrole" :rules="rules" label-width="80px" :disabled="!edit">
                <el-input v-model="sysrole.roleid" type="hidden"></el-input>
                <el-form-item label="角色名称" prop="rolename">
                    <el-input v-model="sysrole.rolename" :disabled="!(edit&&editType ==='insert')"></el-input>
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
                    <el-select v-model="sysrole.roletype" placeholder="请选择">
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
        </el-dialog>

    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    name: 'sysrole_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //当前页面字典
            dictCache:{},
            //查询条件及分页参数
            roleReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            dialogFormVisible: false,
            edit:true,
            editType:'insert',   // insert/update
            //临时业务数据
            sysrole:null,
            dateArray:[],
            unioncode:this.$store.state.pub.user.unioncode,
            operator:this.$store.state.pub.user.userid,
            //验证规则
            rules:{
                rolename:[
                    {required:true, message:'角色名称不能为空', trigger:'blur'}
                ],
                startdate:{
                    required:true, message:'角色生效日期不能为空',trigger:'blur'
                },
                enddate:{
                    required:true, message:'角色失效日期不能为空',trigger:'blur'
                }
            }
        }
    },
    mounted(){
        // tools.initPageDict('1003,2006', this.dictCache);
        this.loadData();
        this.loadDict();
    },
    methods:{
        loadData:function(){
            this.$api.Gurms.roleList(this.roleReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        loadDict:function(){
            this.$api.Gurms.getDictMap(this.unioncode, '1003,2006').then((res)=>{
                this.dictCache = res.results;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        //点击行响应
        handleClick: function(row, column, event){
            console.log(row.roleid + column + event);
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.roleReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.roleReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
        //多选响应
        handleSelectionChange: function(val) {
            console.log(val);
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
                creator:''
            };
            this.dateArray = [];
            this.edit = true;
            this.editType = 'insert';
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
                this.edit = false;
                this.editType = null;
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
                this.edit = true;
                this.editType = 'update';
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleDelete(index, row) {
            this.$api.Gurms.roleDelete(row.roleid).then((res)=>{
                if(res === true){
                    tools.succTip('删除成功');
                    this.$options.methods.loadData.bind(this)();
                }else{
                    tools.errTip('删除失败');
                }
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        onSubmit(formName){
            if(this.dateArray.length == 2){
                this.sysrole.startdate = this.dateArray[0];
                this.sysrole.enddate = this.dateArray[1];
            }
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    //从session赋值
                    this.sysrole.unioncode = this.unioncode;
                    this.sysrole.creator = this.operator;
                    var callAPI = null;
                    if(this.edit){
                        if(this.editType === 'update'){
                            callAPI = this.$api.Gurms.roleUpdate(this.sysrole);
                        }else if(this.editType === 'insert'){
                            callAPI = this.$api.Gurms.roleAdd(this.sysrole);
                        }
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
