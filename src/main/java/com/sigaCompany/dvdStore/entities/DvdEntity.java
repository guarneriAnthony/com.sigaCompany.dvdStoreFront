package com.sigaCompany.dvdStore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Dvd")
public class DvdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private int quantity;
    @Column
    private int price;

    protected DvdEntity(){}
    public DvdEntity(String name, String gender, int quantity, int price) {
        this.name = name;
        this.gender = gender;
        this.quantity = quantity;
        this.price = price;
    }
}
