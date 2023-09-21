package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DvdService {
    @Autowired
    DvdRepository dvdRepository;

    // Adds a new Dvd to the store
    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdEntity dvdEntity = new DvdEntity(dvdServiceModel);
        DvdEntity tempObject = dvdRepository.save(dvdEntity);
        return tempObject != null;
    }

    //Updates an existing Dvd in the store
    public boolean updateDvd(long id, DvdServiceModel dvdServiceModel){
        DvdEntity dvdEntity = new DvdEntity(id, dvdServiceModel);
        dvdRepository.save(dvdEntity);
        return true;
    }

    //Retrieves a list of all dvds in the store
    public List<DvdServiceModel> findAll() {
        List<DvdEntity> dvdEntities = dvdRepository.findAll();
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for (DvdEntity dvd : dvdEntities){
            dvdServiceModels.add(new DvdServiceModel(dvd.getName(), dvd.getType(), dvd.getQuantity(), dvd.getPrice(), dvd.getDescription(), dvd.getImage()));
        }
        return dvdServiceModels;
    }

    //Retrieves a Dvd by its ID
    public DvdServiceModel findById(long id) {
        DvdEntity dvdEntity = dvdRepository.findById(id);
        return new DvdServiceModel(dvdEntity);
    }

    //Deletes a Dvd by its ID
    public void deleteById(long id) {
        dvdRepository.deleteById(id);
    }

    public List<DvdServiceModel> findByName(String name) {
        List<DvdEntity> dvdEntities = dvdRepository.findByName(name);
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for ( DvdEntity dvd : dvdEntities) {
            dvdServiceModels.add(new DvdServiceModel(dvd));
        }
        return dvdServiceModels;
    }

    // Find Dvd by Type
    public List<DvdServiceModel> findByType(String type) {
        List<DvdEntity> dvdEntities = dvdRepository.findByType(type);
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for ( DvdEntity dvd : dvdEntities) {
            dvdServiceModels.add(new DvdServiceModel(dvd));
        }
        return dvdServiceModels;
    }
}
