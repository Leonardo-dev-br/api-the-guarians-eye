package montclio.theGuardiansEye.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.model.entity.DisasterGroupEntity;
import montclio.theGuardiansEye.model.mapper.DisasterGroupMapper;
import montclio.theGuardiansEye.model.repository.DisasterGroupRepository;

@Service
public class DisasterGroupService {
    @Autowired
    private DisasterGroupRepository disasterGroupRepository;

    public DisasterGroupDTO getDisasterGroupById(Long id) {
        Optional<DisasterGroupEntity> optional = disasterGroupRepository.findById(id);

        DisasterGroupEntity entity = optional.orElseThrow(() -> 
            new RuntimeException("Grupo de desastre com ID " + id + " não encontrado"));

        return DisasterGroupMapper.toDTO(entity);
    }

}
