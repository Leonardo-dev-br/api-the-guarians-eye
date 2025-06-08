package montclio.theGuardiansEye.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import jakarta.annotation.PostConstruct;
import montclio.theGuardiansEye.model.dto.Token;
import montclio.theGuardiansEye.model.entity.UserEntity;
import montclio.theGuardiansEye.model.enums.UserRole;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    private Algorithm algorithm;
    private final Instant expiresAt = LocalDateTime
        .now()
        .plusMinutes(120)
        .toInstant(ZoneOffset.ofHours(-3));

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(jwtSecret);
    }

    public Token createToken(UserEntity user) {
        String jwt = JWT.create()
            .withSubject(user.getIdUser().toString())
            .withClaim("email", user.getUsername())
            .withClaim("role", user.getAuthRole().name())
            .withExpiresAt(expiresAt)
            .sign(algorithm);

        return new Token(jwt, "Bearer", user.getUsername());
    }

    public UserEntity getUserFromToken(String token) {
        DecodedJWT jwt = JWT.require(algorithm)
            .build()
            .verify(token);

        UserEntity user = new UserEntity();
        user.setEmail(jwt.getClaim("email").asString());
        user.setAuthRole(UserRole.valueOf(jwt.getClaim("role").asString()));
        return user;
    }
}
