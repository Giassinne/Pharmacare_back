package com.demo.uMed.controller;

import com.demo.uMed.modules.Pharmacie;
import com.demo.uMed.repo.PharmacieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pharmacies")
public class PharmacieController {

    private final PharmacieRepo pharmacieRepo;

    @Autowired
    public PharmacieController(PharmacieRepo pharmacieRepo) {
        this.pharmacieRepo = pharmacieRepo;
    }

    @GetMapping
    public List<Pharmacie> getAllPharmacies() {
        return pharmacieRepo.findAll();
    }

    @PostMapping
    public Pharmacie createPharmacie(@RequestBody Pharmacie pharmacie) {
        return pharmacieRepo.save(pharmacie);
    }

    @GetMapping("/{id}")
    public Pharmacie getPharmacieById(@PathVariable Long id) {
        Optional<Pharmacie> pharmacie = pharmacieRepo.findById(id);
        return pharmacie.orElse(null);
    }

    @PutMapping("/{id}")
    public Pharmacie updatePharmacie(@PathVariable Long id, @RequestBody Pharmacie pharmacie) {
        if (pharmacieRepo.existsById(id)) {
            pharmacie.setId(id);
            return pharmacieRepo.save(pharmacie);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePharmacie(@PathVariable Long id) {
        pharmacieRepo.deleteById(id);
    }
}
