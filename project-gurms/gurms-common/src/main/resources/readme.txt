使用jdk自带的keytool工具:
keytool -genkey -alias jwt -keyalg  RSA -keysize 1024 -validity 365 -keystore jwt.jks
使用keytool生成密钥，别名为jwt，算法为RSA，有效期为365天，文件名为jwt.jks,文件保存在当前打开cmd的路径下
它提示输入密码,输入oversky,接下的输入可以忽略,回车pass