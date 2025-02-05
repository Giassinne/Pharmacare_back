package com.demo.uMed.controller;

import com.demo.uMed.modules.Medicine;
import com.demo.uMed.repo.MedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meds")  // URL de base pour ce contrôleur
public class MedController {

    @Autowired
    private MedRepo medRepo;

    // Méthode pour obtenir tous les médicaments
    @GetMapping("/getAllMeds")
    public ResponseEntity<List<Medicine>> getAllMeds() {
        List<Medicine> medicineList = medRepo.findAll();

        if (medicineList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(medicineList, HttpStatus.OK); // 200 OK
        }
    }

    // Méthode pour obtenir un médicament par son ID
    @GetMapping("/getMedById/{id}")
    public ResponseEntity<Medicine> getMedById(@PathVariable Long id) {
        Optional<Medicine> medData = medRepo.findById(id);

        if (medData.isPresent()) {
            return new ResponseEntity<>(medData.get(), HttpStatus.OK); // 200 OK
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // Méthode pour ajouter un médicament
    @PostMapping("/addMed")
    public ResponseEntity<Medicine> addMed(@RequestBody Medicine medicine) {
        Medicine savedMedicine = medRepo.save(medicine);
        return new ResponseEntity<>(savedMedicine, HttpStatus.CREATED); // 201 Created
    }

    // Méthode pour mettre à jour un médicament par son ID
    @PutMapping("/updateMedById/{id}")
    public ResponseEntity<Medicine> updateMedById(@PathVariable Long id, @RequestBody Medicine newMedicineData) {
        Optional<Medicine> oldMedData = medRepo.findById(id);
        if (oldMedData.isPresent()) {
            Medicine updatedMedicineData = oldMedData.get();
            updatedMedicineData.setNom(newMedicineData.getNom());
            updatedMedicineData.setType(newMedicineData.getType());
            updatedMedicineData.setPrix(newMedicineData.getPrix());
            updatedMedicineData.setImageUrl(newMedicineData.getImageUrl());

            Medicine updatedMedicine = medRepo.save(updatedMedicineData);
            return new ResponseEntity<>(updatedMedicine, HttpStatus.OK); // 200 OK
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    // Méthode pour supprimer un médicament par son ID
    @DeleteMapping("/deleteMedById/{id}")
    public ResponseEntity<HttpStatus> deleteMedById(@PathVariable Long id) {
        Optional<Medicine> existingMed = medRepo.findById(id);
        if (existingMed.isPresent()) {
            medRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }
}
