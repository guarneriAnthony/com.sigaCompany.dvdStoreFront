package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.services.SellServiceModel;
import lombok.Data;

/**
 * The type Sell get dto.
 */
@Data
public class SellGetDTO {
    private long id;
    private ClientEntity client;
    private DvdEntity dvd;
    private int quantity;

    /**
     * Instantiates a new Sell get dto.
     *
     * @param sellServiceModel the sell service model
     */
    public SellGetDTO(SellServiceModel sellServiceModel) {
        this.id = sellServiceModel.getId();
        this.client = sellServiceModel.getClient();
        this.dvd = sellServiceModel.getDvd();
        this.quantity = sellServiceModel.getQuantity();
    }
}
