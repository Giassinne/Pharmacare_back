package com.demo.uMed.controller;

import com.demo.uMed.modules.CartItem;
import com.demo.uMed.repo.CartItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemRepo cartItemRepo;

    @Autowired
    public CartItemController(CartItemRepo cartItemRepo) {
        this.cartItemRepo = cartItemRepo;
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemRepo.findAll();
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    @GetMapping("/{id}")
    public CartItem getCartItemById(@PathVariable Long id) {
        Optional<CartItem> cartItem = cartItemRepo.findById(id);
        return cartItem.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemRepo.deleteById(id);
    }
}
