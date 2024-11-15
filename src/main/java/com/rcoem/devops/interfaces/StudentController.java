package com.rcoem.devops.interfaces;

import com.rcoem.devops.Student;
import com.rcoem.devops.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Register a new student
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        return ResponseEntity.status(201).body(studentService.registerStudent(student));
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> loginStudent(@RequestBody Student student) {
        Student loggedInStudent = studentService.loginStudent(student.getEmail(), student.getPassword());
        return ResponseEntity.ok("Login successful for student ID: " + loggedInStudent.getStudentId());
    }

    // Get student information
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Update student information
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudentInfo(@PathVariable String id, @RequestBody Student updatedInfo) {
        studentService.updateStudentInfo(id, updatedInfo);
        return ResponseEntity.ok("Student information updated successfully");
    }
}
