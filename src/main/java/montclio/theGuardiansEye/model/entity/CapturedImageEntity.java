package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_imagens_capturadas")
public class CapturedImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Long idImage;

    @Column(name = "hospedagem")
    private String hosting;

    @Column(name = "tamanho")
    private String size;

    public Long getIdImage() {
        return idImage;
    }

    public String getHosting() {
        return hosting;
    }

    public void setHosting(String hosting) {
        this.hosting = hosting;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
