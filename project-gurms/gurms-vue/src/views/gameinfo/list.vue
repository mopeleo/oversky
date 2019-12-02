<template>
    <div>
        <el-form ref="listForm" :model="gameInfoReq">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="游戏简称">
                        <el-input v-model="gameInfoReq.gamename" placeholder="游戏简称" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="游戏编号">
                        <el-input v-model="gameInfoReq.gamecode" placeholder="游戏编号" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="游戏状态">
                        <el-select v-model="gameInfoReq.status" value-key="itemcode" clearable placeholder="请选择">
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
                        <el-button type="primary" v-permission="$permission.game.gameinfo.add" icon="el-icon-plus" @click="handleAdd">新增</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%" @row-click="handleClick">
                <el-table-column type="index" width="50"></el-table-column>
                <el-table-column prop="gamename" label="游戏简称" sortable></el-table-column>
                <el-table-column prop="gamecode" width="120" label="游戏编号" sortable></el-table-column>
                <el-table-column prop="englishname" label="英文简称"></el-table-column>
                <el-table-column prop="fullname" width="120" label="游戏全称"></el-table-column>
                <el-table-column prop="status" width="120" label="游戏状态"></el-table-column>
                <el-table-column prop="alphatest" width="120" label="封测日期"></el-table-column>
                <el-table-column prop="betatest" width="100" label="公测日期"></el-table-column>
                <el-table-column fixed="right" width="240" label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini" type="primary" @click="handleDetail(scope.$index, scope.row)">查看</el-button>
                        <el-button size="mini" type="primary" v-permission="$permission.game.gameinfo.edit" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button size="mini" type="danger" v-permission="$permission.game.gameinfo.delete" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="block">
                <el-pagination layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="gameInfoReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="gameInfoReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>

    </div>
</template>

<script>
import * as tools from '@/utils/tools';

export default{
    name: 'gameinfo_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //当前页面字典
            dictCache: {},
            //查询条件及分页参数
            gameInfoReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            }
        }
    },
    mounted(){
        tools.loadComDict('2000,2001', this.dictCache);
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Game.gameInfoList(this.gameInfoReq).then((res)=>{
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
        //点击行响应
        handleClick: function(row, column, event){
            console.log(row.custno + column + event);
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.gameInfoReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.gameInfoReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
        handleAdd() {
            this.$router.push({name: 'gameinfo/detail'});
        },
        handleDetail(index, row) {
            alert(row.gameid);
            this.$router.push({name: 'gameinfo/detail', params: {gameid: row.gameid, edit: false}});
        },
        handleEdit(index, row) {
            this.$router.push({name: 'gameinfo/detail', params: {gameid: row.gameid, edit: true}});
        },
        handleDelete(index, row) {
            tools.confirmTip("是否确定删除游戏[" + row.gamename + "]?", () => {
                var gameinfo = {
                    gameid : row.gameid
                };
                this.$api.Game.gameInfoDelete(gameinfo).then((res)=>{
                    tools.succTip(res.returnmsg);
                    this.$options.methods.loadData.bind(this)();
                }).catch((err)=>{
                    tools.errTip(err);
                });
            });
        }
    }
}
</script>
