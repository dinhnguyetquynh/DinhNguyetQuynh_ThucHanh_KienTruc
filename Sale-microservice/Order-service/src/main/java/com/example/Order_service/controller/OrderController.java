package com.example.Order_service.controller;

import com.example.Order_service.entity.Order;
import com.example.Order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    public List<Order> getAll() { return orderService.getAllOrder(); }

    @GetMapping("/{id}") public Order getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order ord) {
        return orderService.createOrder(ord);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
