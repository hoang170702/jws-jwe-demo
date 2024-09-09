package com.napas.demo_qrcode.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SenderAddress {
    private String line1;
    private String line2;
    private String city;
    private String country_subdivision;
    private String postal_code;
    private String country;
    private String phone;
    private String email;
}
