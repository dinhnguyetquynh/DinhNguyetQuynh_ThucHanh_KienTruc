package com.example.Customer_service.controller;

import com.example.Customer_service.entity.Customer;
import com.example.Customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping
    public List<Customer> getAll() { return customerService.getAllCustomer(); }

    @GetMapping("/{id}") public Customer getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer cus) {
        return customerService.createCustomer(cus);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
