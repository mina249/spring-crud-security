package com.mina.customer.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "login/login";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "login/access-denied";
    }
}
