package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.CapturedImageDTO;
import montclio.theGuardiansEye.model.entity.CapturedImageEntity;
import montclio.theGuardiansEye.model.mapper.CapturedImageMapper;
import montclio.theGuardiansEye.model.repository.CapturedImageRepository;

@Service
public class CapturedImageService  {

    private final CapturedImageRepository repository;

    @Autowired
    public CapturedImageService (CapturedImageRepository repository) {
        this.repository = repository;
    }

    public List<CapturedImageDTO> getAllCapturedImages() {
        return repository.findAll()
                .stream()
                .map(CapturedImageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CapturedImageDTO findById(Long id) {
        CapturedImageEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Imagem com ID " + id + " não encontrado"));

        return CapturedImageMapper.toDTO(entity);
    }

    public CapturedImageDTO createCapturedImage(CapturedImageDTO dto) {
        CapturedImageEntity entity = CapturedImageMapper.toEntity(dto);
        CapturedImageEntity saved = repository.save(entity);
        return CapturedImageMapper.toDTO(saved);
    }

    public CapturedImageDTO updateCapturedImage(Long id, CapturedImageDTO dto) {
        CapturedImageEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Imagem com ID " + id + " não encontrado"));

        CapturedImageEntity saved = repository.save(existing);
        return CapturedImageMapper.toDTO(saved);
    }

    public void deleteCapturedImage(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Imagem com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
