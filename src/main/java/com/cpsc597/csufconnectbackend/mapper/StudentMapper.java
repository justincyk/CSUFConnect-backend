package com.cpsc597.csufconnectbackend.mapper;

import com.cpsc597.csufconnectbackend.dto.StudentDto;
import com.cpsc597.csufconnectbackend.entity.Student;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        if (student.getPhotoURL() != null && student.getPhotoURL().equals("")){
            return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getBirthday().toString(), "");
        }
        else {
            return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getBirthday().toString(), student.getPhotoURL());
        }
    }

    public static Student mapToStudent(StudentDto studentDto){
        LocalDate birthday = LocalDate.parse(studentDto.getBirthday().substring(0, 10));
        if (studentDto.getPhotoURL() != null && studentDto.getPhotoURL().equals("")){
            return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail(), birthday, "");
        }
        else {
            return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail(), birthday, studentDto.getPhotoURL());
        }
    }
}
