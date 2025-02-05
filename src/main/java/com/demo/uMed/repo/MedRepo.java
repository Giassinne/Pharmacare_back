package com.demo.uMed.repo;

import com.demo.uMed.modules.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedRepo extends JpaRepository<Medicine,Long> {
}
