package com.demo.uMed.modules;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Meds")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String type;
    private double prix;

    @ManyToOne
    @JsonBackReference  // Ajoutez cette annotation pour éviter la récursion
    private Laboratory laboratory;

    private String imageUrl;

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public double getPrix() {
        return prix;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
