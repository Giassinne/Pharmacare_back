package com.demo.uMed.controller;

import com.demo.uMed.modules.Cart;
import com.demo.uMed.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartRepo cartRepo;

    @Autowired
    public CartController(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartRepo.save(cart);
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        Optional<Cart> cart = cartRepo.findById(id);
        return cart.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartRepo.deleteById(id);
    }
}
