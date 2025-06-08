package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.ImpactRatingDTO;
import montclio.theGuardiansEye.model.entity.ImpactRatingEntity;
import montclio.theGuardiansEye.model.mapper.ImpactRatingMapper;
import montclio.theGuardiansEye.model.repository.ImpactRatingRepository;

@Service
public class ImpactRatingService  {

    private final ImpactRatingRepository repository;

    @Autowired
    public ImpactRatingService (ImpactRatingRepository repository) {
        this.repository = repository;
    }

    public List<ImpactRatingDTO> getAllImpactRatings() {
        return repository.findAll()
                .stream()
                .map(ImpactRatingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ImpactRatingDTO findById(Long id) {
        ImpactRatingEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Classificação de Impacto com ID " + id + " não encontrado"));

        return ImpactRatingMapper.toDTO(entity);
    }

    public ImpactRatingDTO updateImpactRating(Long id, ImpactRatingDTO dto) {
        ImpactRatingEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Classificação de Impacto com ID " + id + " não encontrado"));

        ImpactRatingEntity saved = repository.save(existing);
        return ImpactRatingMapper.toDTO(saved);
    }

    public void deleteImpactRating(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Classificação de Impacto com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
