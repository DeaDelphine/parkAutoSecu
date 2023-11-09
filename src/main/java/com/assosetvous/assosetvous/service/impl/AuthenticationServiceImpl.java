package com.assosetvous.assosetvous.service.impl;

import com.assosetvous.assosetvous.dto.JwtAuthenticationResponse;
import com.assosetvous.assosetvous.dto.SignInRequest;
import com.assosetvous.assosetvous.dto.SignUpRequest;
import com.assosetvous.assosetvous.entity.Role;
import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.repository.IUserRepository;
import com.assosetvous.assosetvous.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
// injecte les constructeurs directement grâce à lombok
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    // j'ai besoin de mon Repository qui a le CRUD
    private final IUserRepository userRepository;
    // et de mon mot de passe encoder
    private final PasswordEncoder passwordEncoder;
    //Je fais appel à mon gestionnaire d'authentifdication
    private final AuthenticationManager authenticationManager;
    private final JWTServiceImpl jwtService;

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


    // Je créer ma méthode de réponse à mon authentification
    public JwtAuthenticationResponse signin(SignInRequest signInRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), passwordEncoder.encode(signInRequest.getPassword()))
        );
       var user = userRepository.findByEmail(signInRequest.getEmail())
               .orElseThrow(
                       () -> new IllegalArgumentException(
                               "Invalid email or Password !"));
       // je  vais générer un token à partir de mon utilisateur récupérer plus tôt
       var jwt = jwtService.generateToken(user);
       // je vais rafraichir mon token pour que l'utilisateur qui se reconnecte au bout d'un certain temps récupère un nouveau token
       var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
       JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
       jwtAuthenticationResponse.setToken(jwt);
       jwtAuthenticationResponse.setRefreshToken(refreshToken);
       return jwtAuthenticationResponse;
    }

}
