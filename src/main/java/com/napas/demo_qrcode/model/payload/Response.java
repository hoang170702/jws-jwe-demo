package com.napas.demo_qrcode.model.payload;

import com.napas.demo_qrcode.model.Participant;
import com.napas.demo_qrcode.model.Sender;
import com.napas.demo_qrcode.model.SenderAddress;
import com.napas.demo_qrcode.model.Transaction;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
    private Transaction transaction;
    private Participant participant;
    private Sender sender;
    private SenderAddress senderAddress;
}
