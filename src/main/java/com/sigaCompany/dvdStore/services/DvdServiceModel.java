package com.sigaCompany.dvdStore.services;


import com.sigaCompany.dvdStore.controllers.DvdDTO;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DvdServiceModel {
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


}
