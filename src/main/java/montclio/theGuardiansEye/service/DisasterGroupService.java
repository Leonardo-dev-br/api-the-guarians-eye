package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.model.entity.DisasterGroupEntity;
import montclio.theGuardiansEye.model.mapper.DisasterGroupMapper;
import montclio.theGuardiansEye.model.repository.DisasterGroupRepository;

@Service
public class DisasterGroupService {

    private final DisasterGroupRepository repository;

    @Autowired
    public DisasterGroupService(DisasterGroupRepository repository) {
        this.repository = repository;
    }

    public List<DisasterGroupDTO> getAllGroups() {
        return repository.findAll()
                .stream()
                .map(DisasterGroupMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DisasterGroupDTO updateGroup(Long id, DisasterGroupDTO dto) {
    DisasterGroupEntity existing = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(
            "Grupo de desastre com ID " + id + " não encontrado"));

    existing.setGroup(dto.getGroup()); 

    DisasterGroupEntity saved = repository.save(existing);
    return DisasterGroupMapper.toDTO(saved);
    }


    public void deleteGroup(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Grupo de desastre com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
