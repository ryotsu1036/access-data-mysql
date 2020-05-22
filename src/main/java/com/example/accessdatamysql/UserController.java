package com.example.accessdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping({ "/users" })
public class UserController {

    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({ "/create" })
    public String create() {
        return "users/create";
    }

    @PostMapping()
    @ResponseBody
    public String store(@RequestParam Map<String, String> request) {
        return "Password: " + passwordEncoder.encode(request.get("password"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt 會在內部生成隨機鹽
        // BCrypt 演算法會生成長度為 60 的字串
        return new BCryptPasswordEncoder();
    }

}
