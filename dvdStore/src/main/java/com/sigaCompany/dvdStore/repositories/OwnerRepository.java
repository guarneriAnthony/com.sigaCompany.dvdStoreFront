package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Owner repository.
 */
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    /**
     * Find by login owner.
     *
     * @param loging the loging
     * @return the owner
     */
    Owner findByLogin(String loging);
}
