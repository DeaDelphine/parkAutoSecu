package com.assosetvous.assosetvous.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    //methode qui permet de créer un mail qui sera envoyer lorsque l'utilisateur s'inscrit sur notre site
    @Async
    public void sendEmail(String toEmail, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("ladedelfof@gmail.com");

        javaMailSender.send(mailMessage);
    }
    //création du mail de confirmation
    public void sendConfirmRegister(String email, String firstName, String password){
        String subject = "Confirmation de votre Inscription";
        String message = "Bonjour "+firstName+ " Merci d'avoir créer votre compte sur notre site Parkauto.\n\n Voici votre mot de passe : "+password+" ";
        sendEmail(email,subject, message);
    }
}
