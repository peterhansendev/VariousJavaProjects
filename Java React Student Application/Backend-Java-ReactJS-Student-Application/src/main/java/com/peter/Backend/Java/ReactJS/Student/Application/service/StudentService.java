package com.peter.Backend.Java.ReactJS.Student.Application.service;

import com.peter.Backend.Java.ReactJS.Student.Application.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
