package com.demo.uMed.modules;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CartItem")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    private int quantity;
}
