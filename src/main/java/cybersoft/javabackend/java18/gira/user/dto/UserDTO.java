package cybersoft.javabackend.java18.gira.user.dto;

import cybersoft.javabackend.java18.gira.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * A DTO for the {@link User} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    protected UUID id;
    private String username;
    private String password;
    private String email;
    private String displayName;
    private String fullname;
    private String avatar;
    private User.Status status;
}