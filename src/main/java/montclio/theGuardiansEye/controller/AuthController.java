package montclio.theGuardiansEye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import montclio.theGuardiansEye.model.dto.Credentials;
import montclio.theGuardiansEye.model.dto.Token;
import montclio.theGuardiansEye.model.entity.UserEntity;
import montclio.theGuardiansEye.service.AuthService;
import montclio.theGuardiansEye.service.TokenService;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Endpoint para login e emissão de token JWT")
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

    @PostMapping("/login")
    @Operation(summary = "Login do usuário", description = "Valida as credenciais e retorna um token JWT de acesso.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Login bem-sucedido. Retorna token JWT."),
        @ApiResponse(responseCode = "401", description = "Credenciais inválidas ou usuário não encontrado.")
    })
    public Token login(
            @Parameter(description = "Objeto contendo email e senha do usuário", required = true)
            @RequestBody Credentials credentials) {
        UserEntity user = (UserEntity) authService.loadUserByUsername(credentials.email());

        if (!passwordEncoder.matches(credentials.password(), user.getPassword())) {
            throw new BadCredentialsException("Senha incorreta");
        }

        return tokenService.createToken(user);
    }

    @PostMapping("/register")
        @Operation(summary = "Registrar novo usuário", description = "Cria um novo usuário e retorna um token JWT.")
        @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "E-mail já cadastrado ou erro de validação.")
        })
        public Token register(
            @Parameter(description = "Dados do novo usuário", required = true)
            @RequestBody UserEntity user
        ) {
            return authService.register(user);
        }
}
