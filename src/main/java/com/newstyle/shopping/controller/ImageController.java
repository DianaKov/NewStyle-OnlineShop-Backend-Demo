package com.newstyle.shopping.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageController {
    
    private static final String IMAGE_DIRECTORY = "src/main/resources/static/img/";
    
    @GetMapping(value = "/images/{imageName:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get(IMAGE_DIRECTORY + imageName);
        Resource imageResource = new UrlResource(imagePath.toUri());
        if (imageResource.exists() && imageResource.isReadable()) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageResource);
        } else {
            throw new RuntimeException("Could not load image: " + imageName);
        }
    }
}
