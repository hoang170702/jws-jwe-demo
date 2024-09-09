package com.napas.demo_qrcode.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    private Long id;

    private String reference;

    private String type;

    private String generationMethod;

    private String localDateTime;

    private String mcc;

    private String service_code;

    private String amount;

    private String currency;

    private String sender_account;

    private String additionalMessage;
    private String qrstring;

}
