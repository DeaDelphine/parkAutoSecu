package com.assosetvous.assosetvous.service.impl;

import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.exception.EmailNotFoundException;
import com.assosetvous.assosetvous.repository.IUserRepository;
import com.assosetvous.assosetvous.service.EmailService;
import com.assosetvous.assosetvous.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;
    @Autowired
    private EmailService emailService;

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, EmailService emailService){

        this.userRepository = userRepository;
        this.emailService = emailService;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long idUser) {
        return userRepository.findById(idUser).get();
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    // Methode qui permet de réinitialiser le mot de passe de l'utilisateur
    @Override
    public void resetPassword(String email) throws EmailNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user == null){
            throw new EmailNotFoundException("No user Found by Email");
        }
        String link = "Url vers API";
        LOGGER.info("lien "+link);
        emailService.sendResetPassword(user.get().getEmail(), user.get().getFirstName(), link);
    }
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User is not found")
                        );
            }
        };
    }
}
