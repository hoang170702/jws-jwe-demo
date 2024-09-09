package com.napas.demo_qrcode.service.payment;


import com.napas.demo_qrcode.model.Track2Request;
import com.napas.demo_qrcode.service.jwt.JweService;
import com.napas.demo_qrcode.service.jwt.JwsService;
import com.napas.demo_qrcode.service.track2.ITrack2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentProcessingService implements IPaymentProcessingService {

    private final ITrack2Service track2Service;
    private final JweService jweService;
    private final JwsService jwsService;

    public PaymentProcessingService(ITrack2Service track2Service, JweService jweService, JwsService jwsService) {
        this.track2Service = track2Service;
        this.jweService = jweService;
        this.jwsService = jwsService;
    }

    @Override
    public String processPayment(Track2Request track2Request) {

        String jweData = "";
        String track2Data = "";
        try {
            // Build Track 2 data
            track2Data = track2Service.generateTrack2Data(track2Request);
            log.info("track2 data: " + track2Data);
            // Encrypt Track 2 data using JweService
            jweData = jweService.encryptData(track2Data);

            // Sign the encrypted data using JWS
            return jwsService.signData(jweData);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String receivePayment(String signedJweData) {
        String decryptedTrack2Data;
        try {
            // Step 1: Verify the JWS signature
            String verifiedJweData = jwsService.verifySignature(signedJweData);
            log.info("Verified JWE data: " + verifiedJweData);

            // Step 2: Decrypt the JWE data
            decryptedTrack2Data = jweService.decryptData(verifiedJweData);
            log.info("Decrypted Track2 data: " + decryptedTrack2Data);

            // Step 3: Process the decrypted Track2 data (e.g., parse or validate it)
            return decryptedTrack2Data;

        } catch (Exception e) {
            log.error("Error during payment processing", e);
            throw new RuntimeException("Error receiving payment", e);
        }
    }
}
