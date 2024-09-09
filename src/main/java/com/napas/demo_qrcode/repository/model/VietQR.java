package com.napas.demo_qrcode.repository.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VietQR {

    private Long id;


    private String payloadFormatIndicator;


    private String pointOfInitiationMethod;


    private String visa;


    private String masterCard;


    private String EMVCo;


    private String discover;


    private String amex;


    private String jcb;


    private String unionPay;


    private String merchantAccountInformation;


    private String merchantCategoryCode;


    private String transactionCurrency;


    private String transactionAmount;


    private String tipOrConvenienceIndicator;


    private String valueOfConvenienceFeeFixed;


    private String valueOfConvenienceFeePercentage;


    private String countryCode;


    private String merchantName;


    private String merchantCity;


    private String postalCode;


    private String additionalDataFieldTemplate;


    private String merchantInformationLanguageTemplate;


    private String rfuForEMVCo;


    private String unreservedTemplates;


    private String crc;


    private String guid;


    private String acquierIdBnbId;


    private String merchantIdConsumerId;


    private String serviceId;

    private String billNumber;
    private String mobilePhone;
    private String storeLable;
    private String loyaltyNumber;
    private String referenceLable;
    private String customerLable;
    private String teminalLable;
    private String purpose;

}
