package com.napas.demo_qrcode.service.track2;

import com.napas.demo_qrcode.model.Track2Request;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Track2Service implements ITrack2Service {
    @Override
    public String generateTrack2Data(Track2Request track2Request) {
        try {
            // First character
            String firstChar = ";";

            // Field Separator
            String fs = "=";

            // End Sentinel
            String es = "?";

            // build Track 2
            StringBuilder track2Builder = new StringBuilder();
            track2Builder.append(firstChar);
            track2Builder.append(track2Request.getCardNumber());
            track2Builder.append(fs);
            track2Builder.append(track2Request.getExpirationDate());
            track2Builder.append(track2Request.getServiceCode());
            track2Builder.append(track2Request.getPvv());
            track2Builder.append(track2Request.getCvv());
            track2Builder.append(track2Request.getDiscretionaryData());
            track2Builder.append(es);
            track2Builder.append(track2Request.getLrc());

            return track2Builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error generating");
            return null;
        }
    }
}
