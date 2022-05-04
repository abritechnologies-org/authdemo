package com.abritech.demoauth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class ResController {

    @Secured("ROLE_developer")
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Welcome to our restaurant");
    }

    @GetMapping("/token")
    public Jwt token(@AuthenticationPrincipal Jwt jwtToken){
        return jwtToken;
    }


}
