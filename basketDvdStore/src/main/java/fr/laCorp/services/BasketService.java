package fr.laCorp.services;

import fr.laCorp.repositories.BasketDvdRepository;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.repositories.BasketRepository;
import fr.laCorp.repositories.BasketRepositoryModel;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    BasketDvdRepository basketDvdRepository;
    BasketRepository basketRepository;
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;


    public BasketDvdServiceModel findById(int id) {
        return basketMapper.basketDvdRepositoryModelToBasketDvdServiceModel(basketDvdRepository.findById(id).orElse(null));
    }

    public List<BasketDvdServiceModel> findAll() {
        Iterable<BasketRepositoryModel> basketRepositoryModelIterable = basketRepository.findAll();
        System.out.println(basketRepositoryModelIterable);
        return basketMapper.iterableBasketRepositoryModelToListBasketServiceModel(basketRepositoryModelIterable);
    }

}
