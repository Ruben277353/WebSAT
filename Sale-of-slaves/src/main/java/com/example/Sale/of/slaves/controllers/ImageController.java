package com.example.Sale.of.slaves.controllers;

import com.example.Sale.of.slaves.models.Image;
import com.example.Sale.of.slaves.repositories.ImageRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;



@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepositories imageRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImagesById(@PathVariable Long id){
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}