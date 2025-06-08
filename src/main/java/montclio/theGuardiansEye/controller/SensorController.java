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

import montclio.theGuardiansEye.model.dto.SensorDTO;
import montclio.theGuardiansEye.service.SensorService;

@RestController
@RequestMapping("/sensor-controller")
public class SensorController {

    @Autowired
    private SensorService SensorService;

    
    @GetMapping
    public ResponseEntity<List<SensorDTO>> getAll() {
        List<SensorDTO> dtos = SensorService.getAllSensors();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> getById(@PathVariable Long id) {
        SensorDTO dto = SensorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<SensorDTO> create(@RequestBody SensorDTO dto) {
        SensorDTO created = SensorService.createGroupSensor(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SensorDTO> update(@PathVariable Long id, @RequestBody SensorDTO dto) {
        SensorDTO updated = SensorService.updateSensor(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        SensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }
}
