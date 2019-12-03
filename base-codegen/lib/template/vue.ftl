<template>
    <div>
        <el-form ref="listForm" :model="queryReq" label-width="70px">
            <el-row :gutter="10" type="flex">
                <el-col :span="5">
                    <el-form-item label="角色名称">
                        <el-input v-model="queryReq.rolename" placeholder="角色名称"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="5">
                    <el-form-item label="角色状态">
                        <el-select v-model="queryReq.status" value-key="itemcode" clearable placeholder="请选择">
                            <el-option v-for="item in dictCache['1003']"
                                :key="item.itemcode"
                                :label="item.itemcode + ' - ' + item.itemname"
                                :value="item.itemcode">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="4">
                    <el-form-item>
                        <el-button type="primary" icon="el-icon-search" @click="loadData">查询</el-button>
                        <el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增</el-button>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-table border stripe :data="tableData.results" :highlight-current-row="true" style="width:100%">
                <el-table-column type="index" width="50"></el-table-column>
			<#list table.columns as column>
                <el-table-column prop="${column.code}" label="${column.comment}"></el-table-column>
			</#list>	
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
                    :current-page="queryReq.pageNum"
                    :page-sizes="this.$pubdefine.PAGE_SIZES"
                    :page-size="queryReq.pageSize"
                    :total="tableData.page ? tableData.page.total : 0">
                </el-pagination>
            </div>
        </el-form>

			<#assign x=table.columns?size/2 />
			<#assign y=table.columns?size%2 />
			<#if y != 0 >
				<#assign x=x+1 />
			</#if>

<#if table.columns?size lte 20>
		<el-dialog title="详细信息" v-if="dialogFormVisible" :visible.sync="dialogFormVisible" :close-on-click-modal="false">
            <el-form ref="detailForm" :model="${table.code?lower_case}" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
			<#list 0..x-1 as i>
                <el-row :gutter="20">
                    <el-col :span="10">
                        <el-form-item label="${table.columns[2*i].comment}" prop="${table.columns[2*i].code}">
                            <el-input v-model="${table.code?lower_case}.${table.columns[2*i].code}"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
						<#if (2*i + 1) != table.columns?size>
                        <el-form-item label="${table.columns[2*i + 1].comment}" prop="${table.columns[2*i + 1].code}">
                            <el-input v-model="${table.code?lower_case}.${table.columns[2*i + 1].code}"></el-input>
                        </el-form-item>
						</#if>
                    </el-col>
                </el-row>
			</#list>	
                <el-row type="flex" justify="end">
                    <el-button type="primary" @click="onSubmit('detailForm')">保存</el-button>
                    <el-button @click="dialogFormVisible = false;">关闭</el-button>
                </el-row>
            </el-form>
        </el-dialog>
<#else>
		<el-drawer ref="drawer" title="详细信息" custom-class="demo-drawer" size="40%" wrapperClosable="false" :visible.sync="dialogFormVisible">
            <div class="demo-drawer__content">
                <el-form ref="drawerForm" :model="${table.code?lower_case}" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
				<#list 0..x-1 as i>
					<el-row :gutter="20">
						<el-col :span="10">
							<el-form-item label="${table.columns[2*i].comment}" prop="${table.columns[2*i].code}">
								<el-input v-model="${table.code?lower_case}.${table.columns[2*i].code}"></el-input>
							</el-form-item>
						</el-col>
						<el-col :span="10">
							<#if (2*i + 1) != table.columns?size>
							<el-form-item label="${table.columns[2*i + 1].comment}" prop="${table.columns[2*i + 1].code}">
								<el-input v-model="${table.code?lower_case}.${table.columns[2*i + 1].code}"></el-input>
							</el-form-item>
							</#if>
						</el-col>
					</el-row>
				</#list>	
                </el-form>
                <div class="demo-drawer__footer">
                    <el-row type="flex" justify="center" v-if="editType !== this.$pubdefine.EDIT_TYPE_DETAIL">
                        <el-button type="primary" @click="onSubmit('drawerForm')">保存</el-button>
                        <el-button type="primary" @click="dialogFormVisible = false;">关闭</el-button>
                    </el-row>
                </div>
            </div>
        </el-drawer>
</#if>
		
    </div>
</template>

<script>
import * as tools from '@/utils/tools'

export default{
    name: '${table.code?lower_case}_list',
    data(){
        return {
            //表格当前页数据
            tableData: {},
            //当前页面字典
            dictCache: {},
            //查询条件及分页参数
            queryReq: {
                pageSize: this.$pubdefine.PAGE_SIZE,
                pageNum:1
            },
            //对话框表单属性
            dialogFormVisible: false,
            editType: this.$pubdefine.EDIT_TYPE_INSERT,   // insert/update
            //临时业务数据
            ${table.code?lower_case}: null,
            //验证规则
            rules: {
            }
        }
    },
    mounted(){
        tools.loadDict('1003', this.dictCache);
        this.loadData();
    },
    methods:{
        loadData:function(){
            this.$api.Gurms.${table.code}List(this.queryReq).then((res)=>{
                this.tableData = res;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        //每页显示数据量变更
        handleSizeChange:function(val){
            this.queryReq.pageSize = val;
            this.$options.methods.loadData.bind(this)();
        },
        //页码变更
        handleCurrentChange: function(val) {
            this.queryReq.pageNum = val;
            this.$options.methods.loadData.bind(this)();
        },
        handleAdd() {
            this.dialogFormVisible = true;
            this.${table.code?lower_case} = {
		<#list table.columns as column>
				${column.code}: ''<#if column_has_next>, </#if>
		</#list>
            };
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
        },
        handleDetail(index, row) {
            this.$api.Gurms.${table.code}Detail(<#list table.keys as column>row.${column.code}<#if column_has_next>, </#if></#list>).then(res =>{
                this.dialogFormVisible = true;
                this.${table.code?lower_case} = res;
                this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleEdit(index, row) {
            this.$api.Gurms.${table.code}Detail(<#list table.keys as column>row.${column.code}<#if column_has_next>, </#if></#list>).then(res =>{
                this.dialogFormVisible = true;
                this.${table.code?lower_case} = res;
                this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
            }).catch((err)=>{
                tools.errTip(err);
            });
        },
        handleDelete(index, row) {
            tools.confirmTip("是否确定删除?", () => {
                this.$api.Gurms.${table.code}Delete(row.roleid).then((res)=>{
                    if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
                        tools.succTip('删除成功');
                        this.$options.methods.loadData.bind(this)();
                    }else{
                        tools.errTip('删除失败');
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
                        callAPI = this.$api.Gurms.${table.code}Update(this.${table.code?lower_case});
                    }else if(this.editType === this.$pubdefine.EDIT_TYPE_INSERT){
                        callAPI = this.$api.Gurms.${table.code}Add(this.${table.code?lower_case});
                    }
                    callAPI.then((res)=>{
                        tools.succTip(res.returnmsg);
                        if(res.returncode === this.$pubdefine.RETURN_CODE_SUCCESS){
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
