package com.example.ssm.credit.services;

import com.example.ssm.credit.domain.PaymentEvent;
import com.example.ssm.credit.domain.PaymentState;
import com.example.ssm.credit.entity.Payment;
import com.example.ssm.credit.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);

        paymentService.preAuth(savedPayment.getId());

        Payment preAuthPayment = paymentRepository.getOne(savedPayment.getId());

        System.out.println(preAuthPayment);
    }
}