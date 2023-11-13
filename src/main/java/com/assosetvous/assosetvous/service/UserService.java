package com.assosetvous.assosetvous.service;

import com.assosetvous.assosetvous.exception.EmailNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@Service
public interface UserService {
    // Methode qui permet de réinitialiser le mot de passe de l'utilisateur
    void resetPassword(String email) throws EmailNotFoundException;

    UserDetailsService userDetailsService();
}

