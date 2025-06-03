package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisasterGroupDTO {
    private Long idDisasterGroup;
    private Long idSubGroup;
    private String group;
}
