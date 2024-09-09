package com.napas.demo_qrcode.service.payment;

import com.napas.demo_qrcode.model.Track2Request;

public interface IPaymentProcessingService {
    String processPayment(Track2Request track2Request);
    String receivePayment(String signedJweData);

}
