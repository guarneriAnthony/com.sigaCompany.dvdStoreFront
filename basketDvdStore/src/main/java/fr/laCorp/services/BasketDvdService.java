package fr.laCorp.services;

import fr.laCorp.repositories.BasketDvdRepository;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketDvdService {
    @Autowired
    BasketDvdRepository basketDvdRepository;
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;


    public BasketDvdServiceModel findById(int id) {
        return basketMapper.basketDvdRepositoryModelToBasketDvdServiceModel(basketDvdRepository.findById(id).orElse(null));
    }
}
