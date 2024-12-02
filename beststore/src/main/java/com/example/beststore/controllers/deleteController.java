package com.example.beststore.controllers;

import com.example.beststore.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productsAPI")
public class deleteController {
    @Autowired
    private ProductsRepository repo;

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        repo.deleteById(id);
        return String.valueOf(ResponseEntity.status(HttpStatus.NO_CONTENT).body("ลบข้อมูลผู้ใช้รหัส " + id + " เรียบร้อยแล้ว"));
    }
    }
