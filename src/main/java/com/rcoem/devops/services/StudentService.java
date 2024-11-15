package com.rcoem.devops.services;

import com.rcoem.devops.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.UUID;
// import java.util.stream.Collectors;

@Service
public class StudentService {

    private HashMap<String, Student> studentsById;
    private HashMap<String, Student> studentsByEmail;

    @PostConstruct
    public void setup() {
        studentsById = new HashMap<>();
        studentsByEmail = new HashMap<>();
    }

    // Registration with unique email check
    public String registerStudent(Student student) {
        if (studentsByEmail.containsKey(student.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        student.setStudentId(UUID.randomUUID().toString());
        studentsById.put(student.getStudentId(), student);
        studentsByEmail.put(student.getEmail(), student);
        return student.getStudentId();
    }

    // Login validation
    public Student loginStudent(String email, String password) {
        Student student = studentsByEmail.get(email);
        if (student == null || !student.getPassword().equals(password)) {
            throw new NoSuchElementException("Invalid email or password");
        }
        return student;
    }

    // Get student info by ID
    public Student getStudentById(String id) {
        Student student = studentsById.get(id);
        if (student == null) {
            throw new NoSuchElementException("Student not found");
        }
        return student;
    }

    // Update student information
    public void updateStudentInfo(String id, Student updatedInfo) {
        Student student = studentsById.get(id);
        if (student == null) {
            throw new NoSuchElementException("Student not found");
        }
        student.setName(updatedInfo.getName());
        student.setDepartment(updatedInfo.getDepartment());
        studentsById.put(id, student);
        studentsByEmail.put(student.getEmail(), student);
    }
}
