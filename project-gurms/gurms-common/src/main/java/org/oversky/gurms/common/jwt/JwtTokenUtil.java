package org.oversky.gurms.common.jwt;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {
	public static final String RAS_PASSWORD = "oversky";  //密钥库口令
	public static final String RAS_ALIAS = "jwt";          //密钥别名
	//加载jwt.jks文件
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks");
    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;

    static {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, RAS_PASSWORD.toCharArray());
            privateKey = (PrivateKey) keyStore.getKey(RAS_ALIAS, RAS_PASSWORD.toCharArray());
            publicKey = keyStore.getCertificate(RAS_ALIAS).getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateToken(String id, int expirationSeconds) {
        return Jwts.builder()
                .setClaims(null)
                .setSubject(id)
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    public static String parseToken(String token) {
        Claims claims = getTokenBody(token);
        return claims.getSubject();
    }
    
    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }
    
    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();
    }

}



