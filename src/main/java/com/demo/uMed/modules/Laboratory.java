package com.demo.uMed.modules;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Laboratories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
