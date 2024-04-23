package com.cpsc597.csufconnectbackend.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import com.cpsc597.csufconnectbackend.dto.StudentDto;
import com.cpsc597.csufconnectbackend.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

//    Build Add Student REST API
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDto studentDto){
        String idToken = studentDto.getId();
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            studentDto.setId(uid);
            StudentDto savedStudent = studentService.createStudent(studentDto);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (FirebaseAuthException e){
            e.printStackTrace();
            String errorMessage = "Error while authenticating with Firebase: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }
}
