package com.napas.demo_qrcode.service.jwt;

import com.napas.demo_qrcode.configuration.RsaKeyConfig;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service
public class JweService {

    private final RsaKeyConfig rsaKeyConfig;

    public JweService(RsaKeyConfig rsaKeyConfig) {
        this.rsaKeyConfig = rsaKeyConfig;
    }

    public String encryptData(String data) throws Exception {
        // tạo nội dung jwe
        JWEObject jweObject = new JWEObject(
                new JWEHeader(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128GCM),
                new Payload(data)
        );

        // mã hoá jwe
        jweObject.encrypt(new RSAEncrypter(rsaKeyConfig.rsaPublicKey()));

        // trả về chuỗi jwe
        return jweObject.serialize();
    }

    public String decryptData(String jweString) throws Exception {
        // Parse the JWE string
        JWEObject jweObject = JWEObject.parse(jweString);

        // Giải mã JWE bằng private key
        jweObject.decrypt(new RSADecrypter((RSAPrivateKey) rsaKeyConfig.rsaPrivateKey()));

        // Lấy và trả về payload sau khi giải mã
        return jweObject.getPayload().toString();
    }
}
