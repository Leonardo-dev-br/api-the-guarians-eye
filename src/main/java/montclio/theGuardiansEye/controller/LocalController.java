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

import montclio.theGuardiansEye.model.dto.LocalDTO;
import montclio.theGuardiansEye.service.LocalService;

@RestController
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService LocalService;

    
    @GetMapping
    public ResponseEntity<List<LocalDTO>> getAll() {
        List<LocalDTO> dtos = LocalService.getAllLocals();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LocalDTO> getById(@PathVariable Long id) {
        LocalDTO dto = LocalService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<LocalDTO> create(@RequestBody LocalDTO dto) {
        LocalDTO created = LocalService.createLocal(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LocalDTO> update(@PathVariable Long id, @RequestBody LocalDTO dto) {
        LocalDTO updated = LocalService.updateLocal(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        LocalService.deleteLocal(id);
        return ResponseEntity.noContent().build();
    }
}
