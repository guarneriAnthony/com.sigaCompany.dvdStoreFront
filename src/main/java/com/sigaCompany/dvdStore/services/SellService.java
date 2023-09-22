package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.entities.SellEntity;
import com.sigaCompany.dvdStore.repositories.ClientRepository;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import com.sigaCompany.dvdStore.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellService {
    @Autowired
    SellRepository sellRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DvdRepository dvdRepository;


    public void save(SellServiceModel sellServiceModel) {
        long clientID = sellServiceModel.getClientId();
        long dvdID = sellServiceModel.getDvdId();
        int quantity = sellServiceModel.getQuantity();

        ClientEntity clientEntity = clientRepository.findById(clientID);
        DvdEntity dvdEntity = dvdRepository.findById(dvdID);

        SellEntity sellEntity = new SellEntity(clientEntity, dvdEntity, quantity);

        sellRepository.save(sellEntity);
    }
}