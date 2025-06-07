package montclio.theGuardiansEye.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long idUser;
    private String firstName;
    private String lastName;
    private Long cpf;
    private String position;
    private String role;
    private String email;
    private String password;
}
