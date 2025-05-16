package com.demo.uMed.controller;

import com.demo.uMed.modules.Laboratory;
import com.demo.uMed.repo.LaboratoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laboratories")
public class LaboratoryController {

    private final LaboratoryRepo laboratoryRepo;

    @Autowired
    public LaboratoryController(LaboratoryRepo laboratoryRepo) {
        this.laboratoryRepo = laboratoryRepo;
    }

    @GetMapping
    public List<Laboratory> getAllLaboratories() {
        return laboratoryRepo.findAll();
    }

    @PostMapping
    public Laboratory createLaboratory(@RequestBody Laboratory laboratory) {
        return laboratoryRepo.save(laboratory);
    }

    @GetMapping("/{id}")
    public Laboratory getLaboratoryById(@PathVariable Long id) {
        Optional<Laboratory> laboratory = laboratoryRepo.findById(id);
        return laboratory.orElse(null);
    }

    @PutMapping("/{id}")
    public Laboratory updateLaboratory(@PathVariable Long id, @RequestBody Laboratory laboratory) {
        laboratory.setId(id);
        return laboratoryRepo.save(laboratory);
    }

    @DeleteMapping("/{id}")
    public void deleteLaboratory(@PathVariable Long id) {
        laboratoryRepo.deleteById(id);
    }
}
