module.exports = {
  root: true,
  env: {
    node: true
  },
  'extends': [
    'plugin:vue/essential',
    'eslint:recommended'
  ],
  rules: {
    // 使用4个空格缩进 https://cn.eslint.org/docs/rules/indent
    //"indent": [ "error", 4 ],
    // 使用Unix换行符
    //"linebreak-style": [ "error", "unix" ],
    // 要求使用分号 https://cn.eslint.org/docs/rules/semi
    //"semi": [ "error", "always" ],

	'no-irregular-whitespace': 0,//关闭 不能有不规则的空格
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off'
	
  },
  parserOptions: {
    parser: 'babel-eslint'
  }
}
