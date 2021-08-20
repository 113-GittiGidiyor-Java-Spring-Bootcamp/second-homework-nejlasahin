package com.example.homework.controller;

import com.example.homework.model.Course;
import com.example.homework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<List<Course>>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course){
        return new ResponseEntity<Course>(courseService.save(course), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id){
        return new ResponseEntity<Course>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public void update(@RequestBody Course course){
        courseService.update(course);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        courseService.deleteById(id);
    }

    @DeleteMapping("/deleteByObject")
    public void deleteByObject(@RequestBody Course course){
        courseService.deleteByObject(course);
    }
}
