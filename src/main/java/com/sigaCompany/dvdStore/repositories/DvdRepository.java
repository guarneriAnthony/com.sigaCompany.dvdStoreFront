package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.DvdEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface DvdRepository extends CrudRepository<DvdEntity, Long> {
    DvdEntity save(DvdEntity dvdEntity);
    List<DvdEntity> findAll();

    DvdEntity findById(float id);


    List<DvdEntity> findByName(String name);
    List<DvdEntity> findByType(String name);
}
