package com.bzdata.ges_payment_saas.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bzdata.ges_payment_saas.entities.Payment;
import com.bzdata.ges_payment_saas.entities.PaymentStatus;
import com.bzdata.ges_payment_saas.entities.PaymentType;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByTypePayment(PaymentType type);

}
