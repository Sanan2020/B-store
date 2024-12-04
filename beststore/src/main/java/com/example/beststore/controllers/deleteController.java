package com.example.beststore.controllers;

import com.example.beststore.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productsAPI")
public class deleteController {
    @Autowired
    private ProductsRepository repo;

    @DeleteMapping("/delete")
        public String deleteProduct(@RequestParam("id") int id) {
        repo.deleteById(id);
        return "redirect:";
    }
}
