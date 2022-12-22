package com.peter.Backend.Java.ReactJS.Student.Application.controller;

import com.peter.Backend.Java.ReactJS.Student.Application.model.Customer;
import com.peter.Backend.Java.ReactJS.Student.Application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String add(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return "New customer is added";
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/id/{id}")
    public Optional<Customer> findById(@PathVariable int id) {
        return customerService.findById(id);
    }
    /*
     * @PutMapping("/withdraw")
     * public void withdraw(double amount) {
     * balance = balance - amount;
     * System.out.println("Withdrawing $" + amount);
     * printBalance();
     * }
     */

}
