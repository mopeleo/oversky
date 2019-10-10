<template>
    <div>
        <el-form ref="listForm" :model="snoReq" label-width="70px">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="序列编号">
                        <el-input v-model="snoReq.noid" placeholder="序列编号" clearable></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="序列名称">
                        <el-input v-model="snoReq.noname" placeholder="序列名称" clearable></el-input>
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
                <el-table-column prop="unioncode" label="机构代码"></el-table-column>
                <el-table-column prop="noid" label="序列编号"></el-table-column>
                <el-table-column prop="noname" label="序列名称"></el-table-column>
                <el-table-column prop="initvalue" label="初始值"></el-table-column>
                <el-table-column prop="nextvalue" label="下个值"></el-table-column>
                <el-table-column prop="fixedflag" label="定长标志" :formatter="formatFixedFlag"></el-table-column>
                <el-table-column prop="fixedlength" label="定长长度"></el-table-column>
                <el-table-column prop="fillchar" label="填充字符"></el-table-column>
                <el-table-column prop="notype" label="增减类型" :formatter="formatNoType"></el-table-column>
                <el-table-column prop="cycletype" width="120" label="循环周期" :formatter="formatCycleType"></el-table-column>
                <el-table-column prop="cycledate" label="循环日期"></el-table-column>
                <el-table-column prop="endvalue" label="重置阈值"></el-table-column>
                <el-table-column prop="prefix" label="前缀"></el-table-column>
                <el-table-column prop="suffix" label="后缀"></el-table-column>
                <el-table-column fixed="right" label="操作">
                    <template slot-scope="scope">
                        <el-button type="primary" v-permission="$permission.system.sno.edit" @click="handleEdit(scope.$index, scope.row)">修改</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="block">
                <el-pagination layout="total, sizes, prev, pager, next, jumper"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="snoReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="snoReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>


        <el-dialog title="序列信息" v-if="dialogFormVisible" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
            <el-form ref="detailForm" :model="syssno" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="机构代码" prop="unioncode">
                            <el-input v-model="syssno.unioncode" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="循环周期" prop="cycletype">
                            <el-select v-model="syssno.cycletype" value-key="itemcode" placeholder="请选择">
                                <el-option v-for="item in dictCache['1015']"
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
                        <el-form-item label="序列编号" prop="noid">
                            <el-input v-model="syssno.noid" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="序列名称" prop="noname">
                            <el-input v-model="syssno.noname" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="初始值" prop="initvalue">
                            <el-input v-model="syssno.initvalue" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="下个值" prop="nextvalue">
                            <el-input v-model="syssno.nextvalue" :disabled="true"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="增减类型" prop="notype">
                            <el-select v-model="syssno.notype" value-key="itemcode" :disabled="true">
                                <el-option v-for="item in dictCache['1016']"
                                    :key="item.itemcode"
                                    :label="item.itemcode + ' - ' + item.itemname"
                                    :value="item.itemcode">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="定长标志" prop="fixedflag">
                            <el-select v-model="syssno.fixedflag" value-key="itemcode" placeholder="请选择">
                                <el-option v-for="item in dictCache['1014']"
                                    :key="item.itemcode"
                                    :label="item.itemcode + ' - ' + item.itemname"
                                    :value="item.itemcode">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" v-if="syssno.fixedflag == '1'">
                    <el-col :span="10">
                        <el-form-item label="定长长度" prop="fixedlength">
                            <el-input v-model="syssno.fixedlength"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="填充字符" prop="fillchar">
                            <el-input v-model="syssno.fillchar"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="循环日期" prop="cycledate">
                            <el-date-picker v-model="syssno.cycledate" type="date" placeholder="选择日期" value-format="yyyyMMdd" ></el-date-picker>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="重置阈值" prop="endvalue">
                            <el-input v-model="syssno.endvalue"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="前缀" prop="prefix">
                            <el-input v-model="syssno.prefix"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="后缀" prop="suffix">
                            <el-input v-model="syssno.suffix"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row type="flex" justify="end">
                    <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
                    <el-button @click="dialogFormVisible = false;">关闭</el-button>
                </el-row>
            </el-form>
        </el-dialog>

    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    name: 'syssno_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //当前页面字典
            dictCache: {},
            //对话框表单属性
            dialogFormVisible: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            syssno: null,
            //查询条件及分页参数
            snoReq: {
                pageSize: 10,
                pageNum:1
            },
        }
    },
    mounted(){
        tools.loadDict('1014,1015,1016', this.dictCache);
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Gurms.snoList(this.snoReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        formatFixedFlag:function(row){
            let dict = this.dictCache['1014'];
            let val = row.fixedflag;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode === val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        formatNoType:function(row){
            let dict = this.dictCache['1016'];
            let val = row.notype;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode === val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        formatCycleType:function(row){
            let dict = this.dictCache['1015'];
            let val = row.cycletype;
            for(var i = 0; i < dict.length; i++){
                if(dict[i].itemcode === val){
                    return val + " - " + dict[i].itemname;
                }
            }
            return val;
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.snoReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.snoReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
        handleEdit(index, row) {
            this.$api.Gurms.snoDetail(row.unioncode, row.noid).then(res =>{
                this.dialogFormVisible = true;
                this.syssno = res;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        onSubmit(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    this.$api.Gurms.snoUpdate(this.syssno).then((res)=>{
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
    }
}
</script>
