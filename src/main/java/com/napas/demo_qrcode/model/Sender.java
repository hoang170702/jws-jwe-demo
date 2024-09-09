package com.napas.demo_qrcode.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sender {
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    private String dateOfBirth;
}
