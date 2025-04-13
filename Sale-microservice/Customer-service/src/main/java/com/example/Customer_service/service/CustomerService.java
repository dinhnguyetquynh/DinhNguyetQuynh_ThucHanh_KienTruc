package com.example.Customer_service.service;

import com.example.Customer_service.entity.Customer;
import com.example.Customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repo;

    public List<Customer> getAllCustomer(){
        return repo.findAll();
    }
    public Customer createCustomer(Customer o){
        return repo.save(o);
    }

    public String deleteCustomer(long id){
        try {
            repo.deleteById(id);
           return "Xoa thanh cong";
        }catch(RuntimeException ex){
            return "Xoa khong thanh cong";
        }
    }

    public Customer updateCustomer(long id,Customer cus){
        Customer updateCustomer = repo.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
        updateCustomer.setName(cus.getName());
        updateCustomer.setPhone(cus.getPhone());
        return repo.save(cus);

    }

    public Customer findById(long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    }

}
