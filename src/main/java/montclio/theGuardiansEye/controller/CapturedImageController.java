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

import montclio.theGuardiansEye.model.dto.CapturedImageDTO;
import montclio.theGuardiansEye.service.CapturedImageService;

@RestController
@RequestMapping("/captured-image")
public class CapturedImageController {

    @Autowired
    private CapturedImageService CapturedImageService;

    
    @GetMapping
    public ResponseEntity<List<CapturedImageDTO>> getAll() {
        List<CapturedImageDTO> dtos = CapturedImageService.getAllCapturedImages();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CapturedImageDTO> getById(@PathVariable Long id) {
        CapturedImageDTO dto = CapturedImageService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<CapturedImageDTO> create(@RequestBody CapturedImageDTO dto) {
        CapturedImageDTO created = CapturedImageService.createCapturedImage(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CapturedImageDTO> update(@PathVariable Long id, @RequestBody CapturedImageDTO dto) {
        CapturedImageDTO updated = CapturedImageService.updateCapturedImage(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CapturedImageService.deleteCapturedImage(id);
        return ResponseEntity.noContent().build();
    }
}
