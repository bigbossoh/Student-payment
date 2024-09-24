package com.bzdata.ges_payment_saas.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bzdata.ges_payment_saas.entities.Payment;
import com.bzdata.ges_payment_saas.entities.Student;
import com.bzdata.ges_payment_saas.services.PaymentService;
import com.bzdata.ges_payment_saas.services.StudentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentRestControlleur {

    private final StudentService studentService;
    private final PaymentService paymentService;

    @GetMapping(path = "/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "students/{code}")
    public Student getStudentByCode(@PathVariable String code) {
        return studentService.getStudentByCode(code);
    }

    @GetMapping(path = "/payments/{code}/student")
    public List<Payment> GetListePaymentByStudent(@PathVariable String code) {
        return paymentService.getAllPaymentByStudentCode(code);
    }

    @GetMapping(path = "/Students/byProgramId/{programId}")
    public List<Student> getListeStudentByProgram(@PathVariable String programId){ 
        return studentService.getListStudentByProgrramId(programId);
    }
}
