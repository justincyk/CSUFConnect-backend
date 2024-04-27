package com.cpsc597.csufconnectbackend.service;

import com.cpsc597.csufconnectbackend.dto.EventDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto) throws IOException;
    EventDto createEvent(EventDto eventDto, MultipartFile imageFile) throws IOException;
    EventDto findEventById(String id);
    List<EventDto> getAllEvents();
}
