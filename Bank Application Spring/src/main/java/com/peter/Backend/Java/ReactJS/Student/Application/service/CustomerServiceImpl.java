package com.peter.Backend.Java.ReactJS.Student.Application.service;

import com.peter.Backend.Java.ReactJS.Student.Application.model.Customer;
import com.peter.Backend.Java.ReactJS.Student.Application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }
}
