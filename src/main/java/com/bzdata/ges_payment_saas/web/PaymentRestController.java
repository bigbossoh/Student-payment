package com.bzdata.ges_payment_saas.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bzdata.ges_payment_saas.entities.Payment;
import com.bzdata.ges_payment_saas.entities.PaymentStatus;
import com.bzdata.ges_payment_saas.entities.PaymentType;
import com.bzdata.ges_payment_saas.services.PaymentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class PaymentRestController {

    private final PaymentService paymentService;

    @GetMapping(path = "/payments")
    public List<Payment> allPayment() {

        return paymentService.getAllPayments();
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id) {

        return paymentService.getPaymentById(id);
    }

    @GetMapping(path = "/paymentByStatus/{status}")
    public List<Payment> getAllPaymentByStatus(@RequestParam PaymentStatus status) {

        return paymentService.getPaymentByStatus(status);
    }

    @GetMapping(path = "/paymentBytypePayment/{type}")
    public List<Payment> getAllPaymentByTypePayment(@RequestParam PaymentType type) {

        return paymentService.getPaymentByTypePayment(type);
    }
    @GetMapping(path = "/GetDocOfPayment/{id}",produces=MediaType.APPLICATION_PDF_VALUE)
    public byte[] getDocOfPayment(@PathVariable Long id) throws IOException {

        return paymentService.getDocofpayment(id);
    }

    @PutMapping(path = "/paymentUpdate/{Id}")
    public Payment UpdatePaymentByStatus(@RequestParam PaymentStatus status,@PathVariable Long Id){
        return paymentService.updatePaymentStatus(status,Id);
    }
    @PostMapping(path="/CreatePayment",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment createNewPayment(@RequestParam MultipartFile file, int amount, PaymentType type,
    LocalDate date, String studentCode) throws IOException{
        return paymentService.savePayment(file, amount, type, date, studentCode);
    }

}
