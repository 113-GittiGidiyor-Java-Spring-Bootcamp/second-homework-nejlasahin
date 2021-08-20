package com.example.homework.controller;

import com.example.homework.model.Student;
import com.example.homework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping ("/findAll")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<List<Student>>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.save(student), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id){
        return new ResponseEntity<Student>(studentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        studentService.deleteById(id);
    }

    @DeleteMapping("/deleteByObject")
    public void deleteByObject(@RequestBody Student student){
        studentService.deleteByObject(student);
    }
}
