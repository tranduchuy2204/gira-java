package cybersoft.javabackend.java18.gira.user.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.user.dto.UserDTO;
import cybersoft.javabackend.java18.gira.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class UserRestResource {
    private final UserService userService;

    public UserRestResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAllUser() {
        return ResponseUtils.get(
                userService.findAllDto(UserDTO.class),
                HttpStatus.OK
        );
    }

    @PostMapping
    ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO userDto) {
        return ResponseUtils.get(
                userService.createUser(userDto),
                HttpStatus.OK
        );
    }
}
