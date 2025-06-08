package montclio.theGuardiansEye.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import montclio.theGuardiansEye.model.dto.DisasterSensorDTO;
import montclio.theGuardiansEye.service.DisasterSensorService;

@RestController
@RequestMapping("/disaster-sensor-controller")
public class DisasterSensorController {

    @Autowired
    private DisasterSensorService DisasterSensorService;

    
    @GetMapping
    public ResponseEntity<List<DisasterSensorDTO>> getAll() {
        List<DisasterSensorDTO> dtos = DisasterSensorService.getAllDisasterSensors();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DisasterSensorDTO> getById(@PathVariable Long id) {
        DisasterSensorDTO dto = DisasterSensorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<DisasterSensorDTO> create(@RequestBody DisasterSensorDTO dto) {
        DisasterSensorDTO created = DisasterSensorService.createDisasterSensor(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DisasterSensorDTO> update(@PathVariable Long id, @RequestBody DisasterSensorDTO dto) {
        DisasterSensorDTO updated = DisasterSensorService.updateDisasterSensor(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        DisasterSensorService.deleteDisasterSensor(id);
        return ResponseEntity.noContent().build();
    }
}
