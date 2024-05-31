package com.spring.security.jwt.two.serivice;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${app.jwt.secret.key}")
    private String secretKey;

    @Value("${app.jwt.expiration-time}")
    private Long jwtExpirationTimeInMillis;

    public String generateToken(UserDetails userDetails){

    	Map<String, Object> claims = new HashMap<>();
    	
    	List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    	claims.put("roles", roles);
    	
    	return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date())
    			.setExpiration(new Date(System.currentTimeMillis()+jwtExpirationTimeInMillis))
    			.signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

	private Key getSigningKey() {
		byte[] decode = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(decode);
	}
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims :: getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
				.parseClaimsJws(token).getBody();
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		String username  =  extractUsername(token);
		return (userDetails.getUsername().equals(username) && !isTokenExpired(token));
		
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims :: getExpiration);
	}

}
