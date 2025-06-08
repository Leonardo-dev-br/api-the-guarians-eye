package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.SubGroupDTO;
import montclio.theGuardiansEye.model.entity.SubgroupDisasterEntity;
import montclio.theGuardiansEye.model.mapper.SubgroupMapper;
import montclio.theGuardiansEye.model.repository.SubgroupRepository;

@Service
public class SubgroupService  {

    private final SubgroupRepository repository;

    @Autowired
    public SubgroupService (SubgroupRepository repository) {
        this.repository = repository;
    }

    public List<SubGroupDTO> getAllSubGroups() {
        return repository.findAll()
                .stream()
                .map(SubgroupMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SubGroupDTO findById(Long id) {
        SubgroupDisasterEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Sub Group de desastre com ID " + id + " não encontrado"));

        return SubgroupMapper.toDTO(entity);
    }

    public SubGroupDTO createSubgroup(SubGroupDTO dto) {
        SubgroupDisasterEntity entity = SubgroupMapper.toEntity(dto);
        SubgroupDisasterEntity saved = repository.save(entity);
        return SubgroupMapper.toDTO(saved);
    }

    public SubGroupDTO updateSubGroup(Long id, SubGroupDTO dto) {
        SubgroupDisasterEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Subgrupo com ID " + id + " não encontrado"));

        SubgroupDisasterEntity saved = repository.save(existing);
        return SubgroupMapper.toDTO(saved);
    }

    public void deleteSubGroup(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Subgrupo com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
