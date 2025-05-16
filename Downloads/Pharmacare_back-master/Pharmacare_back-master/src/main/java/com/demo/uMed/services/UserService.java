package com.demo.uMed.services;

import com.demo.uMed.modules.User;
import com.demo.uMed.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Méthode pour obtenir un utilisateur par son nom d'utilisateur
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // Méthode pour obtenir un utilisateur par son ID
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // Méthode pour enregistrer un nouvel utilisateur
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    // Méthode pour vérifier si un utilisateur existe
    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }
}
