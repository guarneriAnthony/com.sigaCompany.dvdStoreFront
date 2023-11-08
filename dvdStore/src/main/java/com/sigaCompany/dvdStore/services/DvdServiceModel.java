package com.sigaCompany.dvdStore.services;


import com.sigaCompany.dvdStore.dto.DvdDTO;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdServiceModel {
    private  int id;
    private String name;
    private String type;
    private int quantity;
    private int price;
    private String description;
    private  String image;

    public DvdServiceModel(DvdDTO dvdDTO){
       this.name = dvdDTO.name();
       this.type = dvdDTO.type();
       this.quantity = dvdDTO.quantity();
       this.price = dvdDTO.price();
       this.description = dvdDTO.description();
       this.image = dvdDTO.image();
   }

    public DvdServiceModel(DvdEntity dvdEntity){
        this.name = dvdEntity.getName();
        this.type = dvdEntity.getType();
        this.quantity = dvdEntity.getQuantity();
        this.price = dvdEntity.getPrice();
        this.description = dvdEntity.getDescription();
        this.image = dvdEntity.getImage();
    }

    public DvdServiceModel(int id, String name, String type, int quantity, int price, String description, String image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
