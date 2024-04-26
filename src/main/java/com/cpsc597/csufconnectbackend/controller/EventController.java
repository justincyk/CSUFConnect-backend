package com.cpsc597.csufconnectbackend.controller;

import com.cpsc597.csufconnectbackend.MultiPartFile.ByteArrayMultipartFile;
import com.cpsc597.csufconnectbackend.dto.EventDto;
import com.cpsc597.csufconnectbackend.entity.Event;
import com.cpsc597.csufconnectbackend.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) throws IOException {
        System.out.println(eventDto.toString());
        EventDto savedEvent = eventService.createEvent(eventDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);

    }


}
