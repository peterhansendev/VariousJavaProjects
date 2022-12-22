package com.peter.Backend.Java.ReactJS.Student.Application.service;

import com.peter.Backend.Java.ReactJS.Student.Application.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Optional<Customer> findById(int id);
    
}

