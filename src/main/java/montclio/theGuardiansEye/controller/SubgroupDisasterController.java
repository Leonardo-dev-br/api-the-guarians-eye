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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import montclio.theGuardiansEye.model.dto.SubGroupDTO;
import montclio.theGuardiansEye.service.SubgroupService;

@RestController
@RequestMapping("/subgroup-disaster")
@Tag(name = "Subgrupos de Desastre", description = "Gerenciamento de subgrupos vinculados a grupos de desastres")
public class SubgroupDisasterController {

    @Autowired
    private SubgroupService subgroupService;

    @GetMapping
    @Operation(summary = "Listar todos os subgrupos de desastre",
               description = "Retorna uma lista de todos os subgrupos associados aos grupos de desastres.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de subgrupos retornada com sucesso")
    })
    public ResponseEntity<List<SubGroupDTO>> getAll() {
        List<SubGroupDTO> dtos = subgroupService.getAllSubGroups();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar subgrupo por ID",
               description = "Retorna os detalhes de um subgrupo de desastre específico pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Subgrupo encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Subgrupo não encontrado")
    })
    public ResponseEntity<SubGroupDTO> getById(
            @Parameter(description = "ID do subgrupo a ser buscado", required = true)
            @PathVariable Long id) {
        SubGroupDTO dto = subgroupService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Criar novo subgrupo de desastre",
               description = "Adiciona um novo subgrupo a um grupo de desastre existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Subgrupo criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<SubGroupDTO> create(
            @Parameter(description = "Dados do subgrupo a ser criado", required = true)
            @RequestBody SubGroupDTO dto) {
        SubGroupDTO created = subgroupService.createSubgroup(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar subgrupo de desastre",
               description = "Atualiza os dados de um subgrupo existente pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Subgrupo atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Subgrupo não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<SubGroupDTO> update(
            @Parameter(description = "ID do subgrupo a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados do subgrupo", required = true)
            @RequestBody SubGroupDTO dto) {
        SubGroupDTO updated = subgroupService.updateSubGroup(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir subgrupo de desastre",
               description = "Remove um subgrupo de desastre do sistema com base no seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Subgrupo excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Subgrupo não encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do subgrupo a ser excluído", required = true)
            @PathVariable Long id) {
        subgroupService.deleteSubGroup(id);
        return ResponseEntity.noContent().build();
    }
}
