package com.example.question2_student_api.controller;

import com.example.question2_student_api.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // 5 SAMPLE STUDENTS
    public StudentController() {
        students.add(new Student(1L, "Alice", "Smith",
                "alice@example.com", "Computer Science", 3.8));
        students.add(new Student(2L, "Bob", "Brown",
                "bob@example.com", "Information Technology", 3.2));
        students.add(new Student(3L, "Carol", "Jones",
                "carol@example.com", "Computer Science", 3.5));
        students.add(new Student(4L, "David", "White",
                "david@example.com", "Business", 2.9));
        students.add(new Student(5L, "Eva", "Green",
                "eva@example.com", "Computer Science", 3.9));
    }

    // GET /api/students
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    // GET /api/students/{studentId}
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // GET /api/students/major/{major}
    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student);
            }
        }
        return result;
    }

    // GET /api/students/filter?gpa=3.5
    @GetMapping("/filter")
    public List<Student> filterByGpa(@RequestParam Double gpa) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGpa() >= gpa) {
                result.add(student);
            }
        }
        return result;
    }

    // POST /api/students
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // PUT /api/students/{studentId}
    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId,
            @RequestBody Student updatedStudent) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setEmail(updatedStudent.getEmail());
                student.setMajor(updatedStudent.getMajor());
                student.setGpa(updatedStudent.getGpa());
                return student;
            }
        }
        return null;
    }
}
