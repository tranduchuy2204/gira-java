package cybersoft.javabackend.java18.gira.user.repository;

import cybersoft.javabackend.java18.gira.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}