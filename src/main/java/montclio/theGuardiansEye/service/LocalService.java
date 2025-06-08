package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.LocalDTO;
import montclio.theGuardiansEye.model.entity.LocalEntity;
import montclio.theGuardiansEye.model.mapper.LocalMapper;
import montclio.theGuardiansEye.model.repository.LocalRepository;

@Service
public class LocalService  {

    private final LocalRepository repository;

    @Autowired
    public LocalService (LocalRepository repository) {
        this.repository = repository;
    }

    public List<LocalDTO> getAllLocals() {
        return repository.findAll()
                .stream()
                .map(LocalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LocalDTO findById(Long id) {
        LocalEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Local de desastre com ID " + id + " não encontrado"));

        return LocalMapper.toDTO(entity);
    }

    public LocalDTO createLocal(LocalDTO dto) {
        LocalEntity entity = LocalMapper.toEntity(dto);
        LocalEntity saved = repository.save(entity);
        return LocalMapper.toDTO(saved);
    }

    public LocalDTO updateLocal(Long id, LocalDTO dto) {
        LocalEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Local com ID " + id + " não encontrado"));

        LocalEntity saved = repository.save(existing);
        return LocalMapper.toDTO(saved);
    }

    public void deleteLocal(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Local com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
