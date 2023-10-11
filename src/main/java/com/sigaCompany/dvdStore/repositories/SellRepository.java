package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.SellEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * The interface Sell repository.
 */
public interface SellRepository extends CrudRepository<SellEntity, Long> {
    SellEntity save (SellEntity sellEntity);

    /**
     * Find by id sell entity.
     *
     * @param id the id
     * @return the sell entity
     */
    SellEntity findById(long id);

    List<SellEntity> findAll ();

}
