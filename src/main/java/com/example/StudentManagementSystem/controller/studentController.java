package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.Entity.Student;
import com.example.StudentManagementSystem.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class studentController {
    @Autowired
    studentRepository repo;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    @GetMapping("/student{id}")
    public Student getStudent(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);
        Student data = student.get();
        return data;
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        repo.save(student);
        return student;
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id) {
        Student studentt = repo.findById(id).get();
        studentt.setBranch("Computers");
        repo.save(studentt);
        return studentt;
    }

    @DeleteMapping("/student/delete/{id}")
    public void removeStudent(@PathVariable int id)
    {
        Student studdent=repo.findById(id).get();
        repo.delete(studdent);

    }


}
