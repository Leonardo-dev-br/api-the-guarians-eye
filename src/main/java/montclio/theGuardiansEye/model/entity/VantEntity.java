package montclio.theGuardiansEye.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_vant")
public class VantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vant")
    private Long idVant;

    @Column(name = "fabricante")
    private String manufacturer;

    @Column(name = "modelo")
    private String model;

    @Column(name = "tempo_voo")
    private Date flightTime;

    @Column(name = "distancia_maxima")
    private Double maxDistance;

    @Column(name = "velocidade_maxima")
    private Double maxSpeed;

    @Column(name = "peso")
    private Double weight;

    @Column(name = "camera")
    private String camera;

    public Long getIdVant() {
        return idVant;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public Double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }
}
