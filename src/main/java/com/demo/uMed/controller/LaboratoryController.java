package com.demo.uMed.controller;

import com.demo.uMed.modules.Laboratory;
import com.demo.uMed.repo.LaboratoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laboratories")
public class LaboratoryController {

    @Autowired
    private LaboratoryRepo laboratoryRepo;

    // Get all laboratories
    @GetMapping("/getAll")
    public ResponseEntity<List<Laboratory>> getAllLaboratories() {
        List<Laboratory> laboratories = laboratoryRepo.findAll();
        if (laboratories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(laboratories, HttpStatus.OK);
    }

    // Get laboratory by ID
    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLaboratoryById(@PathVariable("id") Long id) {
        Optional<Laboratory> laboratory = laboratoryRepo.findById(id);
        return laboratory.map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new laboratory
    @PostMapping("/create")
    public ResponseEntity<Laboratory> createLaboratory(@RequestBody Laboratory laboratory) {
        try {
            Laboratory savedLaboratory = laboratoryRepo.save(laboratory);
            return new ResponseEntity<>(savedLaboratory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Update an existing laboratory
    @PutMapping("/update/{id}")
    public ResponseEntity<Laboratory> updateLaboratory(@PathVariable("id") Long id, @RequestBody Laboratory laboratory) {
        Optional<Laboratory> existingLaboratory = laboratoryRepo.findById(id);
        if (existingLaboratory.isPresent()) {
            laboratory.setId(id);
            Laboratory updatedLaboratory = laboratoryRepo.save(laboratory);
            return new ResponseEntity<>(updatedLaboratory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a laboratory
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteLaboratory(@PathVariable("id") Long id) {
        try {
            laboratoryRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
