package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.ImpactRatingDTO;
import montclio.theGuardiansEye.model.entity.ImpactRatingEntity;

public class ImpactRatingMapper {

    public static ImpactRatingDTO toDTO(ImpactRatingEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ImpactRatingDTO(
            entity.getIdImpactRating(),
            entity.getLevel(),
            entity.getLevelDescription()
        );
    }

    public static ImpactRatingEntity toEntity(ImpactRatingDTO dto) {
        if (dto == null) {
            return null;
        }
        ImpactRatingEntity entity = new ImpactRatingEntity();
        entity.setLevel(dto.getLevel());
        entity.setLevelDescription(dto.getLevelDescription());
        return entity;
    }
}
