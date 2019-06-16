<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="8">
                <div class="card kjfs">
                    <p class="title"><i class="fa fa-th-large fa-lg"></i>快捷方式</p>
                    <ul>
                        <li>
                            <router-link to="#" class="kjfs kjfs-bluee"><span><i class="el-icon-tickets fa-2x"></i></span><span>快捷1</span></router-link>
                        </li>
                        <li>
                            <router-link to="#" class="kjfs kjfs-pinkk"><span><i class="fa fa-hand-stop-o fa-2x"></i></span><span>快捷2</span></router-link>
                        </li>
                        <li>
                            <router-link to="#" class="kjfs kjfs-yelloww"><span><i class="fa fa-universal-access fa-2x"></i></span><span>快捷3</span></router-link>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <router-link to="#" class="kjfs kjfs-grennn"><span><i class="fa fa-cloud-upload fa-2x"></i></span><span>快捷4</span></router-link>
                        </li>
                        <li>
                            <router-link to="#" class="kjfs kjfs-purplee"><span><i class="fa el-icon-menu fa-2x"></i></span><span>快捷5</span></router-link>
                        </li>
                        <li>
                            <router-link to="#" class="kjfs kjfs-lightBluee"><span><i class="fa fa-file-code-o fa-2x"></i></span><span>快捷6</span></router-link>
                        </li>
                    </ul>
                </div>
            </el-col>
            <el-col :span="8">
                <div class="card dbsx">
                    <p class="title"><i class="fa fa-file-text-o"></i>待办事项</p>
                    <ul>
                        <li>
                            <router-link to="#"><span>待审评论</span><span class="num">66</span></router-link>
                        </li>
                        <li>
                            <router-link to="#"><span>待审帖子</span><span class="num">66</span></router-link>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <router-link to="#"><span>待审商品</span><span class="num">66</span></router-link>
                        </li>
                        <li>
                            <router-link to="#"><span>代发货</span><span class="num">66</span></router-link>
                        </li>
                    </ul>
                </div>
            </el-col>
            <el-col :span="8">
                <div class="card bbxx">
                    <p class="title"><i class="fa fa-server"></i>版本信息</p>
                    <div class="table">
                        <p><span class="tit">当前版本</span>v1.0.0</p>
                        <p><span class="tit">基于框架</span>vue2.0全家桶 + element-ui</p>
                        <p><span class="tit">主要特色</span>单页面 / 响应式 / 无限级菜单 / 权限管理 / 极简</p>
                        <p><span class="tit">获取渠道</span>
                            <span class="gitbox">
                  <a target="_blank" href="https://github.com/Nirongxu/vue-xuAdmin.git"><el-button type="primary" icon="el-icon-download" size="small">github</el-button></a>
                  <a target="_blank" href="https://gitee.com/nirongxu/xu-webplatform.git"><el-button type="primary" icon="el-icon-download" size="small">码云</el-button></a>
                </span>
                        </p>
                    </div>
                </div>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="24">
                <line-echarts id="lineEcharts" height="300px" ref="echarts"></line-echarts>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="24">
                <div id="maintable">
                  <p class="title"><i class="el-icon-tickets"></i>最新10条等待处理订单</p>
                  <el-table
                    border
                    :data="tableData"
                    style="width: 100%">
                    <el-table-column
                      type="index">
                    </el-table-column>
                    <el-table-column
                      sortable
                      prop="odd"
                      label="订单号">
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      label="收货人">
                    </el-table-column>
                    <el-table-column
                      prop="status"
                      label="订单状态"
                      width="130">
                    </el-table-column>
                    <el-table-column
                      prop="amount"
                      label="金额">
                    </el-table-column>
                    <el-table-column
                      prop="date"
                      label="下单时间"
                      sortable
                      :filters="[{text: '2018-01-01', value: '2018-01-01'}, {text: '2018-01-02', value: '2018-01-02'}, {text: '2018-01-03', value: '2018-01-03'}, {text: '2018-01-04', value: '2018-01-04'}, {text: '2018-01-05', value: '2018-01-05'}]"
                      :filter-method="filterHandler"
                    >
                    </el-table-column>
                    <el-table-column
                      prop="tag"
                      label="订单分类"
                      width="150"
                      :filters="[{ text: '虚拟', value: '虚拟' }, { text: '实物', value: '实物' }]"
                      :filter-method="filterTag"
                      filter-placement="bottom-end">
                      <template slot-scope="scope">
                        <el-tag
                          :type="scope.row.tag === '虚拟' ? 'primary' : 'success'"
                          disable-transitions>{{scope.row.tag}}</el-tag>
                      </template>
                    </el-table-column>
                    <el-table-column label="操作">
                      <template slot-scope="scope">
                        <el-button
                          size="mini"
                          @click="handleEdit(scope.$index, scope.row)">详情</el-button>
                        <el-button
                          size="mini"
                          type="danger"
                          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </div>
            </el-col>
        </el-row>
    </div>
</template>
<script>
import LineEcharts from '@/components/echarts/lineEcharts';

