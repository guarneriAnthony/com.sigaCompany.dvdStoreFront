package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.SellEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SellRepository extends CrudRepository<SellEntity, Long> {
    SellEntity save (SellEntity sellEntity);
    SellEntity findById(long id);

    List<SellEntity> findAll ();

}
