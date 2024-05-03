package com.cpsc597.csufconnectbackend.mapper;

import com.cpsc597.csufconnectbackend.dto.EventDto;
import com.cpsc597.csufconnectbackend.entity.Event;
import com.cpsc597.csufconnectbackend.entity.Student;
import com.cpsc597.csufconnectbackend.enumTypes.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class EventMapper {
    public static EventDto mapToEventDto(Event event) {
        EventDto eventDto = new EventDto(
                event.getId(),
                event.getName(),
                event.getShortDescription(),
                event.getDescription(),
                event.getCategory().getValue(),
                event.getLocation(),
                event.getStartDateAndTime().format(DateTimeFormatter.ISO_DATE_TIME),
                event.getEndDateAndTime().format(DateTimeFormatter.ISO_DATE_TIME),
                event.getImage(),
                event.getStudent().getId()
        );

        return eventDto;
    }


    public static Event mapToEvent(EventDto eventDto, Student student) {
        Event event = new Event(
                student,
                eventDto.getName(),
                eventDto.getShortDescription(),
                eventDto.getDescription(),
                Category.fromString(eventDto.getCategory()),
                eventDto.getLocation(),
                LocalDateTime.parse(eventDto.getStartDateAndTime(), DateTimeFormatter.ISO_DATE_TIME),
                LocalDateTime.parse(eventDto.getEndDateAndTime(), DateTimeFormatter.ISO_DATE_TIME)
        );

        return event;
    }
}
