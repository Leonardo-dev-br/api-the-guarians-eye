package montclio.theGuardiansEye.model.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import montclio.theGuardiansEye.model.enums.UserRole;

@Entity
@Table(name = "tb_tge_usuario")
public class UserEntity implements UserDetails {

    @Id
    @SequenceGenerator(name = "tb_tge_usuario_seq", sequenceName = "tb_tge_usuario_id_usuario_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_tge_usuario_seq")
    @Column(name = "id_usuario")
    private Long idUser;

    @Column(name = "nome_usuario", nullable = false, length = 35)
    private String firstName;

    @Column(name = "sobrenome", nullable = false, length = 100)
    private String lastName;

    @Column(name = "cpf", nullable = false)
    private Long cpf;

    @Column(name = "cargo", nullable = false, length = 50)
    private String position;

    @Column(name = "funcao", nullable = false, length = 100)
    private String function;

    @Column(name = "email", nullable = false, length = 125, unique = true)
    @Email
    private String email;

    @Column(name = "senha", nullable = false, length = 60)
    private String password;

    @Column(name = "papel", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserRole authRole;


    public Long getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getAuthRole() {
        return authRole;
    }

    public void setAuthRole(UserRole authRole) {
        this.authRole = authRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + authRole.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
