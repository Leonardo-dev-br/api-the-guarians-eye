package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.model.entity.DisasterGroupEntity;

public class DisasterGroupMapper {
    public static DisasterGroupDTO toDTO(DisasterGroupEntity entity) {
        return new DisasterGroupDTO(
            entity.getIdDisasterGroup(),
            entity.getIdSubGroup(),
            entity.getGroup()
        );
    }

    public static DisasterGroupEntity toEntity(DisasterGroupDTO dto) {
        DisasterGroupEntity entity = new DisasterGroupEntity();
        entity.setIdSubGroup(dto.getIdSubGroup());
        entity.setGroup(dto.getGroup());
        return entity;
    }
}
