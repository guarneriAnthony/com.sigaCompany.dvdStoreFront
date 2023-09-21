package com.sigaCompany.dvdStore.entities;

import com.sigaCompany.dvdStore.services.DvdServiceModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Entity
@Data
@Table(name = "Dvd")
public class DvdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "dvdEntity")
    private Set<SellEntity> sellEntities = new HashSet<>();

    @Column
    private String name;
    @Column
    private String type;
    @Column
    private int quantity;
    @Column
    private int price;
    @Column
    private String description;
    @Column
    private String image;


    public DvdEntity (DvdServiceModel dvd){
        name = dvd.getName();
        type = dvd.getType();
        quantity = dvd.getQuantity();
        price = dvd.getPrice();
        description = dvd.getDescription();
        image = dvd.getImage();
    }

    public DvdEntity (long id,DvdServiceModel dvd){
        this.id = id;
        name = dvd.getName();
        type = dvd.getType();
        quantity = dvd.getQuantity();
        price = dvd.getPrice();
        description = dvd.getDescription();
        image = dvd.getImage();
    }
}
