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

import montclio.theGuardiansEye.model.dto.VantDTO;
import montclio.theGuardiansEye.service.VantService;

@RestController
@RequestMapping("/vant")
public class VantController {

    @Autowired
    private VantService VantService;

    
    @GetMapping
    public ResponseEntity<List<VantDTO>> getAll() {
        List<VantDTO> dtos = VantService.getAllVants();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<VantDTO> getById(@PathVariable Long id) {
        VantDTO dto = VantService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<VantDTO> create(@RequestBody VantDTO dto) {
        VantDTO created = VantService.createVant(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<VantDTO> update(@PathVariable Long id, @RequestBody VantDTO dto) {
        VantDTO updated = VantService.updateVant(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        VantService.deleteVant(id);
        return ResponseEntity.noContent().build();
    }
}
