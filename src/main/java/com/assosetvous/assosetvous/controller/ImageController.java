package com.assosetvous.assosetvous.controller;

import com.assosetvous.assosetvous.entity.Image;
import com.assosetvous.assosetvous.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/image2")
    public Image createimage(@Validated @RequestBody(required = false) Image image) {
        return imageService.saveImage(image);
    }

    @GetMapping("/images2")
    public List<Image> getAllimage() {
        return imageService.getImages();
    }

    @GetMapping("/images2/{idimage}")
    public ResponseEntity getimagebyId(@PathVariable(name= "idimage") Long idimage) {
        if(idimage == null) {
            return ResponseEntity.badRequest().body("Canot retreive image with null id");
        }
        Image images1 = imageService.getImageByid(idimage);
        if(images1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(images1);
    }

    @DeleteMapping("/images2/{idimage}")
    public ResponseEntity<Image> deleteimage(@Validated @PathVariable(name= "idimage") Long idimage) {

        Image images1 = imageService.getImageByid(idimage);
        if(images1 == null) {
            return ResponseEntity.notFound().build();
        }
        imageService.deleteImage(images1);
        return ResponseEntity.ok().body(images1);
    }
}
