package com.cpsc597.csufconnectbackend.controller;

import com.cpsc597.csufconnectbackend.MultiPartFile.ByteArrayMultipartFile;
import com.cpsc597.csufconnectbackend.dto.EventDto;
import com.cpsc597.csufconnectbackend.dto.StudentDto;
import com.cpsc597.csufconnectbackend.entity.Event;
import com.cpsc597.csufconnectbackend.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventService eventService;

//    @PostMapping
//    public ResponseEntity<EventDto> createEvent(@RequestPart("event") EventDto eventDto,  @RequestPart(value="image", required = false) MultipartFile imageFile) throws IOException {
//        if (imageFile != null){
//            EventDto savedEvent = eventService.createEvent(eventDto, imageFile);
//            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//        } else {
//            EventDto savedEvent = eventService.createEvent(eventDto);
//            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
//        }
//    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventDto eventDto) throws IOException {
        try {
            String idToken = eventDto.getStudent_id();
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            eventDto.setStudent_id(uid);
            EventDto savedEvent = eventService.createEvent(eventDto);
            savedEvent.setStudent_id(idToken);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (FirebaseAuthException e){
            e.printStackTrace();
            String errorMessage = "Error while authenticating with Firebase: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }


}
