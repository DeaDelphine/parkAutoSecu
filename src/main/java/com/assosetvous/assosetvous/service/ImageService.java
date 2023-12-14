package com.assosetvous.assosetvous.service;

import com.assosetvous.assosetvous.entity.Image;
import com.assosetvous.assosetvous.repository.IImageRepository;
import com.assosetvous.assosetvous.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    IImageRepository imageRepository;

    //Liste de image

    public List<Image> getImages(){
        return imageRepository.findAll();
    }

    //Save
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    //get a Image
    public Image getImageByid(Long idimage) {
        return imageRepository.findById(idimage).get();
    }

    //delete a Image
    public void deleteImage(Image image){
        imageRepository.delete(image);
    }
}
