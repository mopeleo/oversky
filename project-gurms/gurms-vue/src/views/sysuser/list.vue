<template>
    <div>
        <el-form ref="listForm" :model="userReq">
            <el-table ref="testTable" :data="tableData.results" border style="width:100%" :row-class-name="tableRowClassName"
                @selection-change="handleSelectionChange"
                @row-click="handleclick">

                <el-table-column type="selection"></el-table-column>
                <el-table-column prop="userid" label="Id" sortable show-overflow-tooltip></el-table-column>
                <el-table-column prop="username" label="姓名" sortable></el-table-column>
            </el-table>
            <div class="block">
                <el-pagination layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="userReq.pageNum"
                    :page-sizes="[5, 10, 30, 50]"
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
                pageSize:5,
                pageNum:1
            }
        }
    },
    mounted(){
        this.loadData();
    },
    methods:{
        loadData:function(){
            alert(JSON.stringify(this.userReq));
            this.$api.Gurms.userList(this.userReq).then((res)=>{
                this.tableData = res.data;
            }).catch((err)=>{
                alert(err);
            });

        }
    }
}
</script>
