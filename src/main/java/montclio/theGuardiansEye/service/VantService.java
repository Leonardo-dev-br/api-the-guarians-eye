package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.VantDTO;
import montclio.theGuardiansEye.model.entity.VantEntity;
import montclio.theGuardiansEye.model.mapper.VantMapper;
import montclio.theGuardiansEye.model.repository.VantRepository;

@Service
public class VantService  {

    private final VantRepository repository;

    @Autowired
    public VantService (VantRepository repository) {
        this.repository = repository;
    }

    public List<VantDTO> getAllVants() {
        return repository.findAll()
                .stream()
                .map(VantMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VantDTO updateVant(Long id, VantDTO dto) {
        VantEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "VANT com ID " + id + " não encontrado"));

        VantEntity saved = repository.save(existing);
        return VantMapper.toDTO(saved);
    }

    public void deleteVant(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "VANT com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
