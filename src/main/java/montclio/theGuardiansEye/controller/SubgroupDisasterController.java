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

import montclio.theGuardiansEye.model.dto.SubGroupDTO;
import montclio.theGuardiansEye.service.SubgroupService;

@RestController
@RequestMapping("/subgroup-disaster")
public class SubgroupDisasterController {

    @Autowired
    private SubgroupService SubgroupService;

    
    @GetMapping
    public ResponseEntity<List<SubGroupDTO>> getAll() {
        List<SubGroupDTO> dtos = SubgroupService.getAllSubGroups();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SubGroupDTO> getById(@PathVariable Long id) {
        SubGroupDTO dto = SubgroupService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<SubGroupDTO> create(@RequestBody SubGroupDTO dto) {
        SubGroupDTO created = SubgroupService.createSubgroup(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SubGroupDTO> update(@PathVariable Long id, @RequestBody SubGroupDTO dto) {
        SubGroupDTO updated = SubgroupService.updateSubGroup(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        SubgroupService.deleteSubGroup(id);;
        return ResponseEntity.noContent().build();
    }
}
