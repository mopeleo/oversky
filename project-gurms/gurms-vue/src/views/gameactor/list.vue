<template>
    <div>
        <el-form ref="listForm" :model="gameActorReq">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="角色名称">
                        <el-input v-model="gameActorReq.actorname" placeholder="角色名称" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="角色ID">
                        <el-input v-model="gameActorReq.actorid" placeholder="角色ID" style="width:200px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="所属游戏">
                        <el-select v-model="gameActorReq.gameid" value-key="itemcode" clearable placeholder="请选择">
                            <el-option v-for="item in dictGame"
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

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%">
                <el-table-column type="index" width="30"></el-table-column>
                <el-table-column prop="actorid" label="角色ID" width="70"></el-table-column>
                <el-table-column prop="actorname" label="角色名称"></el-table-column>
                <el-table-column prop="gameid" label="所属游戏" :formatter="formatGameName"></el-table-column>
                <el-table-column prop="sex" width="80" label="角色性别" :formatter="((row)=>formatTableCol(row.sex, '2000'))"></el-table-column>
                <el-table-column prop="race" width="100" label="种族" :formatter="((row)=>formatTableCol(row.race, '2015'))"></el-table-column>
                <el-table-column prop="profession" width="100" label="职业" :formatter="((row)=>formatTableCol(row.profession, '2016'))"></el-table-column>
                <el-table-column prop="ratiotype" width="100" label="成长系数" :formatter="((row)=>formatTableCol(row.ratiotype, '2017'))"></el-table-column>
                <el-table-column prop="str" label="初始力量"></el-table-column>
                <el-table-column prop="magic" label="初始魔力"></el-table-column>
                <el-table-column prop="hp" label="初始生命值"></el-table-column>
                <el-table-column prop="mp" label="初始魔法值"></el-table-column>
                <el-table-column prop="agl" label="初始敏捷"></el-table-column>
                <el-table-column prop="luck" label="初始幸运"></el-table-column>
                <el-table-column fixed="right" width="220" label="操作">
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
                    :current-page="gameActorReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="gameActorReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>


        <el-drawer ref="drawer" title="角色信息" custom-class="demo-drawer" size="40%"
            :wrapperClosable="drawerCloseFlag" :visible.sync="detailDrawer">

            <div class="box">
            <el-scrollbar>
                <el-form ref="drawerForm" :model="gameactor" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                    <el-row>
                        <el-col :span="10">
                            <el-form-item label="角色图片" prop="picurl">
                                <el-upload class="upload-demo"
                                    action="/dreamland/upload"
                                    :limit="1" list-type="picture">
                                    <el-button size="small" type="primary">点击上传</el-button>
                                </el-upload>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-row>
                                <el-form-item label="角色ID" prop="actorid">
                                    <el-input v-model="gameactor.actorid" :disabled="true"></el-input>
                                </el-form-item>
                            </el-row>
                            <el-row>
                                <el-form-item label="角色姓名" prop="actorname">
                                    <el-input v-model="gameactor.actorname"></el-input>
                                </el-form-item>
                            </el-row>
                            <el-row>
                                <el-form-item label="角色性别" prop="sex">
                                    <el-select v-model="gameactor.sex" value-key="itemcode" placeholder="请选择">
                                        <el-option v-for="item in dictCache['2000']"
                                            :key="item.itemcode"
                                            :label="item.itemcode + ' - ' + item.itemname"
                                            :value="item.itemcode">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-row>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="所属游戏" prop="gameid">
                                    <el-select v-model="gameactor.gameid" value-key="itemcode" placeholder="请选择">
                                        <el-option v-for="item in dictGame"
                                            :key="item.itemcode"
                                            :label="item.itemcode + ' - ' + item.itemname"
                                            :value="item.itemcode">
                                        </el-option>
                                    </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="成长系数" prop="ratiotype">
                                <el-select v-model="gameactor.ratiotype" value-key="itemcode" placeholder="请选择">
                                    <el-option v-for="item in dictCache['2017']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="角色种族" prop="race">
                                <el-select v-model="gameactor.race" value-key="itemcode" placeholder="请选择">
                                    <el-option v-for="item in dictCache['2015']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                           </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="职业" prop="profession">
                                <el-select v-model="gameactor.profession" value-key="itemcode" placeholder="请选择">
                                    <el-option v-for="item in dictCache['2016']"
                                        :key="item.itemcode"
                                        :label="item.itemcode + ' - ' + item.itemname"
                                        :value="item.itemcode">
                                    </el-option>
                                </el-select>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-divider><i class="el-icon-mobile-phone"></i></el-divider>

                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="初始力量" prop="str">
                                <el-input v-model="gameactor.str"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="初始魔力" prop="magic">
                                <el-input v-model="gameactor.magic"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="初始生命值" prop="hp">
                                <el-input v-model="gameactor.hp"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="初始魔法值" prop="mp">
                                <el-input v-model="gameactor.mp"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="初始敏捷" prop="agl">
                                <el-input v-model="gameactor.agl"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="初始幸运" prop="luck">
                                <el-input v-model="gameactor.luck"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="初始星级" prop="initrank">
                                <el-input v-model="gameactor.initrank"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="最大星级" prop="maxrank">
                                <el-input v-model="gameactor.maxrank"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="力量成长率" prop="ratiostr">
                                <el-input v-model="gameactor.ratiostr"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="魔法成长率" prop="ratiomagic">
                                <el-input v-model="gameactor.ratiomagic"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="生命值成长率" prop="ratiohp">
                                <el-input v-model="gameactor.ratiohp"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="魔法值成长率" prop="ratiomp">
                                <el-input v-model="gameactor.ratiomp"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="敏捷成长率" prop="ratioagl">
                                <el-input v-model="gameactor.ratioagl"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="幸运成长率" prop="ratioluck">
                                <el-input v-model="gameactor.ratioluck"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="10">
                            <el-form-item label="父角色ID" prop="father">
                                <el-input v-model="gameactor.father"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="10">
                            <el-form-item label="母角色ID" prop="mother">
                                <el-input v-model="gameactor.mother"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
                </el-scrollbar>
                <div class="demo-drawer__footer">
                    <el-row type="flex" justify="center" v-if="editType !== this.$pubdefine.EDIT_TYPE_DETAIL">
                        <el-button type="primary" @click="onSubmit('drawerForm')">保存</el-button>
                        <el-button type="primary" @click="detailDrawer = false;">关闭</el-button>
                    </el-row>
                </div>
            </div>
        </el-drawer>

    </div>
