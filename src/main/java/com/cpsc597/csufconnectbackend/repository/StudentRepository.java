package com.cpsc597.csufconnectbackend.repository;

import com.cpsc597.csufconnectbackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}
