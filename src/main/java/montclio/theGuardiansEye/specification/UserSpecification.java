package montclio.theGuardiansEye.specification;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import montclio.theGuardiansEye.model.entity.UserEntity;

public class UserSpecification {

public static Specification<UserEntity> withFilters(
        Long idUser,
        String firstName,
        String lastName
    ) {
        return (root, query, cb) -> {
            Predicate p = cb.conjunction();
            if (idUser != null) {
                p = cb.and(p, cb.equal(root.get("idUser"), idUser));
            }
            if (firstName != null && !firstName.isBlank()) {
                p = cb.and(p, cb.like(cb.lower(root.get("Primeiro nome")), "%" + firstName.toLowerCase() + "%"));
            }
            if (lastName != null && !lastName.isBlank()) {
                p = cb.and(p, cb.like(cb.lower(root.get("Sobrenome")), "%" + lastName.toLowerCase() + "%"));
            }
            return p;
        };
    }
}
