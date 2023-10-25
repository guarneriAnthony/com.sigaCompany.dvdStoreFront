package fr.laCorp.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BasketRepository extends CrudRepository<BasketRepositoryModel, Integer> {


    Optional<BasketRepositoryModel> findByIdClient(int clientId);

    void deleteByIdClient(int clientId);
}
