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

import montclio.theGuardiansEye.model.dto.ImpactRatingDTO;
import montclio.theGuardiansEye.service.ImpactRatingService;

@RestController
@RequestMapping("/impact-rating")
public class ImpactRatingController {

    @Autowired
    private ImpactRatingService ImpactRatingService;

    
    @GetMapping
    public ResponseEntity<List<ImpactRatingDTO>> getAll() {
        List<ImpactRatingDTO> dtos = ImpactRatingService.getAllImpactRatings();
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ImpactRatingDTO> getById(@PathVariable Long id) {
        ImpactRatingDTO dto = ImpactRatingService.findById(id);
        return ResponseEntity.ok(dto);
    }

    
    @PostMapping
    public ResponseEntity<ImpactRatingDTO> create(@RequestBody ImpactRatingDTO dto) {
        ImpactRatingDTO created = ImpactRatingService.createImpactRating(dto);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ImpactRatingDTO> update(@PathVariable Long id, @RequestBody ImpactRatingDTO dto) {
        ImpactRatingDTO updated = ImpactRatingService.updateImpactRating(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ImpactRatingService.deleteImpactRating(id);
        return ResponseEntity.noContent().build();
    }
}
