package com.assosetvous.assosetvous.dto;

import lombok.Data;
// Va faire appel aux getters et setters
@Data
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;



}
