package com.assosetvous.assosetvous.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token;
    //Rafraichir mon token
    private String refreshToken;


}
