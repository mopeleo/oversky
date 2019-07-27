<template>
    <div class="app-container">
        <!-- 左侧树 -->
        <div class="left">
            <div class="" style="padding-bottom: 10px;">
                <el-row :gutter="10" type="flex">
                    <el-col :span="12">
                        <el-input clearable style="width:200px" placeholder="输入关键字进行过滤" v-model="filterText"></el-input>
                    </el-col>
                </el-row>
            </div>
            <el-tree ref="leftMenuTree" :data="treeData" node-key="menuid" :expand-on-click-node="false"
                @node-click="leftTreeHandleNodeClick" :highlight-current="true"
                :filter-node-method="filterNode" :props="{children: 'subMenus',label: 'menuname'}">
            </el-tree>
        </div>
        <div class="right">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span class="title">菜单信息</span>
                </div>
                <div class="text item">
                    <el-form ref="detailForm" :model="sysmenu" :rules="rules" label-width="120px" :disabled="editType === this.$pubdefine.EDIT_TYPE_DETAIL">
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="菜单编号" prop="menuid">
                                    {{sysmenu.menuid}}
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="菜单名称" prop="menuname">
                                    <el-input v-model="sysmenu.menuname"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="上级菜单" prop="parentmenu">
                                    <el-input v-model="sysmenu.parentmenu"></el-input>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="菜单类型" prop="menutype">
                                    <el-select v-model="sysmenu.menutype" value-key="itemcode" placeholder="请选择">
                                        <el-option v-for="item in dictCache['2010']" :key="item.itemcode" :label="item.itemcode + ' - ' + item.itemname" :value="item.itemcode">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="10">
                                <el-form-item label="菜单状态" prop="status">
                                    <el-select v-model="sysmenu.status" value-key="itemcode" placeholder="请选择">
                                        <el-option v-for="item in dictCache['1003']" :key="item.itemcode" :label="item.itemcode + ' - ' + item.itemname" :value="item.itemcode">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                            <el-col :span="10">
                                <el-form-item label="访问控制" prop="accesstype">
                                    <el-select v-model="sysmenu.accesstype" value-key="itemcode" placeholder="请选择">
                                        <el-option v-for="item in dictCache['2011']" :key="item.itemcode" :label="item.itemcode + ' - ' + item.itemname" :value="item.itemcode">
                                        </el-option>
                                    </el-select>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="15">
                                <el-form-item label="菜单URL" prop="menuurl">
                                    <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" v-model="sysmenu.menuurl">
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row :gutter="20">
                            <el-col :span="15">
                                <el-form-item label="菜单样式" prop="menucss">
                                    <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" v-model="sysmenu.menucss">
                                    </el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                </div>
            </el-card>
        </div>
    </div>
</template>
<script>
import * as tools from '@/utils/tools';

export default {
    name: 'sysmenu_list',
    data() {
        return {
            //表格当前页数据
            treeData: [],
            //当前页面字典
            dictCache: {},
            //过滤条件:
            filterText: '',
            //查询条件及分页参数
            menuReq: {
                pageNum: 1
            },
            //对话框表单属性
            editType: this.$pubdefine.EDIT_TYPE_DETAIL, // insert/update
            //临时业务数据
            sysmenu: {}
        }
    },
    mounted() {
        tools.loadDict('1003,2010,2011', this.dictCache);
        this.loadMenuTree();
    },
    watch: {
        filterText(val) {
            this.$refs.leftMenuTree.filter(val);
        }
    },
    methods: {
        loadMenuTree: function() {
            this.$api.Gurms.menuTree(this.menuReq).then((res) => {
                this.treeData = [];
                this.treeData = res.subMenus;
            }).catch((err) => {
                tools.errTip(err);
            });
        },
        filterNode(value, data) {
            if (!value) return true;
            return data.menuname.indexOf(value) !== -1;
        },
        initMenuInfo() {
            this.sysmenu = {
                menuid: '',
                menuname: '',
                status: '',
                parentmenu: '',
                accesstype: '',
                menutype: '',
                menuurl: '',
                menucss: ''
            };
        },
        leftTreeHandleNodeClick(data){
            if(data.menuid !== this.sysmenu.menuid){
                this.sysmenu = data;
            }
        },
        handleAdd() {
            this.initMenuInfo();
            this.editType = this.$pubdefine.EDIT_TYPE_INSERT;
        },
        handleEdit(data) {
            this.sysmenu = data;
            this.editType = this.$pubdefine.EDIT_TYPE_UPDATE;
        },
        onCancel() {
            this.editType = this.$pubdefine.EDIT_TYPE_DETAIL;
        }
    }
}
</script>
<style scoped lang="scss">
.custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
}

.title {
    font-size: 16px;
    color: red;
}

.left {
    width: 400px;
}

.right {
    margin-left: 410px;
    height: 100%;
    overflow: auto;
}
</style>
