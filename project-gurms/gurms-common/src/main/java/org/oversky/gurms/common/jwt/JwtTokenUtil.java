package org.oversky.gurms.common.jwt;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {
	
	private static final String RAS_PASSWORD = "oversky";  //密钥库口令
	private static final String RAS_ALIAS = "jwt";          //密钥别名
    private static int expirationSeconds = 24 * 3600;    // 过期时间
    private static int type = 1;      // 1- keytool 生成的jks, 2- openssl生成的 pem

    private static PrivateKey PRIVATE_KEY = null;
    private static PublicKey PUBLIC_KET = null;

    public static String generateToken(String subject) {
    	long now = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(null)	//如果有私有声明，一定要先设置这个自己创建的私有的声明，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明
                .setId(String.valueOf(now)) 	//jti:(JWT ID)是JWT的唯一标识，可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击
                .setSubject(subject)			//sub:代表这个JWT的主体，可以是一个json格式的字符串
                .setIssuedAt(new Date(now))		//iat:jwt的签发时间
                .setExpiration(new Date(now + expirationSeconds * 1000))  // 过期时间
                .signWith(SignatureAlgorithm.RS256, getPrivateKey())
                .compact();
    }

    public static boolean verifyToken(String recvToken) {
    	Claims claims = getTokenBody(recvToken);
        String genToken = Jwts.builder()
                .setClaims(null)
                .setId(claims.getId()) 	
                .setSubject(claims.getSubject())	
                .setIssuedAt(claims.getIssuedAt())	
                .setExpiration(claims.getExpiration()) 
                .signWith(SignatureAlgorithm.RS256, getPrivateKey())
                .compact();
        
        return genToken.equals(recvToken);
    }

    public static String getSubject(String recvToken) {
        return getTokenBody(recvToken).getSubject();
    }
    
    // 是否已过期
    public static boolean isExpiration(String recvToken){
        return getTokenBody(recvToken).getExpiration().before(new Date(System.currentTimeMillis()));
    }    
    
    private static Claims getTokenBody(String token){
        return Jwts.parser().setSigningKey(getPublicKey()).parseClaimsJws(token).getBody();
    }

    private static PublicKey getPublicKey(){
    	if(PUBLIC_KET != null) {
    		return PUBLIC_KET;
    	}
    	
    	try {
    		if(type == 1) {
            	InputStream is = JwtTokenUtil.class.getClassLoader().getResourceAsStream("jwt.jks");
            	KeyStore keyStore = KeyStore.getInstance("JKS");
				keyStore.load(is, RAS_PASSWORD.toCharArray());
				PUBLIC_KET = keyStore.getCertificate(RAS_ALIAS).getPublicKey();
    		}else {
    			InputStream is = JwtTokenUtil.class.getClassLoader().getResourceAsStream("rsa_public_key.pem");
    			String keyString = IOUtils.toString(is).replaceAll("\\-*BEGIN.*KEY\\-*", "").replaceAll("\\-*END.*KEY\\-*", "");
    			byte[] bt = Base64.getDecoder().decode(keyString.replace("\r\n", ""));
    			X509EncodedKeySpec spec = new X509EncodedKeySpec(bt);
    			PUBLIC_KET = KeyFactory.getInstance("RSA").generatePublic(spec);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return PUBLIC_KET;
    }
 
    private static PrivateKey getPrivateKey(){
    	if(PRIVATE_KEY != null) {
    		return PRIVATE_KEY;
    	}
    	
    	try {
    		if(type == 1) {
            	InputStream is = JwtTokenUtil.class.getClassLoader().getResourceAsStream("jwt.jks");
            	KeyStore keyStore = KeyStore.getInstance("JKS");
				keyStore.load(is, RAS_PASSWORD.toCharArray());
				PRIVATE_KEY = (PrivateKey) keyStore.getKey(RAS_ALIAS, RAS_PASSWORD.toCharArray());
    		}else {
	    		InputStream is = JwtTokenUtil.class.getClassLoader().getResourceAsStream("pkcs8_rsa_private_key.pem");
	            String keyString = IOUtils.toString(is).replaceAll("\\-*BEGIN.*KEY\\-*", "").replaceAll("\\-*END.*KEY\\-*", "");
	            byte[] b1 = Base64.getDecoder().decode(keyString.replace("\r\n", ""));
	            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
	            PRIVATE_KEY = KeyFactory.getInstance("RSA").generatePrivate(spec);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}

    	return PRIVATE_KEY;
    }	
}



