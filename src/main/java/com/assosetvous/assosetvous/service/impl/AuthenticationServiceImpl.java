package com.assosetvous.assosetvous.service.impl;

import com.assosetvous.assosetvous.dto.SignUpRequest;
import com.assosetvous.assosetvous.entity.Role;
import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.repository.IUserRepository;
import com.assosetvous.assosetvous.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
// injecte les constructeurs directement grâce à lombok
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    // j'ai besoin de mon Repository qui a le CRUD
    private final IUserRepository userRepository;
    // et de mon mot de passe encoder
    private final PasswordEncoder passwordEncoder;
    //pour se connecter j'ai aussi besoin de mon utilisateur

    // je vais donc chercher dans ma sous classe (SignUpRequest)  mes informations de mon utilisateur
    public User signup(SignUpRequest signUpRequest){
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstName());
        user.setLastname(signUpRequest.getLastName());
        user.setRole(Role.USER);  // User is not allow to be an admin in register
        // on récupère notre mot de passe encoder depuis passwordEncoder avec la methode encode
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        // On va ensuite aller sauvegarder nos informations dans notre base de donnée en utilisant notre repository
        return  userRepository.save(user);
    }
}
