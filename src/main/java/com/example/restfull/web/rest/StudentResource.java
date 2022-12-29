package com.example.restfull.web.rest;

import com.example.restfull.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    @GetMapping("/students/all")
    public ResponseEntity getAll(){
        Student student = new Student(1L, "Nodir", "Botirov", "1-course");
        Student student1 = new Student(2L, "Bobur", "G'ayratov", "1-course");
        Student student2 = new Student(3L, "Jabbor", "Sobirov", "1-course");

        List<Student> students = new ArrayList<>();

        students.add(student);
        students.add(student1);
        students.add(student2);

        return ResponseEntity.ok(students);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Student student = new Student(id, "Aziz", "Azizov", "1-course");
        return ResponseEntity.ok(student);
    }

    @GetMapping("students")
    public ResponseEntity getOne(@RequestParam Long id,
                                 @RequestParam String name,
                                 @RequestParam String lastName,
                                 @RequestParam String course){
        Student student = new Student(id, name, lastName, course);
        return ResponseEntity.ok(student);

    }

    @PostMapping("/students")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Student studentNew){
        Student student = new Student(1L, "Aziz", "Azizov", "1-course");
        student.setId(id);
        student.setName(studentNew.getName());
        student.setLastName(studentNew.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Malumot o'chirildi");
    }
}
