package com.example.homework.controller;

import com.example.homework.model.PermanentInstructor;
import com.example.homework.model.VisitingResearcher;
import com.example.homework.service.VisitingResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visResearchers")
public class VisitingResearcherController {
    private VisitingResearcherService visitingResearcherService;

    @Autowired
    public VisitingResearcherController(VisitingResearcherService visitingResearcherService) {
        this.visitingResearcherService = visitingResearcherService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<VisitingResearcher>> findAll(){
        return new ResponseEntity<List<VisitingResearcher>>(visitingResearcherService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<VisitingResearcher> save(@RequestBody VisitingResearcher visitingResearcher){
        return new ResponseEntity<VisitingResearcher>(visitingResearcherService.save(visitingResearcher), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<VisitingResearcher> findById(@PathVariable int id){
        return new ResponseEntity<VisitingResearcher>(visitingResearcherService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public void update(@RequestBody VisitingResearcher visitingResearcher){
        visitingResearcherService.update(visitingResearcher);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
        visitingResearcherService.deleteById(id);
    }

    @DeleteMapping("/deleteByObject")
    public void deleteByObject(@RequestBody VisitingResearcher visitingResearcher){
        visitingResearcherService.deleteByObject(visitingResearcher);
    }
}
