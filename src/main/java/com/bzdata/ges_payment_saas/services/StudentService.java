package com.bzdata.ges_payment_saas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bzdata.ges_payment_saas.entities.Student;
@Service
public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student getStudentByCode(String code);
    List<Student> getListStudentByProgrramId(String code);
    void deleteStudent(String id);
}