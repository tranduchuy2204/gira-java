package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.UserGroupDTO;
import cybersoft.javabackend.java18.gira.role.model.UserGroup;
import cybersoft.javabackend.java18.gira.role.service.UserGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user-groups")
public class UserGroupRestResource {
    private final UserGroupService service;

    public UserGroupRestResource(UserGroupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAllUser() {
        return ResponseUtils.get(
                service.findAllDto(UserGroupDTO.class),
                HttpStatus.OK
        );
    }

    @GetMapping("api/v1/include-users")
    public ResponseEntity<?> findAllUserGroupIncludedUsers() {
        return ResponseUtils.get(
                service.findAllDtoIncludeUsers(),
                HttpStatus.OK
        );
    }

    @PostMapping
    ResponseEntity<?> saveUser(@RequestBody @Valid UserGroupDTO userGroupDTO) {
        return ResponseUtils.get(
                service.save(userGroupDTO, UserGroup.class, UserGroupDTO.class),
                HttpStatus.OK
        );
    }

    @PostMapping("api/v1{user-group-id}/add-users")
    public ResponseEntity<?> addUsers(
            @PathVariable("user-group-id") UUID userGroupId,
            @RequestBody List<UUID> ids
    ) {
        return ResponseUtils.get(
                service.addUsers(userGroupId, ids),
                HttpStatus.OK
        );
    }
}
