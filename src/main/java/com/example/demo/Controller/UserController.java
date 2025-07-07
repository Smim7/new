package com.example.demo.Controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;


    public UserController(UserRepository userRepository, UserService userService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userService = userService;
        //this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
   public User register(@RequestBody User user){
     // return   userRepository.save(user);
        return userService.register(user);

    }
    @PostMapping("/login")
    public String login(@RequestBody User user){

        return userService.verify(user);
//       var u= userRepository.findUserByUsername(user.getUsername());
//       if (!Objects.isNull(u))
//        return "Success";
//       else
//           return "Fail";
    }
}
