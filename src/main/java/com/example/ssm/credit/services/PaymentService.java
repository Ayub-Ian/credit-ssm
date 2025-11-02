package com.example.ssm.credit.services;

import com.example.ssm.credit.domain.PaymentEvent;
import com.example.ssm.credit.domain.PaymentState;
import com.example.ssm.credit.entity.Payment;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {
    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorized(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);

}
