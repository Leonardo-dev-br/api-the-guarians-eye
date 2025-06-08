package montclio.theGuardiansEye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.service.DisasterGroupService;

@RestController
@RequestMapping("/disaster-group")
public class DisasterGroupController {

    @Autowired
    private DisasterGroupService disasterGroupService;

    //Pegadno Geral

    //Pegando por ID
    @GetMapping("/{id}")
    public ResponseEntity<DisasterGroupDTO> getById(@PathVariable Long id) {
        DisasterGroupDTO dto = disasterGroupService.findById(id);
        return ResponseEntity.ok(dto);
    }


    //Atualizando por ID

    //Deletando por ID
}
