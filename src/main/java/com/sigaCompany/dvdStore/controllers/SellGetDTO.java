package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import lombok.Data;

@Data
public class SellGetDTO {
    private ClientEntity client;
    private DvdEntity dvd;
    private int quantity;

    public SellGetDTO(ClientEntity client, DvdEntity dvd, int quantity) {
        this.client = client;
        this.dvd = dvd;
        this.quantity = quantity;
    }
}
