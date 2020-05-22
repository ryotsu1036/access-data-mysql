package com.example.accessdatamysql.Controllers.Auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping({ "/register" })
    public String showRegistrationForm() {
        return "auth/register";
    }

}
