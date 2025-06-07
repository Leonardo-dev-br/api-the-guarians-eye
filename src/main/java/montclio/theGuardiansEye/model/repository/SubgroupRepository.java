package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.SubgroupDisasterEntity;

public interface SubgroupRepository  extends JpaRepository<SubgroupDisasterEntity, Long>, JpaSpecificationExecutor<SubgroupDisasterEntity> {
    
    
}
