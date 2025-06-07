package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.ImpactRatingEntity;

public interface ImpactRatingRepository extends JpaRepository<ImpactRatingEntity, Long>, JpaSpecificationExecutor<ImpactRatingEntity> {
    
    
}
