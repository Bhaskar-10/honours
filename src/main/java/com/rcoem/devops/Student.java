package com.rcoem.devops;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Student {
    private String studentId;
    private String name;
    private String email;
    private String password; // For login purposes
    private String department;
}
