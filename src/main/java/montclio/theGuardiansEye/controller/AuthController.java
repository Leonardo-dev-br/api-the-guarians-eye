package montclio.theGuardiansEye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import montclio.theGuardiansEye.model.dto.Credentials;
import montclio.theGuardiansEye.model.dto.Token;
import montclio.theGuardiansEye.model.entity.UserEntity;
import montclio.theGuardiansEye.service.AuthService;
import montclio.theGuardiansEye.service.TokenService;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final TokenService tokenService;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(TokenService tokenService,
                          AuthService authService,
                          PasswordEncoder passwordEncoder) {
        this.tokenService = tokenService;
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public Token login(@RequestBody Credentials credentials) {
        UserEntity user = (UserEntity) authService.loadUserByUsername(credentials.email());

        if (!passwordEncoder.matches(credentials.password(), user.getPassword())) {
            throw new BadCredentialsException("Senha incorreta");
        }

        return tokenService.createToken(user);
    }
}
