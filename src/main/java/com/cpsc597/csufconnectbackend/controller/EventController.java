package com.cpsc597.csufconnectbackend.controller;

import com.cpsc597.csufconnectbackend.dto.EventDto;
import com.cpsc597.csufconnectbackend.entity.Event;
import com.cpsc597.csufconnectbackend.service.EventService;
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

    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestPart("event") EventDto eventDto, @RequestPart("image") MultipartFile imageFile) throws IOException {

        EventDto savedEvent = eventService.createEvent(eventDto, imageFile);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }
}
