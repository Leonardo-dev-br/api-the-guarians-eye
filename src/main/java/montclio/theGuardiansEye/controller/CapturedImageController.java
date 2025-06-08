package montclio.theGuardiansEye.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import montclio.theGuardiansEye.model.dto.CapturedImageDTO;
import montclio.theGuardiansEye.service.CapturedImageService;

@RestController
@RequestMapping("/captured-image")
@Tag(name = "Captured Images", description = "Operações relacionadas às imagens capturadas por sensores ou câmeras.")
public class CapturedImageController {

    @Autowired
    private CapturedImageService CapturedImageService;

    @GetMapping
    @Operation(summary = "Listar todas as imagens capturadas", description = "Retorna uma lista de todas as imagens capturadas registradas no sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public ResponseEntity<Page<CapturedImageDTO>> getAllWithPagination(
    @Parameter(description = "ID da zona (opcional)") @RequestParam(required = false) Long zonaId,
    @Parameter(description = "Data mínima de captura (yyyy-MM-dd, opcional)") @RequestParam(required = false) String dataInicio,
    @Parameter(description = "Data máxima de captura (yyyy-MM-dd, opcional)") @RequestParam(required = false) String dataFim,
    @Parameter(hidden = true) @PageableDefault(size = 10, sort = "id") Pageable pageable
) {
    Page<CapturedImageDTO> page = CapturedImageService.getAllWithFilters(zonaId, dataInicio, dataFim, pageable);
    return ResponseEntity.ok(page);
}

    @GetMapping("/{id}")
    @Operation(summary = "Buscar imagem por ID", description = "Retorna os detalhes de uma imagem capturada com base no seu ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Imagem encontrada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Imagem não encontrada")
    })
    public ResponseEntity<CapturedImageDTO> getById(
            @Parameter(description = "ID da imagem capturada") @PathVariable Long id) {
        CapturedImageDTO dto = CapturedImageService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova imagem", description = "Registra uma nova imagem capturada no sistema.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Imagem criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos enviados")
    })
    public ResponseEntity<CapturedImageDTO> create(
            @Parameter(description = "Dados da nova imagem capturada") @RequestBody CapturedImageDTO dto) {
        CapturedImageDTO created = CapturedImageService.createCapturedImage(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar imagem existente", description = "Atualiza os dados de uma imagem capturada com base no ID informado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Imagem atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Imagem não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos enviados")
    })
    public ResponseEntity<CapturedImageDTO> update(
            @Parameter(description = "ID da imagem a ser atualizada") @PathVariable Long id,
            @Parameter(description = "Novos dados da imagem capturada") @RequestBody CapturedImageDTO dto) {
        CapturedImageDTO updated = CapturedImageService.updateCapturedImage(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir imagem", description = "Remove uma imagem capturada do sistema com base no seu ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Imagem excluída com sucesso"),
        @ApiResponse(responseCode = "404", description = "Imagem não encontrada")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID da imagem a ser excluída") @PathVariable Long id) {
        CapturedImageService.deleteCapturedImage(id);
        return ResponseEntity.noContent().build();
    }
}
