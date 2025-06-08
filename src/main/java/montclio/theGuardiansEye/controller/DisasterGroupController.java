package montclio.theGuardiansEye.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.service.DisasterGroupService;

@RestController
@RequestMapping("/disaster-group")
@Tag(name = "Grupo de Desastres", description = "Endpoints para gerenciamento de grupos de desastres")
public class DisasterGroupController {

    @Autowired
    private DisasterGroupService disasterGroupService;

    @GetMapping
    @Operation(summary = "Listar todos os grupos de desastres", description = "Retorna uma lista paginada e ordenada de grupos de desastres.")
    public ResponseEntity<Page<DisasterGroupDTO>> getAll(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(disasterGroupService.getAllGroups(pageable));
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar grupo de desastre por ID", description = "Retorna os dados de um grupo de desastre específico com base no ID fornecido.")
    public ResponseEntity<DisasterGroupDTO> getById(
            @Parameter(description = "ID do grupo de desastre", required = true)
            @PathVariable Long id) {
        DisasterGroupDTO dto = disasterGroupService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Criar novo grupo de desastre", description = "Cria um novo grupo de desastre com os dados fornecidos.")
    public ResponseEntity<DisasterGroupDTO> create(
            @Parameter(description = "Dados do grupo de desastre a ser criado", required = true)
            @RequestBody DisasterGroupDTO dto) {
        DisasterGroupDTO created = disasterGroupService.createGroup(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar grupo de desastre", description = "Atualiza os dados de um grupo de desastre existente com base no ID fornecido.")
    public ResponseEntity<DisasterGroupDTO> update(
            @Parameter(description = "ID do grupo de desastre a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados do grupo de desastre", required = true)
            @RequestBody DisasterGroupDTO dto) {
        DisasterGroupDTO updated = disasterGroupService.updateGroup(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir grupo de desastre", description = "Exclui um grupo de desastre com base no ID fornecido.")
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do grupo de desastre a ser excluído", required = true)
            @PathVariable Long id) {
        disasterGroupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
