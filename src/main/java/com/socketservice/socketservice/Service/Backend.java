package com.socketservice.socketservice.Service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.socketservice.socketservice.Models.Message;
import com.socketservice.socketservice.Models.Room;



@FeignClient(url = "http://localhost:7070", value="backend-client")
public interface Backend {

    @GetMapping("/api/auth/getrooms/{loggedUserId}")
    List<Room> getRoomsByLoggedUserId(@PathVariable Integer loggedUserId);


    @GetMapping("/api/auth/getroom/{sender}/{receiver}")
    Room getRoomsBySenderReceiver(@PathVariable Integer sender, @PathVariable Integer receiver );

    @GetMapping("/api/auth/getmessages/{roomname}")
    List<Message> getmessagesbyroom(@PathVariable String roomName);

    @PostMapping("/api/auth/savemessage")
    Message savemessage(@RequestBody Message message);

    @PostMapping("/api/auth/validate")
    ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authorization);
} 
