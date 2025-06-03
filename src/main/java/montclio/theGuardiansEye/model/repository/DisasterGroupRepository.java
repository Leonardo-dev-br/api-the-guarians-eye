package montclio.theGuardiansEye.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import montclio.theGuardiansEye.model.entity.DisasterGroupEntity;

public interface DisasterGroupRepository extends JpaRepository<DisasterGroupEntity, Long>, JpaSpecificationExecutor<DisasterGroupEntity> {

}
