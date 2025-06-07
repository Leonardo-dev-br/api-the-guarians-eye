package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.CapturedImageEntity;


public interface CapturedImageRepository extends JpaRepository<CapturedImageEntity, Long>,JpaSpecificationExecutor<CapturedImageEntity> {
    
}
