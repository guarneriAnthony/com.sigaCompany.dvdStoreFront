package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.dto.SellDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.entities.SellEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellServiceModel {
    private int id;
    private int clientId;
    private int dvdId;
    private ClientEntity client;
    private DvdEntity dvd;
    private int quantity;

    public SellServiceModel(SellDTO sellDTO) {
        this.clientId = sellDTO.clientId();
        this.dvdId = sellDTO.dvdId();
        this.quantity = sellDTO.quantity();
    }

    public SellServiceModel(SellEntity sellEntity) {
        this.id = sellEntity.getId();
        this.client = sellEntity.getClientEntity();
        this.dvd = sellEntity.getDvdEntity();
        this.quantity = sellEntity.getQuantity();
    }
}
