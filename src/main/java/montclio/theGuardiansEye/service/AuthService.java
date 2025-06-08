package montclio.theGuardiansEye.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import montclio.theGuardiansEye.model.dto.Credentials;
import montclio.theGuardiansEye.model.dto.Token;
import montclio.theGuardiansEye.model.entity.UserEntity;
import montclio.theGuardiansEye.model.repository.UserRepository;


@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final ObjectProvider<AuthenticationManager> authenticationManagerProvider;


    @Autowired
    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            TokenService tokenService,
            ObjectProvider<AuthenticationManager> authenticationManagerProvider
        ) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.tokenService = tokenService;
            this.authenticationManagerProvider = authenticationManagerProvider;
        }

    public Token register(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity savedUser = userRepository.save(user);
        return tokenService.createToken(savedUser);
    }

    public Token authenticate(Credentials credentials) {
        authenticationManagerProvider.getObject().authenticate(
            new UsernamePasswordAuthenticationToken(credentials.email(), credentials.password())
        );
        UserEntity user = userRepository.findByEmail(credentials.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return tokenService.createToken(user);
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
