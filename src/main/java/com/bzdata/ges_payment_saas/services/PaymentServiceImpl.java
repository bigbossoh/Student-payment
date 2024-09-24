package com.bzdata.ges_payment_saas.services;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bzdata.ges_payment_saas.entities.Payment;
import com.bzdata.ges_payment_saas.entities.PaymentStatus;
import com.bzdata.ges_payment_saas.entities.PaymentType;
import com.bzdata.ges_payment_saas.entities.Student;
import com.bzdata.ges_payment_saas.repositories.PaymentRepository;
import com.bzdata.ges_payment_saas.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> findByStudentCode(String code) {
        return paymentRepository.findByStudentCode(code);
    }

    @Override
    public List<Payment> getPaymentByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public List<Payment> getAllPaymentByStudentCode(String code) {
        List<Payment> allPayment = paymentRepository.findAll();
        return allPayment.stream()
                .filter(payment -> payment.getStudent() != null && payment.getStudent().getCode().equals(code)) // Comparer avec le code fourni
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> getPaymentByTypePayment(PaymentType type) {
        return paymentRepository.findByTypePayment(type);
    }

    @Override
    public Payment updatePaymentStatus(PaymentStatus status, Long id) {

        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);

    }

    @Override
    public Payment savePayment(MultipartFile file, int amount, PaymentType type, LocalDate date,
            String studentCode) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"), "bzdata", "payments");
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"), "bzdata", "payments", fileName + ".pdf");
        Files.copy(file.getInputStream(), filePath);
        Student student = studentRepository.findByCode(studentCode);
        Payment payment = Payment.builder()
                .amount(amount)
                .datePayment(date)
                .student(student)
                .file(filePath.toUri().toString())
                .status(PaymentStatus.CREATED)
                .typePayment(type)
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public byte[] getDocofpayment(Long id) throws IOException {

        Payment payment = paymentRepository.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }

}
