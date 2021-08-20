package com.example.homework.controller;

import com.example.homework.model.PermanentInstructor;
import com.example.homework.service.PermanentInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perInstructors")
public class PermanentInstructorController {
    private PermanentInstructorService permanentInstructorService;

    @Autowired
    public PermanentInstructorController(PermanentInstructorService permanentInstructorService) {
        this.permanentInstructorService = permanentInstructorService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PermanentInstructor>> findAll(){
        return new ResponseEntity<List<PermanentInstructor>>(permanentInstructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<PermanentInstructor> save(@RequestBody PermanentInstructor permanentInstructor){
        return new ResponseEntity<PermanentInstructor>(permanentInstructorService.save(permanentInstructor), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PermanentInstructor> findById(@PathVariable int id){
        return new ResponseEntity<PermanentInstructor>(permanentInstructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public void update(@RequestBody PermanentInstructor permanentInstructor){
        permanentInstructorService.update(permanentInstructor);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        permanentInstructorService.deleteById(id);
    }

    @DeleteMapping("/deleteByObject")
    public void deleteByObject(@RequestBody PermanentInstructor permanentInstructor){
        permanentInstructorService.deleteByObject(permanentInstructor);
    }


}
