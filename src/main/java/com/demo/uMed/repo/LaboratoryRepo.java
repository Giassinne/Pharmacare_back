package com.demo.uMed.repo;

import com.demo.uMed.modules.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacieRepo extends JpaRepository<Pharmacie, Long> {

}
