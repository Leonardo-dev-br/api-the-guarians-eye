package montclio.theGuardiansEye.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tge_sensores")
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sensor")
    private Long idSensor;

    @Column(name = "chip")
    private String chip;

    @Column(name = "modelo")
    private String model;

    @Column(name = "interface")
    private String interfaceType;

    @Column(name = "utilidade")
    private String utility;

    @Column(name = "fabricante")
    private String manufacturer;

    @Column(name = "estado")
    private String status;

    @Column(name = "saida")
    private String output;

    @Column(name = "tipo_saida")
    private String outputType;

    @Column(name = "media_tensao_registrada")
    private Double averageVoltage;

    public Long getIdSensor() {
        return idSensor;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public Double getAverageVoltage() {
        return averageVoltage;
    }

    public void setAverageVoltage(Double averageVoltage) {
        this.averageVoltage = averageVoltage;
    }
}
