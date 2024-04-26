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
    private String image;
    private String student_id;

    // Constructor without image data
    public EventDto(Long id, String name, String shortDescription, String Description, String category, Location location, String startDateAndTime, String endDateAndTime, String student_id) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = Description;
        this.category = category;
        this.location = location;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.image = null;
        this.student_id = student_id;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", location=" + location +
                ", startDateAndTime='" + startDateAndTime + '\'' +
                ", endDateAndTime='" + endDateAndTime + '\'' +
                ", image='" + image + '\'' +
                ", student_id='" + student_id + '\'' +
                '}';
    }
}
