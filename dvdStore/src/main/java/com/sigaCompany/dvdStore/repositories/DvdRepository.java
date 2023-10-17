package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.DvdEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Dvd repository.
 */
public interface DvdRepository extends CrudRepository<DvdEntity, Long> {
    DvdEntity save(DvdEntity dvdEntity);

    List<DvdEntity> findAll();

    /**
     * Find by id dvd entity.
     *
     * @param id the id
     * @return the dvd entity
     */
    DvdEntity findById(long id);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<DvdEntity> findByName(String name);

    /**
     * Find by type list.
     *
     * @param type the type
     * @return the list
     */
    List<DvdEntity> findByType(String type);
}
