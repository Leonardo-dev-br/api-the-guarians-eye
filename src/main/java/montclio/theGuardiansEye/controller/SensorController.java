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
import montclio.theGuardiansEye.model.dto.SensorDTO;
import montclio.theGuardiansEye.service.SensorService;

@RestController
@RequestMapping("/sensor")
@Tag(name = "Sensores", description = "Endpoints para gerenciamento de sensores genéricos")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    @Operation(summary = "Listar todos os sensores",
               description = "Retorna uma lista de todos os sensores cadastrados no sistema.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de sensores retornada com sucesso")
    })
    public ResponseEntity<List<SensorDTO>> getAll() {
        List<SensorDTO> dtos = sensorService.getAllSensors();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar sensor por ID",
               description = "Retorna os detalhes de um sensor específico identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado")
    })
    public ResponseEntity<SensorDTO> getById(
            @Parameter(description = "ID do sensor a ser buscado", required = true)
            @PathVariable Long id) {
        SensorDTO dto = sensorService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo sensor",
               description = "Adiciona um novo sensor ao sistema.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<SensorDTO> create(
            @Parameter(description = "Dados do sensor a ser criado", required = true)
            @RequestBody SensorDTO dto) {
        SensorDTO created = sensorService.createGroupSensor(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar sensor",
               description = "Atualiza os dados de um sensor existente identificado pelo seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Sensor atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<SensorDTO> update(
            @Parameter(description = "ID do sensor a ser atualizado", required = true)
            @PathVariable Long id,
            @Parameter(description = "Novos dados do sensor", required = true)
            @RequestBody SensorDTO dto) {
        SensorDTO updated = sensorService.updateSensor(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir sensor",
               description = "Remove um sensor do sistema com base no seu ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Sensor excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Sensor não encontrado")
    })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do sensor a ser excluído", required = true)
            @PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.noContent().build();
    }
}
