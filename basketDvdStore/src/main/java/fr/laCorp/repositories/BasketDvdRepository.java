package fr.laCorp.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasketDvdRepository extends CrudRepository<BasketDvdRepositoryModel, Integer> {

    Iterable<BasketDvdRepositoryModel> findAllByBasketId(BasketRepositoryModel basketRepositoryModel);

    void deleteAllByBasketId(BasketRepositoryModel basketRepositoryModel);
}
