package com.cpsc597.csufconnectbackend.service.impl;

import com.cpsc597.csufconnectbackend.dto.EventDto;
import com.cpsc597.csufconnectbackend.entity.Event;
import com.cpsc597.csufconnectbackend.entity.Student;
import com.cpsc597.csufconnectbackend.mapper.EventMapper;
import com.cpsc597.csufconnectbackend.repository.EventRepository;
import com.cpsc597.csufconnectbackend.repository.StudentRepository;
import com.cpsc597.csufconnectbackend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private StudentRepository studentRepository;

    @Override
    public EventDto createEvent(EventDto eventDto, MultipartFile imageFile) throws IOException {
        String id = eventDto.getStudent_id();
        Student student = studentRepository.getReferenceById(id);
        Event event = EventMapper.mapToEvent(eventDto, student, imageFile);

        Event savedEvent = eventRepository.save(event);

        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public EventDto createEvent(EventDto eventDto) throws IOException {
        String id = eventDto.getStudent_id();
        Student student = studentRepository.getReferenceById(id);
        Event event = EventMapper.mapToEvent(eventDto, student);

        Event savedEvent = eventRepository.save(event);

        return EventMapper.mapToEventDto(savedEvent);
    }
}
