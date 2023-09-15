package com.sigaCompany.dvdStore.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Data
@Table(name = "Dvd")
public class DvdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @OneToMany(mappedBy = "DvdEntity")
//    private Set<SellEntity> sellEntities = new HashSet<>();

    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private int quantity;
    @Column
    private int price;

    public DvdEntity(String name, String gender, int quantity, int price) {
        this.name = name;
        this.gender = gender;
        this.quantity = quantity;
        this.price = price;
    }public DvdEntity(Long id, String name, String gender, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.quantity = quantity;
        this.price = price;
    }
}
