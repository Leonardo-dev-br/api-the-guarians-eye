package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.DisasterSensorDTO;
import montclio.theGuardiansEye.model.entity.DisasterSensorEntity;

public class DisasterSensorMapper {
    public static DisasterSensorDTO toDTO(DisasterSensorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new DisasterSensorDTO(
            entity.getIdDisasterSensor(),
            entity.getIdSensor(),
            entity.getIdDisaster()
        );
    }

    public static DisasterSensorEntity toEntity(DisasterSensorDTO dto) {
        if (dto == null) {
            return null;
        }
        DisasterSensorEntity entity = new DisasterSensorEntity();
        entity.setIdSensor(dto.getIdSensor());
        entity.setIdDisaster(dto.getIdDisaster());
        return entity;
    }
}
