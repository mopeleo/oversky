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
                        <el-select v-model="userReq.status" placeholder="用户状态">
                            <el-option label="已删除" value="0"></el-option>
                            <el-option label="正常" value="1"></el-option>
                            <el-option label="锁定" value="2"></el-option>
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
                @selection-change="handleSelectionChange"
                @row-click="handleClick">

                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="username" label="姓名" sortable></el-table-column>
                <el-table-column prop="loginid" label="登录名" sortable></el-table-column>
                <el-table-column prop="mobileno" label="手机号码" sortable></el-table-column>
                <el-table-column prop="email" label="电子邮件" show-overflow-tooltip></el-table-column>
                <el-table-column prop="orgid" label="所属机构" sortable></el-table-column>
                <el-table-column prop="status" label="用户状态"></el-table-column>
                <el-table-column prop="logindate" label="登录日期" sortable></el-table-column>
                <el-table-column prop="logintime" label="登录时间" sortable></el-table-column>
                <el-table-column prop="passwdvaliddate" label="密码失效日期"></el-table-column>
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
                    :current-page="userReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="userReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>
    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //查询条件及分页参数
            userReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            }
        }
    },
    mounted(){
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Gurms.userList(this.userReq).then((res)=>{
                this.tableData = res.data;
            }).catch((err)=>{
                tools.errTip(err.data ? err.data.returnmsg : err.message);
            });
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
        //多选响应
        handleSelectionChange: function(val) {
            console.log(val);
            // this.multipleSelection = val;
        },
        handleAdd() {
            this.$router.push({name: 'sysuser/detail'});
        },
        handleDetail(index, row) {
            this.$router.push({name: 'sysuser/detail', params: {userid: row.userid, edit: false}});
        },
        handleEdit(index, row) {
            // this.$router.push({path: '/home/sysuser/detail', query: {userid: row.userid}});
            this.$router.push({name: 'sysuser/detail', params: {userid: row.userid, edit: true}});
        },
        handleDelete(index, row) {
            this.$api.Gurms.userDelete(row.userid).then((res)=>{
                if(res.data === true){
                    this.$message({message: '删除成功', type: 'success', showClose: true});
                    this.$options.methods.loadData.bind(this)();
                }else{
                    this.$message({message: '删除失败', type: 'error', showClose: true, duration: 0});
                }
            }).catch((err)=>{
                tools.errTip(err.data ? err.data.message : err);
            });
        }
    }
}
</script>
