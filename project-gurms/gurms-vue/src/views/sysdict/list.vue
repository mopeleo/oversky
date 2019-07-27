<template>
    <div>
        <el-form ref="listForm" :model="dictReq" label-width="70px">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="字典代码">
                        <el-input v-model="dictReq.dictcode" placeholder="字典代码"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="字典名称">
                        <el-input v-model="dictReq.dictname" placeholder="字典名称"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="4">
                    <el-form-item>
                        <el-button type="primary" icon="el-icon-search" @click="loadData">查询</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%">

                <el-table-column type="index" width="50"></el-table-column>
                <el-table-column prop="unioncode" label="法人行代码"></el-table-column>
                <el-table-column prop="dictcode" label="字典代码"></el-table-column>
                <el-table-column prop="dictname" label="字典名称"></el-table-column>
                <el-table-column prop="itemcode" label="字典项"></el-table-column>
                <el-table-column prop="itemname" label="字典项名称"></el-table-column>
            </el-table>
            <div class="block">
                <el-pagination layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="dictReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="dictReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>

    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    name: 'sysdict_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //查询条件及分页参数
            dictReq: {
                pageSize: 10,
                pageNum:1
            },
        }
    },
    mounted(){
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Gurms.dictPage(this.dictReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.dictReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.dictReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
    }
}
</script>
