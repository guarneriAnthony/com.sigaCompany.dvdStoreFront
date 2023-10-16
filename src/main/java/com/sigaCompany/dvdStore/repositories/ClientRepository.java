package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Client repository.
 */
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    ClientEntity save(ClientEntity clientEntity);

    List<ClientEntity> findAll();

    /**
     * Find by id client entity.
     *
     * @param id the id
     * @return the client entity
     */
    ClientEntity findById(long id);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<ClientEntity> findByName(String name);

    /**
     * Find by email list.
     *
     * @param email the email
     * @return the list
     */
    List<ClientEntity> findByEmail(String email);
}
