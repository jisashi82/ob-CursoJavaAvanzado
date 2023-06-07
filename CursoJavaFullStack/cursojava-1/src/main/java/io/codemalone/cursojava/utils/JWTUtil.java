package io.codemalone.cursojava.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
import jakarta.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component 
public class JWTUtil {
	@Value("${security.jwt.secret}")
	private String key;

	@Value("${security.jwt.issuer}")
	private String issuer;

	@Value("${security.jwt.ttlMillis}")
	private long ttlMillis;
	
	
	//private final Logger log = LoggerFactory.getLogger(JWTUtil.class);

	/**
	 * Create a new token.
	 *
	 * @param id
	 * @param subject
	 * @return
	 */
	public String create(String id, String subject) {

		// The JWT signature algorithm used to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// sign JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		/*
		 * DEPRECATED JwtBuilder builder =
		 * Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(
		 * issuer).signWith(signingKey, signatureAlgorithm)
		 * .signWith(signatureAlgorithm, signingKey);
		 */

		// set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signingKey, signatureAlgorithm);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	/**
	 * Method to validate and read the JWT
	 *
	 * @param jwt
	 * @return
	 */
	public String getValue(String jwt) {
		/*
		 * DEPRECATED Claims claims =
		 * Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key)).
		 * parseClaimsJws(jwt) .getBody();
		 */

		// This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build()
				.parseClaimsJws(jwt).getBody();

		return claims.getSubject();
	}

	/**
	 * Method to validate and read the JWT
	 *
	 * @param jwt
	 * @return
	 */
	public String getKey(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build()
				.parseClaimsJws(jwt).getBody();

		return claims.getId();
	}
}