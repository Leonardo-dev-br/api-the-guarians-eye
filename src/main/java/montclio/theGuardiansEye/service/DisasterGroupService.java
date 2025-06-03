package montclio.theGuardiansEye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import montclio.theGuardiansEye.model.dto.DisasterGroupDTO;
import montclio.theGuardiansEye.model.repository.DisasterGroupRepository;

@Service
public class DisasterGroupService {
    @Autowired
    private DisasterGroupRepository disasterGroupRepository;

    public DisasterGroupDTO getDisasterGroupById(Long id) {
        return disasterGroupRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("DisasterGroup not found"));
    }

}
