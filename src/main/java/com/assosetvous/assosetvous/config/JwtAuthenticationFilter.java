package com.assosetvous.assosetvous.config;

import com.assosetvous.assosetvous.service.JWTService;
import com.assosetvous.assosetvous.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //On appel cette interface pour nous permettre de générer un token
    private final JWTService jwtService;
    // On appel cette methode pour récupérer les détails de notre utilisateur
    private final UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String autHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if(StringUtils.isEmpty(autHeader) || !StringUtils.startsWith(autHeader, "Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        jwt = autHeader.substring(7); // Car Bearer a 6 caractères + l'espace = 7
        userEmail = jwtService.extractUserName(jwt);
        // On vérifie si l'adremme mail est valide
        if(StringUtils.isNotEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()== null){
            UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);
            //On vérifie que le token et les informations d'authentification sont valides
            if (jwtService.isTokenValid(jwt, userDetails)){
                // Création d'un contexte de sécurité
               SecurityContext securityContext =  SecurityContextHolder.createEmptyContext();
               //Récupérer le token de celui qui s'est authentifié
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        //Je vais chercher les données de notre utiisateur connecté
                        userDetails, null, userDetails.getAuthorities()
                );
            }
        }
    }
}
