const path = require('path');

module.exports = {
    // 基本路径
    publicPath: '/',
    // 输出文件目录
    outputDir: 'dist',
	assetsDir: 'static', // 静态资源目录 (js, css, img, fonts)
    lintOnSave: true,// 是否开启eslint保存检测，有效值：ture | false | 'error'
    // webpack配置
    // see https://github.com/vuejs/vue-cli/blob/dev/docs/webpack.md
    chainWebpack: () => {},
    configureWebpack: (config) => {
        if (process.env.NODE_ENV === 'production') {
            // 为生产环境修改配置...
            config.mode = 'production';
        } else {
            // 为开发环境修改配置...
            config.mode = 'development';
        }

        Object.assign(config, {
            // 开发生产共同配置
            resolve: {
                alias: {
                    '@': path.resolve(__dirname, './src')
                }
            }
        });
    },
    // 生产环境是否生成 sourceMap 文件
    productionSourceMap: true,
    // css相关配置
    css: {
        // 是否使用css分离插件 ExtractTextPlugin
        extract: true,
        // 开启 CSS source maps?
        sourceMap: false,
        // css预设器配置项
        loaderOptions: {},
        // 启用 CSS modules for all css / pre-processor files.
        modules: false
    },
    // use thread-loader for babel & TS in production build
    // enabled by default if the machine has more than 1 cores
    parallel: require('os').cpus().length > 1,
    // PWA 插件相关配置
    // see https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-pwa
    pwa: {},
    // webpack-dev-server 相关配置
    devServer: {
		//运行程序所在的平台系统 'darwin', 'freebsd', 'linux', 'sunos' or 'win32'
        open: process.platform === 'win32',
        host: 'localhost',
        port: 8088,
        https: false,
        hotOnly: false,
        proxy: {
            // 设置代理
            '/gurms': {
                target: 'http://localhost:8080/', //真实请求的目标地址
                changeOrigin: true,          //是否跨域
                pathRewrite: {
                    '^/gurms': ''           //如果接口本身没有/gurms需要通过pathRewrite来重写了地址
                }
            }
        },
        before: (app) => {}
    },
    // 第三方插件配置
    pluginOptions: {
        // ...
    }
};