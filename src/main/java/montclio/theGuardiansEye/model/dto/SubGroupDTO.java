package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubGroupDTO {
    private Long idSubgroup;
    private String subgroup;
    private String type;
    private String subtype;
}
