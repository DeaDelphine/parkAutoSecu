package com.assosetvous.assosetvous.config;

import com.assosetvous.assosetvous.entity.Role;
import com.assosetvous.assosetvous.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserService userService;

    //Creation de nos filtres de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        request -> request.requestMatchers(antMatcher("/api/auth/**"))
                                .permitAll()
                                .requestMatchers(antMatcher("/api/admin")).hasAuthority(Role.ADMIN.name())
                                .requestMatchers(antMatcher("/api/user")).hasAuthority(Role.USER.name())
                                .anyRequest().authenticated()
                )
        .sessionManagement(
                manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }
    // un bean est toujours en public
    //va fournir l'accès pour se connecter / s'authentifier
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // A partir de DAO je vais créer un objet qui sait le faire
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // je vais insérer mes détails de mon service utilisateur à l'intérieur de mon provider ( fichier de configuration)
        authenticationProvider.setUserDetailsService((userService.userDetailsService()));
        // je dois aussi insérer le mot de masse mais celui-ci doit être coder et je fais appel à une librairie (voir méthode
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        // je retourne ma configuration dans lequel je récupère mon gestionnaire d'authentification
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // méthode qui crypte mon mot de passe ( librairie)
        return new BCryptPasswordEncoder();
    }
    // creation du gestionnaire d'authentification
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }
}
