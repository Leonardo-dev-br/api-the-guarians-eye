package montclio.theGuardiansEye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import montclio.theGuardiansEye.model.dto.UserDTO;
import montclio.theGuardiansEye.model.entity.UserEntity;
import montclio.theGuardiansEye.model.mapper.UserMapper;
import montclio.theGuardiansEye.model.repository.UserRepository;
import montclio.theGuardiansEye.specification.UserSpecification;

@Service
public class UserService  {

    private final UserRepository repository;

    @Autowired
    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public Page<UserDTO> getAllUsers(
        Long idUser,
        String firstName,
        String lastName,
        Pageable pageable
    ) {
        return repository
            .findAll(
                UserSpecification.withFilters(idUser, firstName, lastName),
                pageable
            )
            .map(UserMapper::toDTO);
    }

    public UserDTO findById(Long id) {
        UserEntity entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(
                "Usuário com ID " + id + " não encontrado"));

        return UserMapper.toDTO(entity);
    }

    public UserDTO createUser(UserDTO dto) {
        UserEntity entity = UserMapper.toEntity(dto);
        UserEntity saved = repository.save(entity);
        return UserMapper.toDTO(saved);
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
