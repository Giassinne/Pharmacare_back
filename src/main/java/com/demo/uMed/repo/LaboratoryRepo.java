package com.demo.uMed.repo;

import com.demo.uMed.modules.CartItem;
import com.demo.uMed.modules.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepo extends JpaRepository<Laboratory, Long> {
}
