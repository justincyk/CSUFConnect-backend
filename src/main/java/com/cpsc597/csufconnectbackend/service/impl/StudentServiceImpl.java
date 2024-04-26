package com.cpsc597.csufconnectbackend.service.impl;

import com.cpsc597.csufconnectbackend.dto.StudentDto;
import com.cpsc597.csufconnectbackend.entity.Student;
import com.cpsc597.csufconnectbackend.mapper.StudentMapper;
import com.cpsc597.csufconnectbackend.repository.StudentRepository;
import com.cpsc597.csufconnectbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToStudentDto((savedStudent));
    }

    @Override
    public StudentDto getStudent(String id){
        Student student = studentRepository.getReferenceById(id);
        return StudentMapper.mapToStudentDto(student);
    }
}
