package com.napas.demo_qrcode.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participant {
    private Long id;
    private String originatingInstitutionId;
    private String receivingInstitutionId;
    private String merchantId;
    private String cardAcceptorId;
    private String cardAcceptorName;
    private String cardAcceptorCity;
    private String cardAcceptorCountry;
}
