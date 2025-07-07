package com.example.demo.service;

import com.example.demo.entity.User;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class jwtService {
    private String secretKey=null;




    public String generateToken(User user) {
        Map<String,Object> claims=new HashMap<>();
        return   Jwts
              .builder()
              .claims()
              .add(claims)
              .subject(user.getUsername())
              .issuer("MIM")
              .issuedAt(new Date(System.currentTimeMillis()))
              .expiration(new Date(System.currentTimeMillis()+ 60*20*1000))
              .and()
              .signWith(generateKey())
              .compact();
              

    }
    private SecretKey generateKey(){
        byte[] decode = Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decode);
    }
    public String getSecretKey() {
        return secretKey="f9f1171cee35f3db32b509fc3b4b3ef9f812bc2d693311ce33d6b4e2e84fc817ffd63ca037b7718150630e8ce3202393b";
    }
}
