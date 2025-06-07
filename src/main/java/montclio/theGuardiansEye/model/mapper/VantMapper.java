package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.VantDTO;
import montclio.theGuardiansEye.model.entity.VantEntity;

public class VantMapper {

    public static VantDTO toDTO(VantEntity entity) {
        if (entity == null) {
            return null;
        }
        return new VantDTO(
            entity.getIdVant(),
            entity.getManufacturer(),
            entity.getModel(),
            entity.getFlightTime(),
            entity.getMaxDistance(),
            entity.getMaxSpeed(),
            entity.getWeight(),
            entity.getCamera()
        );
    }

    public static VantEntity toEntity(VantDTO dto) {
        if (dto == null) {
            return null;
        }
        VantEntity entity = new VantEntity();
        entity.setManufacturer(dto.getManufacturer());
        entity.setModel(dto.getModel());
        entity.setFlightTime(dto.getFlightTime());
        entity.setMaxDistance(dto.getMaxDistance());
        entity.setMaxSpeed(dto.getMaxSpeed());
        entity.setWeight(dto.getWeight());
        entity.setCamera(dto.getCamera());
        return entity;
    }
}
