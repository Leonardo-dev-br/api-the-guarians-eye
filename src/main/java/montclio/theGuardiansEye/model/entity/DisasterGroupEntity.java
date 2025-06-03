package montclio.theGuardiansEye.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_grupo_desastre")
public class DisasterGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_desastre")
    private Long idDisasterGroup;

    @Column(name = "id_subgrupo")
    private Long idSubGroup;

    @Column(name = "grupo")
    private String group;

    public Long getIdDisasterGroup() {
        return idDisasterGroup;
    }

    public Long getIdSubGroup() {
        return idSubGroup;
    }

    public void setIdSubGroup(Long idSubGroup) {
        this.idSubGroup = idSubGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}

