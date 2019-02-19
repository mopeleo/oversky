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
	'no-irregular-whitespace': 0,//关闭 不能有不规则的空格
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off'
	
  },
  parserOptions: {
    parser: 'babel-eslint'
  }
}
