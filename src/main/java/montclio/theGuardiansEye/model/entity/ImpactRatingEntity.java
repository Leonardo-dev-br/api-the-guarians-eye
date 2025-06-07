package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_impacto_classificacao")
public class ImpactRatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impacto_classificacao")
    private Long idImpactRating;

    @Column(name = "nivel")
    private Integer level;

    @Column(name = "desc_nivel")
    private String levelDescription;

    public Long getIdImpactRating() {
        return idImpactRating;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }
}
