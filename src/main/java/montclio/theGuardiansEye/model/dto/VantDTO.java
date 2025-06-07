package montclio.theGuardiansEye.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VantDTO {
    private Long idVant;
    private String manufacturer;
    private String model;
    private Date flightTime;
    private Double maxDistance;
    private Double maxSpeed;
    private Double weight;
    private String camera;
}
