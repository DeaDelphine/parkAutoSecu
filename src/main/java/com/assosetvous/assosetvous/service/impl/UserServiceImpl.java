package com.assosetvous.assosetvous.service.impl;

import com.assosetvous.assosetvous.repository.IUserRepository;
import com.assosetvous.assosetvous.service.EmailService;
import com.assosetvous.assosetvous.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;
    @Autowired
    private EmailService emailService;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, EmailService emailService){

        this.userRepository = userRepository;
        this.emailService = emailService;
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
