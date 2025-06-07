package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.VantEntity;

public interface VantRepository extends JpaRepository<VantEntity, Long>, JpaSpecificationExecutor<VantEntity> {
    
    
}
