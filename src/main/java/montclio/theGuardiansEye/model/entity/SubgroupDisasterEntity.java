package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_subgrupo_desastre")
public class SubgroupDisasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subgrupo")
    private Long idSubgroup;

    @Column(name = "subgrupo")
    private String subgroup;

    @Column(name = "tipo")
    private String type;

    @Column(name = "subtipo")
    private String subtype;


    public Long getIdSubgroup() {
        return idSubgroup;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
}
