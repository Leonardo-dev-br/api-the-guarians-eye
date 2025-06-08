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
import montclio.theGuardiansEye.model.dto.VantDTO;
import montclio.theGuardiansEye.service.VantService;

@RestController
@RequestMapping("/vant")
@Tag(name = "VANTs", description = "Gerenciamento de Veículos Aéreos Não Tripulados (VANTs)")
public class VantController {

    @Autowired
    private VantService vantService;

    @GetMapping
    @Operation(summary = "Listar todos os VANTs",
               description = "Retorna uma lista de todos os VANTs cadastrados no sistema.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de VANTs retornada com sucesso")
    })
    public ResponseEntity<List<VantDTO>> getAll() {
        List<VantDTO> dtos = vantService.getAllVants();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar VANT por ID",
               description = "Retorna os detalhes de um VANT específico identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "VANT encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "VANT não encontrado")
    })
    public ResponseEntity<VantDTO> getById(
            @Parameter(description = "ID do VANT a ser buscado", required = true)
            @PathVariable Long id) {
        VantDTO dto = vantService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo VANT",
               description = "Cria um novo VANT com os dados fornecidos.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "VANT criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<VantDTO> create(
            @Parameter(description = "Dados do VANT a ser criado", required = true)
            @RequestBody VantDTO dto) {
        VantDTO created = vantService.createVant(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar VANT",
               description = "Atualiza os dados de um VANT existente identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "VANT atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "VANT não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<VantDTO> update(
            @Parameter(description = "ID do VANT a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados do VANT", required = true)
            @RequestBody VantDTO dto) {
        VantDTO updated = vantService.updateVant(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir VANT",
               description = "Remove um VANT do sistema com base no seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "VANT excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "VANT não encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do VANT a ser excluído", required = true)
            @PathVariable Long id) {
        vantService.deleteVant(id);
        return ResponseEntity.noContent().build();
    }
}
