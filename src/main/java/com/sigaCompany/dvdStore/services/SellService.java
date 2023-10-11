package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.entities.DvdEntity;
import com.sigaCompany.dvdStore.entities.SellEntity;
import com.sigaCompany.dvdStore.repositories.ClientRepository;
import com.sigaCompany.dvdStore.repositories.DvdRepository;
import com.sigaCompany.dvdStore.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Sell service.
 */
@Service
public class SellService {
    /**
     * The Sell repository.
     */
    @Autowired
    SellRepository sellRepository;

    /**
     * The Client repository.
     */
    @Autowired
    ClientRepository clientRepository;

    /**
     * The Dvd repository.
     */
    @Autowired
    DvdRepository dvdRepository;


    /**
     * Save.
     *
     * @param sellServiceModel the sell service model
     */
    public void save(SellServiceModel sellServiceModel) {
        long clientID = sellServiceModel.getClientId();
        long dvdID = sellServiceModel.getDvdId();
        int quantity = sellServiceModel.getQuantity();

        ClientEntity clientEntity = clientRepository.findById(clientID);
        DvdEntity dvdEntity = dvdRepository.findById(dvdID);

        SellEntity sellEntity = new SellEntity(clientEntity, dvdEntity, quantity);
        sellRepository.save(sellEntity);
    }

    /**
     * Find by id sell service model.
     *
     * @param id the id
     * @return the sell service model
     */
    public SellServiceModel findById(long id) {
        SellEntity sellEntity = sellRepository.findById(id);
        return new SellServiceModel(sellEntity);
    }


    /**
     * Find all list.
     *
     * @return the list
     */
    public List<SellServiceModel> findAll() {
       List<SellEntity> sellEntities = sellRepository.findAll();
       List<SellServiceModel> sellServiceModels = new ArrayList<>();
        for (SellEntity sell : sellEntities){
          sellServiceModels.add(new SellServiceModel(sell));
        }
       return sellServiceModels;
   }
}
