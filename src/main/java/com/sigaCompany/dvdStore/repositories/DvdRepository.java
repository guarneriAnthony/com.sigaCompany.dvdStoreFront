package com.sigaCompany.dvdStore.repositories;

import com.sigaCompany.dvdStore.entities.DvdEntity;
import org.springframework.data.repository.CrudRepository;

public interface DvdRepository extends CrudRepository<DvdEntity, Long> {
}
