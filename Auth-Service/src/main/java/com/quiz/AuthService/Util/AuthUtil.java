package com.quiz.AuthService.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthUtil {

    public static final String SECRET = "21832802cf95c924fb724fe40c96ec8f00fd88b325cd0f6a820b098c973a22f9";

    public void validateToken(final String token){
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 *60 ))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keys = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keys);
    }
}
