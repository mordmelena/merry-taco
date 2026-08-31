package com.example.tacocloud.registration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.tacocloud.data.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }


    @PostMapping
    public String processRegistration(RegistrationForm form) {
        registrationService.register(form);
        return "redirect:/login";
    }
}
