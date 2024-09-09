package com.napas.demo_qrcode.service.jwt;

import com.napas.demo_qrcode.configuration.RsaKeyConfig;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Date;

@Service
public class JwsService {
    private final RsaKeyConfig rsaKeyConfig;

    public JwsService(RsaKeyConfig rsaKeyConfig) {
        this.rsaKeyConfig = rsaKeyConfig;
    }

    public String signData(String payload) throws Exception {
        // tạo nội dung jws
        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.RS256),
                new JWTClaimsSet.Builder()
                        .issueTime(new Date())
                        .claim("data", payload)
                        .build()
        );
        // ky jws
        signedJWT.sign(new RSASSASigner(rsaKeyConfig.rsaPrivateKey()));

        // trả về chuoi jws
        return signedJWT.serialize();
    }

    public String verifySignature(String jwsString) throws ParseException, JOSEException {
        // Parse the JWS string
        SignedJWT signedJWT = SignedJWT.parse(jwsString);

        // Create verifier from public key
        RSASSAVerifier verifier = new RSASSAVerifier((RSAPublicKey) rsaKeyConfig.rsaPublicKey());

        // Verify the signature and return the payload if valid
        if (signedJWT.verify(verifier)) {
            return signedJWT.getJWTClaimsSet().getStringClaim("data");
        } else {
            throw new JOSEException("Invalid signature");
        }
    }
}
