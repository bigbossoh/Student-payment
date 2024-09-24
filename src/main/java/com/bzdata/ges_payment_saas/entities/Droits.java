package com.bzdata.ges_payment_saas.entities;

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
public class Droits {

    @Id
    @GeneratedValue
    private int codeDroit;
    private String libelleDroit;

    @ManyToOne
    private FonctionnalitesApp fonctionnalitesApp;
}
