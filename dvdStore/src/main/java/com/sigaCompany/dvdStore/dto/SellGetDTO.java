package com.sigaCompany.dvdStore.dto;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.services.SellServiceModel;
import lombok.Data;

@Data
public class SellGetDTO {
    private int id;
    private ClientEntity client;
    private DvdEntity dvd;
    private int quantity;

    public SellGetDTO(SellServiceModel sellServiceModel) {
        this.id = sellServiceModel.getId();
        this.client = sellServiceModel.getClient();
        this.dvd = sellServiceModel.getDvd();
        this.quantity = sellServiceModel.getQuantity();
    }
}