</template>

<script>
import * as tools from '@/utils/tools';

export default{
    name: 'gameactor_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //当前页面字典
            dictCache: {},
            dictGame: [],
            //查询条件及分页参数
            gameActorReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            detailDrawer: false,
            drawerCloseFlag: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            gameactor: {
                actorid:'',
                unioncode:'',
                gameid:'',
                sex:'',
                race:'',
                profession:'',
                str:'',
                magic:'',
                hp:'',
                mp:'',
                agl:'',
                luck:'',
                initrank:'',
                maxrank:'',
                ratiotype:'',
                ratiostr:'',
                ratiomagic:'',
                ratiohp:'',
                ratiomp:'',
                ratioagl:'',
                ratioluck:'',
                father:'',
                mother:''
            }
        }
    },
    mounted(){
        tools.loadComDict('2000,2015,2016,2017', this.dictCache);
        this.loadData();
        this.loadDict({type:'T20'});
    },
    methods:{
        loadData:function(){
            this.$api.Game.gameActorList(this.gameActorReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        loadDict:function(keys){
            this.$api.Game.getDictType(keys).then((res)=>{
                this.dictGame = res.results;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        formatGameName:function(row){
            let dict = this.dictGame;
            let val = row.gameid;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode == val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
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
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.gameActorReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.gameActorReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
        handleAdd() {
            this.detailDrawer = true;
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
            this.gameactor = {
                actorid:'',
                unioncode:'',
                gameid:'',
                sex:'',
                race:'',
                profession:'',
                str:'',
                magic:'',
                hp:'',
                mp:'',
                agl:'',
                luck:'',
                initrank:'',
                maxrank:'',
                ratiotype:'',
                ratiostr:'',
                ratiomagic:'',
                ratiohp:'',
                ratiomp:'',
                ratioagl:'',
                ratioluck:'',
                father:'',
                mother:''
            }
        },
        handleDetail(index, row) {
            this.$api.Game.gameActorDetail(row.actorid).then(res =>{
                this.detailDrawer = true;
                this.gameactor = res;
                this.gameactor.gameid = res.gameid + "";
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit(index, row) {
            this.$api.Game.gameActorDetail(row.actorid).then(res =>{
                this.detailDrawer = true;
                this.gameactor = res;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleDelete(index, row) {
            tools.confirmTip("是否确定删除游戏角色[" + row.actorname + "]?", () => {
                var gameactor = {
                    actorid : row.actorid
                };
                this.$api.Game.gameActorDelete(gameactor).then((res)=>{
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
                        callAPI = this.$api.Game.gameActorUpdate(this.gameactor);
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Game.gameActorAdd(this.gameactor);
                    }
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                            this.detailDrawer = false;
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
    .box {
        height: 800px;
    }
    .el-scrollbar {
        height: 100%;
    }
    .el-scrollbar__wrap {
        overflow-x: hidden;
    }
</style>
