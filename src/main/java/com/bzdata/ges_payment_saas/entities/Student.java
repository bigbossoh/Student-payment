package com.bzdata.ges_payment_saas.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Builder
@ToString
public class Student {
    @Id
    private String idStudent;
    private String firstname;
    private String lastname;
    @Column(unique=true)
    private String code;
    private String photo;
    private String programId;
}
