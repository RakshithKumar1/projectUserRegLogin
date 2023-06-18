package com.dxc.project.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dxc.project.model.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTTokenGeneratorService implements TokenGeneratorService  {
	
	@Value("${jwt.secret.key}") // to make available through out the application
	private String secretKey;

	@Override
	public Map<String, String> generateToken(User user) {
		String token = Jwts.builder().setSubject(user.getUserName())
		.setIssuer("userprofileIssuer")
		.claim("roles", user.getRole())
		.setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256, secretKey)
		.compact();
		return Map.of("token",token);
	}

}
