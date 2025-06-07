package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.CapturedImageDTO;
import montclio.theGuardiansEye.model.entity.CapturedImageEntity;

public class CapturedImageMapper {

    public static CapturedImageDTO toDTO(CapturedImageEntity entity) {
        if (entity == null) {
            return null;
        }
        return new CapturedImageDTO(
            entity.getIdImage(),
            entity.getHosting(),
            entity.getSize()
        );
    }

    public static CapturedImageEntity toEntity(CapturedImageDTO dto) {
        if (dto == null) {
            return null;
        }
        CapturedImageEntity entity = new CapturedImageEntity();
        entity.setHosting(dto.getHosting());
        entity.setSize(dto.getSize());
        return entity;
    }
}
