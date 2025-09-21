package com.example.StudentManagementSystem.repository;

import com.example.StudentManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student, Integer> {
}
