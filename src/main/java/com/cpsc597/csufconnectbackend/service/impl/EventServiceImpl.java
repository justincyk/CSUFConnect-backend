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
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private StudentRepository studentRepository;

    @Override
    public EventDto findEventById(String id) {
        Event event = eventRepository.getReferenceById(id);
        return EventMapper.mapToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDto> eventsDto = new ArrayList<>();
        for(Event event: events){
            eventsDto.add(EventMapper.mapToEventDto(event));
        }
        return eventsDto;
    }

    @Override
    public EventDto putImageUrl(String id, String url) {
        Event event = eventRepository.getReferenceById(id);
        event.setImage(url);
        Event updatedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(updatedEvent);
    }

    @Override
    public EventDto createEvent(EventDto eventDto) {
        String id = eventDto.getStudent_id();
        Student student = studentRepository.getReferenceById(id);
        Event event = EventMapper.mapToEvent(eventDto, student);

        Event savedEvent = eventRepository.save(event);

        return EventMapper.mapToEventDto(savedEvent);
    }

}
