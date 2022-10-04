package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * A DTO for the {@link UserGroup} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupWithUsersDTO {
    private UUID id;
    @Length(min = 5, max = 100, message = "Role name must have length between {min} and {max}")
    private String name;
    @Length(min = 3, max = 10, message = "Role code must have length between {min} and {max}")
    private String code;
    @NotBlank
    private String description;
    private Set<UserDTO> users = new LinkedHashSet<>();
}