package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.SubGroupDTO;
import montclio.theGuardiansEye.model.entity.SubgroupDisasterEntity;

public class SubgroupMapper {

    public static SubGroupDTO toDTO(SubgroupDisasterEntity entity) {
        if (entity == null) {
            return null;
        }
        return new SubGroupDTO(
            entity.getIdSubgroup(),
            entity.getSubgroup(),
            entity.getType(),
            entity.getSubtype()
        );
    }

    public static SubgroupDisasterEntity toEntity(SubGroupDTO dto) {
        if (dto == null) {
            return null;
        }
        SubgroupDisasterEntity entity = new SubgroupDisasterEntity();
        entity.setSubgroup(dto.getSubgroup());
        entity.setType(dto.getType());
        entity.setSubtype(dto.getSubtype());
        return entity;
    }
}
