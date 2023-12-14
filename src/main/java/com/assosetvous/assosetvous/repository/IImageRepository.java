package com.assosetvous.assosetvous.repository;

import com.assosetvous.assosetvous.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
}
