package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImpactRatingDTO {
    private Long idImpactRating;
    private Integer level;
    private String levelDescription;
}
