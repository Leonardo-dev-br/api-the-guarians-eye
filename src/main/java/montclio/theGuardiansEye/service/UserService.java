package montclio.theGuardiansEye.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.UserDTO;
import montclio.theGuardiansEye.model.entity.UserEntity;
import montclio.theGuardiansEye.model.mapper.UserMapper;
import montclio.theGuardiansEye.model.repository.UserRepository;

@Service
public class UserService  {

    private final UserRepository repository;

    @Autowired
    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        UserEntity 
        existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuário com ID " + id + " não encontrado"));

        UserEntity saved = repository.save(existing);
        return UserMapper.toDTO(saved);
    }

    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Usuário com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}
