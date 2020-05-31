package com.example.accessdatamysql.controllers.auth;

import com.example.accessdatamysql.models.User;
import com.example.accessdatamysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "auth/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String create(@RequestParam String name, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/login";
    }
}
