package com.demo.uMed.controller;

import com.demo.uMed.modules.Medicine;
import com.demo.uMed.repo.MedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/meds")
public class MedController {

    @Autowired
    private MedRepo medRepo;

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMeds() {
        List<Medicine> medicineList = medRepo.findAll();
        if (medicineList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicineList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedById(@PathVariable Long id) {
        return medRepo.findById(id)
                .map(med -> new ResponseEntity<>(med, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Medicine> addMed(@RequestBody Medicine medicine) {
        Medicine savedMedicine = medRepo.save(medicine);
        return new ResponseEntity<>(savedMedicine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedById(@PathVariable Long id, @RequestBody Medicine newMedicineData) {
        return medRepo.findById(id).map(existingMed -> {
            existingMed.setNom(newMedicineData.getNom());
            existingMed.setType(newMedicineData.getType());
            existingMed.setPrix(newMedicineData.getPrix());
            existingMed.setImageUrl(newMedicineData.getImageUrl());
            Medicine updatedMed = medRepo.save(existingMed);
            return new ResponseEntity<>(updatedMed, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMedById(@PathVariable Long id) {
        return medRepo.findById(id).map(med -> {
            medRepo.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
