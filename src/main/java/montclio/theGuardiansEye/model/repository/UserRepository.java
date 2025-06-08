package montclio.theGuardiansEye.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import montclio.theGuardiansEye.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
