package montclio.theGuardiansEye.model.mapper;

import montclio.theGuardiansEye.model.dto.UserDTO;
import montclio.theGuardiansEye.model.entity.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        return new UserDTO(
            entity.getIdUser(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getCpf(),
            entity.getPosition(),
            entity.getRole(),
            entity.getEmail(),
            entity.getPassword()
        );
    }

    public static UserEntity toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setCpf(dto.getCpf());
        entity.setPosition(dto.getPosition());
        entity.setRole(dto.getRole());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
