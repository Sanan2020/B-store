package com.example.beststore.models;

//import jakarta.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
    @com.example.beststore.models.NotEmpty(message = "The name is required")
    private String name;

    @NotEmpty(message = "The brand is required")
    private String brand;

    @NotEmpty(message = "The category is required")
    private String category;


    private double price;

//    @Size(min = 10, message = "The description should be at least 10 characters")
//    @Size(max =2000, message = "The description cannot exceed 2000 characters")
    private String description;

    private MultipartFile imageFile;
}
