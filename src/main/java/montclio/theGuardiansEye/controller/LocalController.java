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
import montclio.theGuardiansEye.model.dto.LocalDTO;
import montclio.theGuardiansEye.service.LocalService;

@RestController
@RequestMapping("/local")
@Tag(name = "Locais", description = "Operações para gerenciamento de locais de desastres")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping
    @Operation(summary = "Listar todos os locais",
               description = "Retorna uma lista de todos os locais cadastrados para monitoramento de desastres.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de locais retornada com sucesso")
    })
    public ResponseEntity<List<LocalDTO>> getAll() {
        List<LocalDTO> dtos = localService.getAllLocals();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar local por ID",
               description = "Retorna os detalhes de um local específico identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Local encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Local não encontrado")
    })
    public ResponseEntity<LocalDTO> getById(
            @Parameter(description = "ID do local a ser buscado", required = true)
            @PathVariable Long id) {
        LocalDTO dto = localService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo local",
               description = "Adiciona um novo local ao sistema de monitoramento de desastres.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Local criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<LocalDTO> create(
            @Parameter(description = "Dados do local a ser criado", required = true)
            @RequestBody LocalDTO dto) {
        LocalDTO created = localService.createLocal(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar local",
               description = "Atualiza os dados de um local existente identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Local atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Local não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<LocalDTO> update(
            @Parameter(description = "ID do local a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados do local", required = true)
            @RequestBody LocalDTO dto) {
        LocalDTO updated = localService.updateLocal(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir local",
               description = "Remove um local do sistema com base no seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Local excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Local não encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do local a ser excluído", required = true)
            @PathVariable Long id) {
        localService.deleteLocal(id);
        return ResponseEntity.noContent().build();
    }
}
