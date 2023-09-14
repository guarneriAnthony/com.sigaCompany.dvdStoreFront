package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdService {
    @Autowired
    DvdRepository dvdRepository;
    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdEntity dvdEntity = new DvdEntity(dvdServiceModel.getName(), dvdServiceModel.getGender(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrice());
        DvdEntity tempObject = dvdRepository.save(dvdEntity);
        return tempObject != null;
    }
}
