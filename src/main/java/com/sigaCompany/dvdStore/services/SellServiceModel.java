package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellServiceModel {
    private long clientId;
    private long dvdId;
    private ClientEntity client;
    private DvdEntity dvd;
    private int quantity;

    public SellServiceModel(long clientId, long dvdId, int quantity) {
        this.clientId = clientId;
        this.dvdId = dvdId;
        this.quantity = quantity;
    }

    public SellServiceModel(ClientEntity client, DvdEntity dvd, int quantity) {
        this.client = client;
        this.dvd = dvd;
        this.quantity = quantity;
    }
}
