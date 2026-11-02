
package com.example.studentcourse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.studentcourse.model.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    private AtomicInteger counter = new AtomicInteger(1);

    // 1. Register Student
    public Student registerStudent(Student student) {

        student.setStudentId(counter.getAndIncrement());

        students.add(student);

        return student;
    }

    // 2. View All Students
    public List<Student> getAllStudents() {

        return students;
    }

    // 3. Find Student By ID
    public Optional<Student> getStudentById(int id) {

        return students.stream()
                .filter(student -> student.getStudentId() == id)
                .findFirst();
    }

    // 4. Delete Student Registration
    public boolean deleteStudent(int id) {

        return students.removeIf(
                student -> student.getStudentId() == id
        );
    }
}
