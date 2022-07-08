package com.cts.eaution.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cts.eaution.service.SecurityTokenGenerator;
import com.cts.eaution.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator{

	@Override
	public Map<String, String> generateToken(UserVO user) {
		// TODO Auto-generated method stub
		//user.setPassword(null);
		Claims claims = Jwts.claims().setSubject(user.getEmail());
		if(user.getRole().toString().equalsIgnoreCase("BUYER")) {
			claims.put("scopes", "BUYER");
			}else {
				claims.put("scopes", "SELLER");
			}
			
			String jwtToken = "";
			jwtToken= Jwts.builder().setSubject(user.getEmail()).claim("roles", claims).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			Map<String,String> map = new HashMap<>();
			map.put("token", jwtToken);
			map.put("message", "User successfully logged in ");
			return map;
	}

}
