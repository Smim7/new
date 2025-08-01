package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/new")
    public String home(){
        return "Welcome!";
    }
    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
       return (CsrfToken) request.getAttribute("_csrf");
    }

}
