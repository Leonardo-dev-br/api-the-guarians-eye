package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_impacto")
public class ImpactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impacto")
    private Long idImpact;

    @Column(name = "id_impacto_material")
    private Long idMaterialImpact;

    @Column(name = "id_impacto_humano")
    private Long idHumanImpact;

    @Column(name = "impacto")
    private String impact;

    public Long getIdImpact() {
        return idImpact;
    }

    public Long getIdMaterialImpact() {
        return idMaterialImpact;
    }

    public void setIdMaterialImpact(Long idMaterialImpact) {
        this.idMaterialImpact = idMaterialImpact;
    }

    public Long getIdHumanImpact() {
        return idHumanImpact;
    }

    public void setIdHumanImpact(Long idHumanImpact) {
        this.idHumanImpact = idHumanImpact;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }
}
