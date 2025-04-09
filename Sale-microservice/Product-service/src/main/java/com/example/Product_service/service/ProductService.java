package com.example.Product_service.service;


import com.example.Product_service.entity.Product;
import com.example.Product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;

    public List<Product> getAll() { return repo.findAll(); }
    public Product save(Product p) { return repo.save(p); }
    public Optional<Product> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}