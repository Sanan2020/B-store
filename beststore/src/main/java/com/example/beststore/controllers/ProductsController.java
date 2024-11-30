package com.example.beststore.controllers;

import com.example.beststore.models.ProductDto;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import com.example.beststore.models.Product;
import com.example.beststore.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/productsAPI")
public class ProductsController {
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    @Autowired
    private ProductsRepository repo;

    @GetMapping({"","/"})
    public String showProductList(Model model) {
        List<Product> products = repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "products/CreateProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("productDto") ProductDto productDto) {
        // บันทึกข้อมูลสินค้าโดยใช้ service
        Product product = new Product();
        product.setName(productDto.getName());
        product.setBrand(productDto.getBrand());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        /*ชื่อภาพ */
        MultipartFile file = productDto.getImageFile();
        String filename = file.getOriginalFilename();
        product.setImageFileName(filename);
        // สร้าง path สำหรับเก็บไฟล์ในโฟลเดอร์ที่กำหนด (public/images)
        //Path path = Paths.get(UPLOAD_DIR + filename);
        // คัดลอกไฟล์จาก MultipartFile ไปยังโฟลเดอร์ public/images
        //Files.copy(file.getInputStream(), path);

        repo.save(product);
        return "redirect:"; // หลังจากบันทึกเสร็จให้ redirect ไปที่หน้ารายการสินค้า
    }
}