package com.demo.uMed.repo;

import com.demo.uMed.modules.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}
