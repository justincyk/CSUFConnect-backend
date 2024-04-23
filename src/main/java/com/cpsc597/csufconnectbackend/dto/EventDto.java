package com.cpsc597.csufconnectbackend.dto;

import com.cpsc597.csufconnectbackend.enumTypes.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    private String shortDescription;
    private String description;
    private String category;
    private Location location;
    private String startDateAndTime;
    private String endDateAndTime;
    private String image; // Change the type to String for base64-encoded image data

    // Constructor without image data
    public EventDto(Long id, String name, String shortDescription, String Description, String category, Location location, String startDateAndTime, String endDateAndTime) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = Description;
        this.category = category;
        this.location = location;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
    }
}