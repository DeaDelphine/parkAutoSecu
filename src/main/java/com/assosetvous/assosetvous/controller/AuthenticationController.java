package com.assosetvous.assosetvous.controller;

import com.assosetvous.assosetvous.dto.JwtAuthenticationResponse;
import com.assosetvous.assosetvous.dto.RefreshTokenRequest;
import com.assosetvous.assosetvous.dto.SignInRequest;
import com.assosetvous.assosetvous.dto.SignUpRequest;
import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.exception.EmailNotFoundException;
import com.assosetvous.assosetvous.service.AuthenticationService;
import com.assosetvous.assosetvous.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
    @GetMapping("/resetPassword/{email}")
    public ResponseEntity<HttpResponse> resetPassword(@PathVariable("email") String email) throws EmailNotFoundException {
        userService.resetPassword(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
