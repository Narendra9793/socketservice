package com.socketservice.socketservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class PingHandler{

    @GetMapping("ping")
    public ResponseEntity<?> ping(){
        return ResponseEntity.ok("This is Ping Response");
    }
}