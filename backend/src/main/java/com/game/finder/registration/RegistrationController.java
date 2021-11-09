package com.game.finder.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
//@RequestMapping("api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    private final RegistrationService registrationService;

//    @GetMapping("/")
//    public String login(){
//        return "authenticated successfully";
//    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @PostMapping(path = "registration")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
