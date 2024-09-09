package com.napas.demo_qrcode.controller;

import com.napas.demo_qrcode.repository.model.VietQR;
import com.napas.demo_qrcode.service.vietqr.IReadQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viet-qr")
public class ReadQrController {
    @Autowired
    private IReadQrService iReadQrService;
    @PostMapping("/save-qrdata")
    public ResponseEntity<VietQR> saveQRData(@RequestBody String QRString) {
        return  ResponseEntity.status(HttpStatus.OK).body(this.iReadQrService.dataVietQR(QRString));
    }
}
