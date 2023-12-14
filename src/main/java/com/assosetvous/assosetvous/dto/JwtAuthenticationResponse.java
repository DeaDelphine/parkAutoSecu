package com.assosetvous.assosetvous.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    //Rafraichir mon token
    private String refreshToken;
    private String email;
    private String firstName;
    private String lastName;


}
