package com.bzdata.ges_payment_saas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bzdata.ges_payment_saas.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByCode(String code);

    List<Student> findByprogramId(String programId);

}
