package com.bzdata.ges_payment_saas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bzdata.ges_payment_saas.entities.Student;
import com.bzdata.ges_payment_saas.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentByCode(String code) {
        return studentRepository.findByCode(code);
    }

    @Override
    public List<Student> getListStudentByProgrramId(String code) {
        return  studentRepository.findByprogramId(code);
    }
}
