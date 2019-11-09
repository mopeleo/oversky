/**
  * api接口的统一出口
  */
// gurms模块接口
import Gurms from './api.gurms';
import Game from './api.game';
// 其他模块的接口……

// 导出接口
export default {
    Game,
    Gurms
}
