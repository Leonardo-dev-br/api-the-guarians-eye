package montclio.theGuardiansEye.specification;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import montclio.theGuardiansEye.model.entity.CapturedImageEntity;

public class DisasterSensorSpecification {

    public static Specification<CapturedImageEntity> withFilters(Long zonaId, LocalDate dataInicio, LocalDate dataFim) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (zonaId != null) {
                predicate = cb.and(predicate, cb.equal(root.get("zona").get("id"), zonaId));
            }

            if (dataInicio != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("dataCaptura"), dataInicio));
            }

            if (dataFim != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("dataCaptura"), dataFim));
            }

            return predicate;
        };
    }
}
