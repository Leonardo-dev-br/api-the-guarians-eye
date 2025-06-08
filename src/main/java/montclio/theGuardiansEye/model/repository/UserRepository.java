package montclio.theGuardiansEye.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import montclio.theGuardiansEye.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Page<UserEntity> findAll(Specification<UserEntity> spec, Pageable pageable);
}
