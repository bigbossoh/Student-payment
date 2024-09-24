package com.bzdata.ges_payment_saas.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bzdata.ges_payment_saas.entities.Payment;
import com.bzdata.ges_payment_saas.entities.PaymentStatus;
import com.bzdata.ges_payment_saas.entities.PaymentType;
import com.bzdata.ges_payment_saas.entities.Student;

@Service
public interface PaymentService {

    Payment savePayment(Payment payment);

    Payment  savePayment(MultipartFile file, int amount, PaymentType type,
    LocalDate date, String studentCode) throws IOException;

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    List<Payment> getPaymentByStatus(PaymentStatus status);

    List<Payment> getPaymentByTypePayment(PaymentType type);

    void deletePayment(Long id);

    List<Payment> findByStudentCode(String code);

    List<Payment> getAllPaymentByStudentCode(String code);

    byte[] getDocofpayment(Long id) throws IOException;

     Payment updatePaymentStatus(PaymentStatus status, Long id);
}
