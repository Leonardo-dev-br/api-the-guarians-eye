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

import montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.service.DisasterGroupService;

@RestController
@RequestMapping("/disaster-group")
public class DisasterGroupController {

    @Autowired
    private DisasterGroupService disasterGroupService;

    // Pegando todos os grupos
    @GetMapping
    public ResponseEntity<List<DisasterGroupDTO>> getAll() {
        List<DisasterGroupDTO> dtos = disasterGroupService.getAllGroups();
        return ResponseEntity.ok(dtos);
    }

    // Pegando por ID
    @GetMapping("/{id}")
    public ResponseEntity<DisasterGroupDTO> getById(@PathVariable Long id) {
        DisasterGroupDTO dto = disasterGroupService.findById(id);
        return ResponseEntity.ok(dto);
    }

    // Criando novo grupo
    @PostMapping
    public ResponseEntity<DisasterGroupDTO> create(@RequestBody DisasterGroupDTO dto) {
        DisasterGroupDTO created = disasterGroupService.createGroup(dto);
        return ResponseEntity.ok(created);
    }

    // Atualizando por ID
    @PutMapping("/{id}")
    public ResponseEntity<DisasterGroupDTO> update(@PathVariable Long id, @RequestBody DisasterGroupDTO dto) {
        DisasterGroupDTO updated = disasterGroupService.updateGroup(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Deletando por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        disasterGroupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
