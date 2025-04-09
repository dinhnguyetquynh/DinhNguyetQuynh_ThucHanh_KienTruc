package com.example.Order_service.service;

import com.example.Order_service.entity.Order;
import com.example.Order_service.repositoty.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }
    public Order createOrder(Order o){
        return orderRepo.save(o);
    }

    public void deleteOrder(long id){
        try {
            orderRepo.deleteById(id);
            System.out.println("Xoa thanh cong");
        }catch(RuntimeException ex){
            throw new RuntimeException("Delete failed");
        }
    }

    public Order updateOrder(long id,Order ord){
        Order updateOrder = orderRepo.findById(id).orElseThrow(()->new RuntimeException("order not found"));
        updateOrder.setPrice(ord.getPrice());
        return orderRepo.save(updateOrder);

    }

    public Order findById(long id){
        return orderRepo.findById(id).orElseThrow(()->new RuntimeException("order not found"));
    }
}
