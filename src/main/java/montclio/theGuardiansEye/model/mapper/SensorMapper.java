package montclio.theGuardiansEye.model.mapper;


import montclio.theGuardiansEye.model.dto.SensorDTO;
import montclio.theGuardiansEye.model.entity.SensorEntity;

public class SensorMapper {
    public static SensorDTO toDTO(SensorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new SensorDTO(
            entity.getIdSensor(),
            entity.getChip(),
            entity.getInterfaceType(),
            entity.getManufacturer(),
            entity.getModel(),
            entity.getOutput(),
            entity.getOutputType(),
            entity.getStatus(),
            entity.getUtility(),
            entity.getAverageVoltage()
        );
    }

    public static SensorEntity toEntity(SensorDTO dto) {
        if (dto == null) {
            return null;
        }
        SensorEntity entity = new SensorEntity();
            entity.setChip(dto.getChip());
            entity.setInterfaceType(dto.getInterfaceType());
            entity.setManufacturer(dto.getManufacturer());
            entity.setModel(dto.getModel());
            entity.setOutput(dto.getOutput());
            entity.setOutputType(dto.getOutputType());
            entity.setStatus(dto.getStatus());
            entity.setUtility(dto.getUtility());
            entity.setAverageVoltage(dto.getAverageVoltage());
        return entity;
    }
}
