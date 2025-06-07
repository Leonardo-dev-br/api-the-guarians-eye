package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.DisasterSensorEntity;

public interface DisasterSensorRepository extends JpaRepository<DisasterSensorEntity, Long>, JpaSpecificationExecutor<DisasterSensorEntity> {
    
}
