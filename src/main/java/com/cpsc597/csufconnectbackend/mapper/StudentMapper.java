package com.cpsc597.csufconnectbackend.mapper;

import com.cpsc597.csufconnectbackend.dto.StudentDto;
import com.cpsc597.csufconnectbackend.entity.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        if (student.getPhotoURL() == null){
            return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getBirthday().format(DateTimeFormatter.ISO_DATE), "");
        }
        else {
            return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getBirthday().format(DateTimeFormatter.ISO_DATE), student.getPhotoURL());
        }
    }

    public static Student mapToStudent(StudentDto studentDto){
        LocalDate birthday = LocalDate.parse(studentDto.getBirthday().substring(0, 10));
        if (studentDto.getPhotoURL() == null){
            return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail(), birthday, "");
        }
        else {
            return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail(), birthday, studentDto.getPhotoURL());
        }
    }
}
