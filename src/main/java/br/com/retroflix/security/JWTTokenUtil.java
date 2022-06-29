package br.com.retroflix.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.retroflix.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTTokenUtil {
	
	private static final String SECRET_KEY = "r3tr0fl1xSu@Loj@D3F1lm3s4nt1g0s!";
	
	private static final String EMISSOR = "*Retroflix*";
	private static final Integer SEGUNDO = 1000;
	private static final Integer MINUTO = SEGUNDO * 60;
	private static final Integer HORA = MINUTO * 60;
	private static final Integer EXPIRATION = HORA * 2;
	private static final String TK_PREFIX = "Bearer ";
	private static final String HEADER_AUTH = "Authorization";
	
	
	public static String generateToken(Usuario usuario) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
		String jwt = Jwts.builder()
						 .setSubject(usuario.getUsername())
						 //.setAudience(usuario.getNivelAcesso())
						 .setIssuer(EMISSOR)
						 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
						 .signWith(secretKey, SignatureAlgorithm.HS256)
						 .compact();
		//System.out.println("####### TOKEN GERADO = " + jwt + " #########");
		return TK_PREFIX + jwt;
	}
	
	  public static boolean isIssuerValid(String issuer) { 
		  return EMISSOR.equals(issuer);
	  }
	  
	  public static boolean isSubjectValid(String subject) {
		  return (subject != null && subject.length() > 0);
	  }
	  
	  public static boolean isExpirationValid(Date expiration) {
		  return expiration.after(new Date(System.currentTimeMillis()));
	  }
	  
	  public static String getUserFromToken(String token) {
		  token = token.replace(TK_PREFIX, "");
		  Jws<Claims> jwsClaims = Jwts.parserBuilder()
				  					  .setSigningKey(SECRET_KEY.getBytes())
				  					  .build()
				  					  .parseClaimsJws(token);
		  String username = jwsClaims.getBody().getSubject();
		  return username;
	  }
	  
	  public static String getNivelAcessoFromToken(String token) {
		  token = token.replace(TK_PREFIX, "");
		  Jws<Claims> jwsClaims = Jwts.parserBuilder()
				  					  .setSigningKey(SECRET_KEY.getBytes())
				  					  .build()
				  					  .parseClaimsJws(token);
		  String nivelAcesso = jwsClaims.getBody().getAudience();
		  return nivelAcesso;
	  }
	  
	  public static Authentication decodeToken(HttpServletRequest request) {
		  String token = request.getHeader(HEADER_AUTH); token = token.replace(TK_PREFIX, "");
	  
		  Jws<Claims> jwsClaims = Jwts.parserBuilder()
				  					  .setSigningKey(SECRET_KEY.getBytes())
				  					  .build()
				  					  .parseClaimsJws(token);
	     
		 String 	username 	= 	jwsClaims.getBody().getSubject();
	     String 	emissor 	=  	jwsClaims.getBody().getIssuer();
	     Date 		expira 		=   jwsClaims.getBody().getExpiration();
	  
	     if(isSubjectValid(username) && isIssuerValid(emissor) && isExpirationValid(expira)) { 
	    	 return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
	  	 }
	     	return null;
	 }
	 
}