export default {
    name: 'about',
    components: {LineEcharts },
    mounted() {
        this.selfAdaption();
    },
    methods: {
        // echart自适应
        selfAdaption() {
            let that = this;
            setTimeout(() => {
                window.onresize = function() {
                    if (that.$refs.echarts) {
                        that.$refs.echarts.chart.resize();
                    }
                }
            }, 10);
        },
        handleEdit (index, row) {
            console.log(index, row);
            this.$message({
                showClose: true,
                message: index, row,
                type: 'success'
            });
        },
        handleDelete (index, row) {
            console.log(index, row);
            this.$message({
                showClose: true,
                message: index, row,
                type: 'success'
            });
        },
        filterTag (value, row) {
            return row.tag === value;
        },
        filterHandler (value, row, column) {
            const property = column['property'];
            return row[property] === value;
        }
    },
    data () {
      return {
        tableData: [{
          odd: '201801012345601',
          name: '王小虎',
          status: '已付款',
          amount: '580元',
          date: '2018-01-01',
          tag: '虚拟'
        }, {
          odd: '201801012345602',
          name: '王小虎',
          status: '已付款',
          amount: '130元',
          date: '2018-01-02',
          tag: '实物'
        }, {
          odd: '201801012345603',
          name: '王小虎',
          status: '已付款',
          amount: '680元',
          date: '2018-01-03',
          tag: '虚拟'
        }, {
          odd: '201801012345604',
          name: '王小虎',
          status: '已付款',
          amount: '190元',
          date: '2018-01-03',
          tag: '虚拟'
        }, {
          odd: '201801012345605',
          name: '王小虎',
          status: '已付款',
          amount: '170元',
          date: '2018-01-04',
          tag: '实物'
        }, {
          odd: '201801012345606',
          name: '王小虎',
          status: '已付款',
          amount: '670元',
          date: '2018-01-04',
          tag: '虚拟'
        }, {
          odd: '201801012345607',
          name: '王小虎',
          status: '已付款',
          amount: '1780元',
          date: '2018-01-04',
          tag: '实物'
        }, {
          odd: '201801012345608',
          name: '王小虎',
          status: '已付款',
          amount: '3180元',
          date: '2018-01-04',
          tag: '虚拟'
        }, {
          odd: '201801012345609',
          name: '王小虎',
          status: '已付款',
          amount: '780元',
          date: '2018-01-05',
          tag: '实物'
        }, {
          odd: '201801012345610',
          name: '王小虎',
          status: '已付款',
          amount: '2130元',
          date: '2018-01-05',
          tag: '虚拟'
        }]
      };
    }
}
</script>
<style lang="scss">
$top:top;
$bottom:bottom;
$left:left;
$right:right;
$leftright: ($left, $right);
$pinkk: #eec2d3;
$bluee: #409eff;
$yelloww: #f4d884;
$grennn: #89dda0;
$purplee: #78a2ea;
$lightBluee: #b8d6ff;

$list: bluee pinkk yelloww grennn purplee lightBluee;
$list1: $bluee $pinkk $yelloww $grennn $purplee $lightBluee;

%shadow {
    background: #fff;
    -webkit-box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.2);
    box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.2);
    border-color: rgba(0, 0, 0, 0.2);

    .title {
        font-size: 14px;
        padding: 10px;

        i {
            margin-#{$right}: 5px;
        }
    }
}

@mixin flex($direction:row, $content:space-between) {
    display: flex;
    flex-direction: $direction;
    justify-content: $content;
}

.card {
    color: #666;
    @extend %shadow;

    ul {
        @include flex;

        li {
            flex: 1;

            a {
                color: #666666;
                align-items: center;
                padding-#{$top}: 20px;
                padding-#{$bottom}: 20px;
                @include flex(column);

                span {
                    height: 44px;
                }

                .num {
                    line-height: 44px;
                    font-size: 42px;
                    color: $bluee;
                    margin: 0px;
                }
            }

            .kjfs-bluee {
                color: $bluee;
            }

            .kjfs-pinkk {
                color: $pinkk;
            }

            .kjfs-yelloww {
                color: $yelloww;
            }

            .kjfs-grennn {
                color: $grennn;
            }

            .kjfs-purplee {
                color: $purplee;
            }

            .kjfs-lightBluee {
                color: $lightBluee;
            }

            &:hover {
                .kjfs-bluee {
                    color: #ffffff;
                    background: $bluee;
                }

                .kjfs-pinkk {
                    color: #ffffff;
                    background: $pinkk;
                }

                .kjfs-yelloww {
                    color: #ffffff;
                    background: $yelloww;
                }

                .kjfs-grennn {
                    color: #ffffff;
                    background: $grennn;
                }

                .kjfs-purplee {
                    color: #ffffff;
                    background: $purplee;
                }

                .kjfs-lightBluee {
                    color: #ffffff;
                    background: $lightBluee;
                }
            }
        }
    }

    .table {
        padding: 21px;

        p {
            height: 52px;
            line-height: 52px;
            border: 1px solid #cccccc;
            overflow: hidden;
            border-#{$top}: none;
            @include flex(null, start);

            &:first-child {
                border-#{$top}: 1px solid #cccccc;
            }

            span {}

            .tit {
                width: 90px;
                min-width: 90px;
                height: 100%;
                text-align: center;
                border-#{$right}: 1px solid #cccccc;
                margin-#{$right}: 18px;
            }

            span.gitbox {
                flex: 1;
                height: 100%;
                overflow: hidden;
                @include flex(row, start);

                a {
                    &:first-child {
                        margin-#{$right}: 30px;
                    }
                }
            }
        }
    }
}

#lineEcharts {
    margin-#{$top}: 30px;
    padding-#{$top}: 30px;
    @extend %shadow;
}

#maintable {
    margin-#{$top}: 30px;
    padding-#{$top}: 10px;
    @extend %shadow;
}
</style>
