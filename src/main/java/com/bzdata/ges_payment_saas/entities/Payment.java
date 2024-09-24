package com.bzdata.ges_payment_saas.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Payment {

    @Id
    @GeneratedValue
    private Long idPayment;
    private LocalDate datePayment;
    private int amount;
    private String file;
    private PaymentStatus status;
    private PaymentType typePayment;
    @ManyToOne
    private Student student;

}
