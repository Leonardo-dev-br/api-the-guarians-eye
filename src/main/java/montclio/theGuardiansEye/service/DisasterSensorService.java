package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.DisasterSensorDTO;
import montclio.theGuardiansEye.model.entity.DisasterSensorEntity;
import montclio.theGuardiansEye.model.mapper.DisasterSensorMapper;
import montclio.theGuardiansEye.model.repository.DisasterSensorRepository;

@Service
public class DisasterSensorService  {

    private final DisasterSensorRepository repository;

    @Autowired
    public DisasterSensorService (DisasterSensorRepository repository) {
        this.repository = repository;
    }

    public List<DisasterSensorDTO> getAllDisasterSensors() {
        return repository.findAll()
                .stream()
                .map(DisasterSensorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DisasterSensorDTO findById(Long id) {
        DisasterSensorEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Sensor com ID " + id + " não encontrado"));

        return DisasterSensorMapper.toDTO(entity);
    }

    public DisasterSensorDTO createDisasterSensor(DisasterSensorDTO dto) {
        DisasterSensorEntity entity = DisasterSensorMapper.toEntity(dto);
        DisasterSensorEntity saved = repository.save(entity);
        return DisasterSensorMapper.toDTO(saved);
    }

    public DisasterSensorDTO updateDisasterSensor(Long id, DisasterSensorDTO dto) {
        DisasterSensorEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Sensor com ID " + id + " não encontrado"));

        DisasterSensorEntity saved = repository.save(existing);
        return DisasterSensorMapper.toDTO(saved);
    }

    public void deleteDisasterSensor(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Sensor com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
