package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.SellEntity;
import org.springframework.data.repository.CrudRepository;


public interface SellRepository extends CrudRepository<SellEntity, Long> {
    SellEntity save(SellEntity sellEntity);
    SellEntity findById(long id);

}
