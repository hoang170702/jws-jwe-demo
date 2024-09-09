package com.napas.demo_qrcode.controller;

import com.napas.demo_qrcode.model.Track2Request;
import com.napas.demo_qrcode.service.payment.PaymentProcessingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentProcessingService paymentProcessingService;

    public PaymentController(PaymentProcessingService paymentProcessingService) {
        this.paymentProcessingService = paymentProcessingService;
    }

    @PostMapping("/process")
    public String processPayment(@RequestBody Track2Request request) throws Exception {
        return paymentProcessingService.processPayment(request);
    }

    @PostMapping("/receipt")
    public String receiptData(@RequestBody String signedJweData) throws Exception {
        return paymentProcessingService.receivePayment(signedJweData);
    }
}
