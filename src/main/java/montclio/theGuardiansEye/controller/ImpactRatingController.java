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
import montclio.theGuardiansEye.model.dto.ImpactRatingDTO;
import montclio.theGuardiansEye.service.ImpactRatingService;

@RestController
@RequestMapping("/impact-rating")
@Tag(name = "Avaliações de Impacto", description = "Gerenciamento de avaliações de impacto de desastres")
public class ImpactRatingController {

    @Autowired
    private ImpactRatingService impactRatingService;

    @GetMapping
    @Operation(summary = "Listar todas as avaliações de impacto",
               description = "Retorna uma lista de todas as avaliações de impacto cadastradas no sistema.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de avaliações retornada com sucesso")
    })
    public ResponseEntity<List<ImpactRatingDTO>> getAll() {
        List<ImpactRatingDTO> dtos = impactRatingService.getAllImpactRatings();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar avaliação de impacto por ID",
               description = "Retorna os detalhes de uma avaliação de impacto específica pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Avaliação encontrada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Avaliação não encontrada")
    })
    public ResponseEntity<ImpactRatingDTO> getById(
            @Parameter(description = "ID da avaliação de impacto", required = true)
            @PathVariable Long id) {
        ImpactRatingDTO dto = impactRatingService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Criar nova avaliação de impacto",
               description = "Cria uma nova avaliação de impacto com os dados fornecidos.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Avaliação criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<ImpactRatingDTO> create(
            @Parameter(description = "Dados da avaliação de impacto a ser criada", required = true)
            @RequestBody ImpactRatingDTO dto) {
        ImpactRatingDTO created = impactRatingService.createImpactRating(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar avaliação de impacto",
               description = "Atualiza os dados de uma avaliação de impacto existente pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Avaliação atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Avaliação não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<ImpactRatingDTO> update(
            @Parameter(description = "ID da avaliação de impacto a ser atualizada", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados da avaliação de impacto", required = true)
            @RequestBody ImpactRatingDTO dto) {
        ImpactRatingDTO updated = impactRatingService.updateImpactRating(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir avaliação de impacto",
               description = "Remove uma avaliação de impacto do sistema pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Avaliação excluída com sucesso"),
        @ApiResponse(responseCode = "404", description = "Avaliação não encontrada")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID da avaliação de impacto a ser excluída", required = true)
            @PathVariable Long id) {
        impactRatingService.deleteImpactRating(id);
        return ResponseEntity.noContent().build();
    }
}
