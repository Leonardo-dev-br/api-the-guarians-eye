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
import montclio.theGuardiansEye.model.dto.DisasterSensorDTO;
import montclio.theGuardiansEye.service.DisasterSensorService;

@RestController
@RequestMapping("/disaster-sensor")
@Tag(name = "Sensores de Desastre", description = "Operações para gerenciamento dos sensores de monitoramento de desastres")
public class DisasterSensorController {

    @Autowired
    private DisasterSensorService disasterSensorService;

    @GetMapping
    @Operation(summary = "Listar todos os sensores de desastre",
               description = "Retorna uma lista de todos os sensores cadastrados para monitoramento de desastres.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de sensores retornada com sucesso")
    })
    public ResponseEntity<List<DisasterSensorDTO>> getAll() {
        List<DisasterSensorDTO> dtos = disasterSensorService.getAllDisasterSensors();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar sensor por ID",
               description = "Retorna os detalhes de um sensor de desastre específico identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado")
    })
    public ResponseEntity<DisasterSensorDTO> getById(
            @Parameter(description = "ID do sensor a ser buscado", required = true)
            @PathVariable Long id) {
        DisasterSensorDTO dto = disasterSensorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo sensor de desastre",
               description = "Adiciona um novo sensor ao sistema de monitoramento de desastres.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<DisasterSensorDTO> create(
            @Parameter(description = "Dados do sensor a ser criado", required = true)
            @RequestBody DisasterSensorDTO dto) {
        DisasterSensorDTO created = disasterSensorService.createDisasterSensor(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar sensor de desastre",
               description = "Atualiza os parâmetros de um sensor existente identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<DisasterSensorDTO> update(
            @Parameter(description = "ID do sensor a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados do sensor", required = true)
            @RequestBody DisasterSensorDTO dto) {
        DisasterSensorDTO updated = disasterSensorService.updateDisasterSensor(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir sensor de desastre",
               description = "Remove um sensor de desastre do sistema com base no seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Sensor excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do sensor a ser excluído", required = true)
            @PathVariable Long id) {
        disasterSensorService.deleteDisasterSensor(id);
        return ResponseEntity.noContent().build();
    }
}
