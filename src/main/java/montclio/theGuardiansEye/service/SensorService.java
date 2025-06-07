package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.SensorDTO;
import montclio.theGuardiansEye.model.entity.SensorEntity;
import montclio.theGuardiansEye.model.mapper.SensorMapper;
import montclio.theGuardiansEye.model.repository.SensorRepository;

@Service
public class SensorService  {

    private final SensorRepository repository;

    @Autowired
    public SensorService (SensorRepository repository) {
        this.repository = repository;
    }

    public List<SensorDTO> getAllSensors() {
        return repository.findAll()
                .stream()
                .map(SensorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SensorDTO updateSensor(Long id, SensorDTO dto) {
        SensorEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Sensor com ID " + id + " não encontrado"));

        SensorEntity saved = repository.save(existing);
        return SensorMapper.toDTO(saved);
    }

    public void deleteSensor(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Sensor com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
