package com.example.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    SenderService senderService;

    @GetMapping(path = "/sendpayload")
    public ResponseEntity sendPayload(@RequestParam("payload") String payload){
        senderService.sendPayloadToRabbit(payload);
        return ResponseEntity.ok().body("send payload -> " + payload);
    }
}
