package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.dto.DvdDTO;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Dvd service.
 */
@Service
public class DvdService {
    /**
     * The Dvd repository.
     */
    @Autowired
    DvdRepository dvdRepository;

    /**
     * Add boolean.
     *
     * @param dvdServiceModel the dvd service model
     * @return the boolean
     */
// Adds a new Dvd to the store
    public boolean add(DvdServiceModel dvdServiceModel) {
        DvdEntity dvdEntity = new DvdEntity(dvdServiceModel.getName(), dvdServiceModel.getType(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrice(),dvdServiceModel.getDescription(), dvdServiceModel.getImage());
        DvdEntity tempObject = dvdRepository.save(dvdEntity);
        return tempObject != null;
    }

    /**
     * Update dvd boolean.
     *
     * @param id     the id
     * @param dvdDTO the dvd dto
     * @return the boolean
     */
//Updates an existing Dvd in the store
    public boolean updateDvd(long id, DvdDTO dvdDTO) {
        Optional<DvdEntity> optionalDvdEntity = Optional.ofNullable(dvdRepository.findById(id));
        if (optionalDvdEntity.isPresent()) {
            DvdEntity dvdEntity = optionalDvdEntity.get();
            dvdEntity.setName(dvdDTO.name());
            dvdEntity.setType(dvdDTO.type());
            dvdEntity.setQuantity(dvdDTO.quantity());
            dvdEntity.setPrice(dvdDTO.price());
            dvdRepository.save(dvdEntity);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Find all list.
     *
     * @return the list
     */
//Retrieves a list of all dvds in the store
    public List<DvdServiceModel> findAll() {
        List<DvdEntity> dvdEntities = dvdRepository.findAll();
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for (DvdEntity dvd : dvdEntities) {
            dvdServiceModels.add(new DvdServiceModel(dvd.getId(), dvd.getName(), dvd.getType(), dvd.getQuantity(), dvd.getPrice(), dvd.getDescription(), dvd.getImage()));
        }
        return dvdServiceModels;
    }

    /**
     * Find by id dvd service model.
     *
     * @param id the id
     * @return the dvd service model
     */
//Retrieves a Dvd by its ID
    public DvdServiceModel findById(long id) {
        Optional<DvdEntity> dvdEntityOptional = Optional.ofNullable(dvdRepository.findById(id));
        DvdEntity dvdEntity = dvdEntityOptional.get();
        return new DvdServiceModel(dvdEntity.getId(), dvdEntity.getName(), dvdEntity.getType(), dvdEntity.getQuantity(), dvdEntity.getPrice(), dvdEntity.getDescription(), dvdEntity.getImage());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
//Deletes a Dvd by its ID
    public void deleteById(long id) {
        dvdRepository.deleteById(id);
    }

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<DvdServiceModel> findByName(String name) {
        List<DvdEntity> dvdEntities = dvdRepository.findByName(name);
        List<DvdServiceModel> dvdServiceModels = new ArrayList<>();
        for ( DvdEntity dvd : dvdEntities) {
            dvdServiceModels.add(new DvdServiceModel(dvd));
        }
        return dvdServiceModels;
    }

    /**
     * Find by type list.
     *
     * @param type the type
     * @return the list
     */
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
