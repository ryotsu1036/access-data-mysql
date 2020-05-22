package com.example.accessdatamysql.controllers.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String showLoginForm() {
        return "auth/login";
    }

}
