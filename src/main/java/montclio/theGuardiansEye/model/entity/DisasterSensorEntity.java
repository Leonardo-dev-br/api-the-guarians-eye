package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_desastre_sensores")
public class DisasterSensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desastre_sensor")
    private Long idDisasterSensor;

    @Column(name = "id_sensor")
    private Long idSensor;

    @Column(name = "id_desastre")
    private Long idDisaster;

    public Long getIdDisasterSensor() {
        return idDisasterSensor;
    }

    public Long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
    }

    public Long getIdDisaster() {
        return idDisaster;
    }

    public void setIdDisaster(Long idDisaster) {
        this.idDisaster = idDisaster;
    }
}
