package com.cpsc597.csufconnectbackend.service;

import com.cpsc597.csufconnectbackend.dto.EventDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto findEventById(String id);
    List<EventDto> getAllEvents();
    EventDto putImageUrl(String id, String url);
}
