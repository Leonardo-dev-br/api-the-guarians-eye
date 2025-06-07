package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.LocalEntity;

public interface LocalRepository extends JpaRepository<LocalEntity, Long>, JpaSpecificationExecutor<LocalEntity> {
    
    
}
