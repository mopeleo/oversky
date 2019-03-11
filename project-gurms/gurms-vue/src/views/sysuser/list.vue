<template>
    <div>
        <el-form ref="listForm" :model="userReq">
            <el-row>
                <el-col :span="8">
                    <el-form-item label="审批人">
                        <el-input v-model="userReq.userid" placeholder="审批人" style="width:300px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="活动区域">
                        <el-select v-model="userReq.region" placeholder="活动区域">
                            <el-option label="区域一" value="shanghai"></el-option>
                            <el-option label="区域二" value="beijing"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">查询</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%"
                @selection-change="handleSelectionChange"
                @row-click="handleClick">

                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="userid" label="Id" sortable show-overflow-tooltip></el-table-column>
                <el-table-column prop="username" label="姓名" sortable></el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
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
                    :total="tableData.page.total">
                </el-pagination>
            </div>
        </el-form>
    </div>
</template>

<script>
export default{
    data(){
        return {
            //表格当前页数据
            tableData: null,
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
                alert(err);
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
        handleEdit(index, row) {
            console.log(index, row);
        },
        handleDelete(index, row) {
            this.$api.Gurms.userDelete(row.userid).then((res)=>{
                if(res.data.success){
                    this.$options.methods.loadData.bind(this)();
                }
            }).catch((err)=>{
                alert(err);
            });
        }
    }
}
</script>
