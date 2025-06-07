package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.LocalDTO;
import montclio.theGuardiansEye.model.entity.LocalEntity;

public class LocalMapper {

    public static LocalDTO toDTO(LocalEntity entity) {
        if (entity == null) {
            return null;
        }
        return new LocalDTO(
            entity.getIdLocal(),
            entity.getCep(),
            entity.getAddress(),
            entity.getMunicipality(),
            entity.getNumber(),
            entity.getLongitude(),
            entity.getLatitude()
        );
    }

    public static LocalEntity toEntity(LocalDTO dto) {
        if (dto == null) {
            return null;
        }
        LocalEntity entity = new LocalEntity();
        entity.setCep(dto.getCep());
        entity.setAddress(dto.getAddress());
        entity.setMunicipality(dto.getMunicipality());
        entity.setNumber(dto.getNumber());
        entity.setLongitude(dto.getLongitude());
        entity.setLatitude(dto.getLatitude());
        return entity;
    }
}
