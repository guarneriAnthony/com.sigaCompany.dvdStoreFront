package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.dto.SellDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.entities.SellEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Sell service model.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellServiceModel {
    private long id;
    private long clientId;
    private long dvdId;
    private ClientEntity client;
    private DvdEntity dvd;
    private int quantity;

    /**
     * Instantiates a new Sell service model.
     *
     * @param sellDTO the sell dto
     */
    public SellServiceModel(SellDTO sellDTO) {
        this.clientId = sellDTO.clientId();
        this.dvdId = sellDTO.dvdId();
        this.quantity = sellDTO.quantity();
    }

    /**
     * Instantiates a new Sell service model.
     *
     * @param sellEntity the sell entity
     */
    public SellServiceModel(SellEntity sellEntity) {
        this.id = sellEntity.getId();
        this.client = sellEntity.getClientEntity();
        this.dvd = sellEntity.getDvdEntity();
        this.quantity = sellEntity.getQuantity();
    }
}
