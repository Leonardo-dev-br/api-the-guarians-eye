package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_local")
public class LocalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;

    @Column(name = "cep")
    private Integer cep;

    @Column(name = "endereco")
    private String address;

    @Column(name = "municipio")
    private String municipality;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;


    public Long getIdLocal() {
        return idLocal;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
