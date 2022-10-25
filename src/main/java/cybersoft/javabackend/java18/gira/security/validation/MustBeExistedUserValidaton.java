package cybersoft.javabackend.java18.gira.security.validation;

import cybersoft.javabackend.java18.gira.user.model.User;
import cybersoft.javabackend.java18.gira.user.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MustBeExistedUserValidaton implements ConstraintValidator<MustBeExistedUser, String> {
    private String message;
    private final UserRepository userRepository;

    public MustBeExistedUserValidaton(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(MustBeExistedUser target) {
        this.message = target.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        User user = userRepository.findByUsername(name)
                .orElse(null);

        if (user != null) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
