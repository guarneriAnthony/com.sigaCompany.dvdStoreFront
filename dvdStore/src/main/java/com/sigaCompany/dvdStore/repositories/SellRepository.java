package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.SellEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SellRepository extends CrudRepository<SellEntity, Integer> {
    SellEntity save (SellEntity sellEntity);

    SellEntity findById(int id);

    List<SellEntity> findAll ();

}
