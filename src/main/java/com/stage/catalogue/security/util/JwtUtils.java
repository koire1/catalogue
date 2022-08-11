package com.stage.catalogue.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.security.TokenType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 *
 * @author vincent
 */
@Component
public class JwtUtils {

    @Value("${catalogue.jwt_secret}")
    private String jwtSecret;

    @Value("${catalogue.issuer}")
    private String jwtIssuer;

    @Value("#{${catalogue.access_expiry}}")
    private long access_expiry;

    @Value("#{${catalogue.refresh_expiry}}")
    private long refresh_expiry;

    public String createAccessToken(String username, Role role) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + access_expiry))
                .withIssuer(jwtIssuer)
                .withClaim("role", role.toString())
                .withClaim("type", TokenType.ACCESS.toString())
                .sign(algorithm);
    }

    public String createRefreshToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + refresh_expiry))
                .withIssuer(jwtIssuer)
                .withClaim("type", TokenType.REFRESH.toString())
                .sign(algorithm);
    }

    public Map<String, String> getClaims(String token) throws Exception {
        Map<String, String> result = new HashMap<>();
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        String role = decodedJWT.getClaim("role").asString();
        String type = decodedJWT.getClaim("type").asString();
        result.put("username", username);
        result.put("role", role);
        result.put("type", type);
        return result;
    }

}
