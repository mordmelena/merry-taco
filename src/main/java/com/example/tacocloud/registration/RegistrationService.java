package com.example.tacocloud.registration;

import com.example.tacocloud.User;
import com.example.tacocloud.data.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void register(RegistrationForm form) {
        User user = new User(
                        form.getUsername(),
                        passwordEncoder.encode(
                                form.getPassword()),
                        form.getFullname(),
                        form.getStreet(),
                        form.getCity(),
                        form.getState(),
                        form.getZip(),
                        form.getPhone()
        );
        userRepository.save(user);
    }
}
