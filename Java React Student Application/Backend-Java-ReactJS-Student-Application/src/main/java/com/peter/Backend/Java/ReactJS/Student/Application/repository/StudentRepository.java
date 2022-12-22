package com.peter.Backend.Java.ReactJS.Student.Application.repository;

import com.peter.Backend.Java.ReactJS.Student.Application.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
