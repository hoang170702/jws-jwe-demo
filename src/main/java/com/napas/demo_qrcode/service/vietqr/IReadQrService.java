package com.napas.demo_qrcode.service.vietqr;

import com.napas.demo_qrcode.repository.model.VietQR;

public interface IReadQrService {
    public VietQR dataVietQR(String QRString);
    public void checkKey(String id, int length, String content, String QRString, VietQR vietQR);
//    public void handleCase38(String content,  VietQR vietQR);
}
