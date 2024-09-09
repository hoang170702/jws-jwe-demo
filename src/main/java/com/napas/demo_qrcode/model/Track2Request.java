package com.napas.demo_qrcode.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Track2Request {
    private String cardNumber;
    private String expirationDate;
    private String serviceCode;
    private String pvv;
    private String cvv;
    private String discretionaryData;
    private String lrc;
}
