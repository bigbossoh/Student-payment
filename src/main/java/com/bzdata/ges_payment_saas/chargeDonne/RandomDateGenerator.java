package com.bzdata.ges_payment_saas.chargeDonne;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateGenerator {
// Méthode pour générer une date aléatoire entre deux dates
public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
    // Convertir les dates en jours depuis l'époque (1970-01-01)
    long start = startDate.toEpochDay();
    long end = endDate.toEpochDay();

    // Générer un jour aléatoire entre les deux dates
    long randomDay = ThreadLocalRandom.current().nextLong(start, end + 1);

    // Retourner la date correspondant au jour aléatoire
    return LocalDate.ofEpochDay(randomDay);
}
}
