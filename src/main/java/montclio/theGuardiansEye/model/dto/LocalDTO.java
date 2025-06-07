package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalDTO {
    private Long idLocal;
    private Integer cep;
    private String address;
    private String municipality;
    private Integer number;
    private Double longitude;
    private Double latitude;
}
