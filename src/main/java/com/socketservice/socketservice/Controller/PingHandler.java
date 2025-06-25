package com.socketservice.socketservice.Controller;


@Restcontroller
@RequestMapping("/api/")
public class PingHandler{

    @GetMapping("/ping")
    public ResponseEntity<?> ping(){
        return ResponseEntity.ok("This is Ping Response");
    }
}