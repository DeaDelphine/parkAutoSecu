package com.assosetvous.assosetvous.service;

import com.assosetvous.assosetvous.dto.JwtAuthenticationResponse;
import com.assosetvous.assosetvous.dto.RefreshTokenRequest;
import com.assosetvous.assosetvous.dto.SignInRequest;
import com.assosetvous.assosetvous.dto.SignUpRequest;
import com.assosetvous.assosetvous.entity.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
