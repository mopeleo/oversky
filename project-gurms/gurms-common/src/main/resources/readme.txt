使用jdk自带的keytool工具:
keytool -genkey -alias jwt -keyalg  RSA -keysize 1024 -validity 365 -keystore jwt.jks
使用keytool生成密钥，别名为jwt，算法为RSA，有效期为365天，文件名为jwt.jks,文件保存在当前打开cmd的路径下
它提示输入密码,输入oversky,接下的输入可以忽略,回车pass


使用openssl方式
生成加密长度1024位密钥

。密钥可分为1024，2048，4096等位密钥，位数不同，可加解密明文长度不一。
 比如1024位密钥： 可加解密明文长度 len = 1024/8 - 11 = 117字节

生成私钥：openssl genrsa -out rsa_private_key.pem 1024


生成公钥：openssl rsa -in rsa_private_key.pem -out rsa_public_key.pem -pubout


最终使用的RSA文件是需要经过PKCS#8编码的,之前生成的RSA文件只是用来生成公钥文件的
接下来就要对之前的私钥文件进行PKCS#8编码，生成一个编码后的私钥文件

转换格式：openssl pkcs8 -topk8 -in rsa_private_key.pem -out pkcs8_rsa_private_key.pem -nocrypt
