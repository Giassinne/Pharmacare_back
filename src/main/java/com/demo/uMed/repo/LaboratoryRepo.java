package com.demo.uMed.repo;

import com.demo.uMed.modules.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepo extends JpaRepository<Laboratory, Long> {

}
