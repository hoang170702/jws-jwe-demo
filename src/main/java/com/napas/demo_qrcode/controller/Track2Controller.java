package com.napas.demo_qrcode.controller;

import com.napas.demo_qrcode.model.Track2Request;
import com.napas.demo_qrcode.service.track2.ITrack2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track2")
public class Track2Controller {
    @Autowired
    private ITrack2Service track2Service;

    @PostMapping("/gen-track2")
    public String generateTrack2(@RequestBody Track2Request track2Request) {
        return track2Service.generateTrack2Data(track2Request);
    }
}
