package com.cpsc597.csufconnectbackend.service;

import com.cpsc597.csufconnectbackend.dto.EventDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EventService {
    EventDto createEvent(EventDto eventDto, MultipartFile imageFile) throws IOException;
}
