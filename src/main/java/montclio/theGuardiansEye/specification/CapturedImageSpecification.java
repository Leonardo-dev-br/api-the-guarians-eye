package montclio.theGuardiansEye.specification;


import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;
import montclio.theGuardiansEye.model.entity.CapturedImageEntity;

public class CapturedImageSpecification {

    public static Specification<CapturedImageEntity> withFilters(Long idImage, String hosting, String size) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (idImage != null) {
                predicate = cb.and(predicate, cb.equal(root.get("zona").get("id"), idImage));
            }

            if (hosting != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("dataCaptura"), hosting));
            }

            if (size != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("dataCaptura"), size));
            }

            return predicate;
        };
    }
}
