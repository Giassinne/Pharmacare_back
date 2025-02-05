package com.demo.uMed.repo;

import com.demo.uMed.modules.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
