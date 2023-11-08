package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {
    Owner findByLogin(String loging);
}
