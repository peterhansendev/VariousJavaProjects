package com.peter.Backend.Java.ReactJS.Student.Application.repository;

import com.peter.Backend.Java.ReactJS.Student.Application.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}