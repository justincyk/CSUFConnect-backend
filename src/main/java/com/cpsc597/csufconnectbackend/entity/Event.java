package com.cpsc597.csufconnectbackend.entity;

import com.cpsc597.csufconnectbackend.dto.Location;
import jakarta.persistence.*;
import lombok.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cpsc597.csufconnectbackend.enumTypes.Category;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "event_name", nullable = false)
    private String name;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "description", nullable = false)
    private String Description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "location_address")),
            @AttributeOverride(name = "address2", column = @Column(name = "location_address2")),
            @AttributeOverride(name = "city", column = @Column(name = "location_city")),
            @AttributeOverride(name = "state", column = @Column(name = "location_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "location_zipCode"))
    })
    private Location location;

    @Column(name = "start_date_and_time", nullable = false)
    private LocalDateTime startDateAndTime;

    @Column(name = "end_date_and_time", nullable = false)
    private LocalDateTime endDateAndTime;


    @Column(name = "image")
    String image;

    public Event(Student student, String name, String shortDescription, String description, Category category, Location location,
                 LocalDateTime startDateAndTime, LocalDateTime endDateAndTime, String imageUrl) {
        this.student = student;
        this.name = name;
        this.shortDescription = shortDescription;
        this.Description = description;
        this.category = category;
        this.location = location;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.image = imageUrl;
    }

    public Event(Student student, String name, String shortDescription, String description, Category category, Location location,
                 LocalDateTime startDateAndTime, LocalDateTime endDateAndTime) {
        this.student = student;
        this.name = name;
        this.shortDescription = shortDescription;
        this.Description = description;
        this.category = category;
        this.location = location;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.image = null;
    }
}

