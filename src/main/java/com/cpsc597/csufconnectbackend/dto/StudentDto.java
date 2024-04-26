package com.cpsc597.csufconnectbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", photoURL='" + photoURL + '\'' +
                '}';
    }

    private String birthday;
    private String photoURL;

    public StudentDto(String id, String firstName, String lastName, String email, String birthday){
        this(id, firstName, lastName, email, birthday, "");
    }
}
