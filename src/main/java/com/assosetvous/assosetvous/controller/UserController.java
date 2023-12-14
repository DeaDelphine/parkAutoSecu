package com.assosetvous.assosetvous.controller;


import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.entity.User;
import com.assosetvous.assosetvous.service.UserService;
import jakarta.xml.ws.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUser(){
       List<User> users =  userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/list/{idUser}")
    public ResponseEntity getUserbyId(@PathVariable(name= "idUser") Long idUser) {
        if(idUser == null) {
            return ResponseEntity.badRequest().body("Canot retreive user with null id");
        }
        User user1 = userService.getUserById(idUser);
        if(user1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user1);
    }




    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        //return Response(HttpResponse.OK, "User us deleted successfully"+id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
