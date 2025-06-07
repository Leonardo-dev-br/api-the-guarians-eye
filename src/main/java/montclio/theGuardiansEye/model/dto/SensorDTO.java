package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {
    private Long idSensor;
    private String chip;
    private String model;
    private String interfaceType;
    private String utility;
    private String manufacturer;
    private String status;
    private String output;
    private String outputType;
    private Double averageVoltage;
}
