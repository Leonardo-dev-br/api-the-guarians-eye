package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisasterSensorDTO {
    private Long idDisasterSensor;
    private Long idSensor;
    private Long idDisaster;
}
