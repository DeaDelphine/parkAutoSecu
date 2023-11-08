package com.assosetvous.assosetvous.service;

import com.assosetvous.assosetvous.dto.SignUpRequest;
import com.assosetvous.assosetvous.entity.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);
}
