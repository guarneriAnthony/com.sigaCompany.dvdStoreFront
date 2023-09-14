package com.sigaCompany.dvdStore.services;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DvdServiceModel {
    private String name;
    private String gender;
    private int quantity;
    private int price;

}
