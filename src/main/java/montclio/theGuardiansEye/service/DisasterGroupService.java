package montclio.theGuardiansEye.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<DisasterGroupDTO> getAllGroups(Pageable pageable) {
        return repository.findAll(pageable)
                .map(DisasterGroupMapper::toDTO);
    }

    public DisasterGroupDTO findById(Long id) {
        DisasterGroupEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Grupo de desastre com ID " + id + " não encontrado"));

        return DisasterGroupMapper.toDTO(entity);
    }

    public DisasterGroupDTO createGroup(DisasterGroupDTO dto) {
        DisasterGroupEntity entity = DisasterGroupMapper.toEntity(dto);
        DisasterGroupEntity saved = repository.save(entity);
        return DisasterGroupMapper.toDTO(saved);
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
