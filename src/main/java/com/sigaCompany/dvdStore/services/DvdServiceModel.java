package com.sigaCompany.dvdStore.services;


import com.sigaCompany.dvdStore.dto.DvdDTO;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Dvd service model.
 */
@Data
@NoArgsConstructor
public class DvdServiceModel {
    private  Long id;
    private String name;
    private String type;
    private int quantity;
    private int price;
    private String description;
    private  String image;

    /**
     * Instantiates a new Dvd service model.
     *
     * @param dvdDTO the dvd dto
     */
    public DvdServiceModel(DvdDTO dvdDTO){
       this.name = dvdDTO.name();
       this.type = dvdDTO.type();
       this.quantity = dvdDTO.quantity();
       this.price = dvdDTO.price();
       this.description = dvdDTO.description();
       this.image = dvdDTO.image();
   }

    /**
     * Instantiates a new Dvd service model.
     *
     * @param dvdEntity the dvd entity
     */
    public DvdServiceModel(DvdEntity dvdEntity){
        this.name = dvdEntity.getName();
        this.type = dvdEntity.getType();
        this.quantity = dvdEntity.getQuantity();
        this.price = dvdEntity.getPrice();
        this.description = dvdEntity.getDescription();
        this.image = dvdEntity.getImage();
    }

    /**
     * Instantiates a new Dvd service model.
     *
     * @param id          the id
     * @param name        the name
     * @param type        the type
     * @param quantity    the quantity
     * @param price       the price
     * @param description the description
     * @param image       the image
     */
    public DvdServiceModel(Long id, String name, String type, int quantity, int price, String description, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
