package com.example.Product_service.controller;


import com.example.Product_service.entity.Product;
import com.example.Product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAll() { return service.getAll(); }
    @GetMapping("/{id}") public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product p) { return service.save(p); }



    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}

