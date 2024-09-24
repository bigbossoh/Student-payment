package com.bzdata.ges_payment_saas;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bzdata.ges_payment_saas.entities.Payment;
import com.bzdata.ges_payment_saas.entities.PaymentStatus;
import com.bzdata.ges_payment_saas.entities.PaymentType;
import com.bzdata.ges_payment_saas.entities.Student;
import com.bzdata.ges_payment_saas.services.PaymentService;
import com.bzdata.ges_payment_saas.services.StudentService;

@SpringBootApplication
public class GesPaymentSaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GesPaymentSaasApplication.class, args);}
	
	
	@Bean
	CommandLineRunner commandLineRunner(StudentService studentService,PaymentService paymentService){
		return args ->{
			System.out.println("CommandLineRunner is executing...");
			studentService.saveStudent(Student.builder()
			.idStudent(UUID.randomUUID().toString())
			.firstname("Kolia")
			.lastname("BOGOU")
			.code("AA-11")
			.programId("LPCDM1")
			.build());
			studentService.saveStudent(Student.builder()
			.idStudent(UUID.randomUUID().toString())
			.firstname("Marc")
			.lastname("KONAN")
			.code("AA-12")
			.programId("LPCF1")
			.build());
			studentService.saveStudent(Student.builder()
			.idStudent(UUID.randomUUID().toString())
			.firstname("Marthe")
			.lastname("BAI")
			.code("AA-14")
			.programId("LPCF1")
			.build());
			studentService.saveStudent(Student.builder()
			.idStudent(UUID.randomUUID().toString())
			.firstname("Olier")
			.lastname("KOUASSI")
			.code("AA-15")
			.programId("LPAD1")
			.build());
			PaymentType[] type=PaymentType.values();
			Random random=new Random();
			studentService.getAllStudents().forEach(new Consumer<Student>() {
                            @Override
                            public void accept(Student student) {
                                for (int i = 0; i < 60; i++) {
                                    int index = random.nextInt(type.length);
                                    paymentService.savePayment(Payment.builder()
                                            .amount(ThreadLocalRandom.current().nextInt(1000, 3000))
                                            .datePayment(LocalDate.of(ThreadLocalRandom.current().nextInt(2023, 2025),
											 ThreadLocalRandom.current().nextInt(3, 9), 
											 ThreadLocalRandom.current().nextInt(1, 21)))
                                            .status(PaymentStatus.CREATED)
                                            .typePayment(type[index])
                                            .student(student)
                                            .build());
                                }
                            }
                        });

		};
	}
}
