package fr.laCorp.services;

import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.repositories.BasketDvdRepository;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.repositories.BasketRepository;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketDvdService {
    @Autowired
    BasketDvdRepository basketDvdRepository;
    @Autowired
    BasketRepository basketRepository;
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;

    public BasketDvdServiceModel save(BasketDvdServiceModel basketDvdServiceModel) {
        BasketDvdRepositoryModel basketDvdRepositoryModel = basketMapper.basketDvdServiceModelToBasketDvdRepositoryModel(basketDvdServiceModel);
        BasketDvdRepositoryModel saved = basketDvdRepository.save(basketDvdRepositoryModel);
        return basketMapper.basketDvdRepositoryModelToBasketDvdServiceModel(saved);
    }

    public List<BasketDvdServiceModel> findAll() {
        Iterable<BasketDvdRepositoryModel> basketDvdRepositoryModelIterable = basketDvdRepository.findAll();
        return basketMapper.iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(basketDvdRepositoryModelIterable);
    }

    public BasketDvdServiceModel findById(int id) {
        return basketMapper.basketDvdRepositoryModelToBasketDvdServiceModel(basketDvdRepository.findById(id).orElse(null));
    }

    public BasketDvdServiceModel update(int id, BasketDvdServiceModel basketDvdServiceModel) {
        Optional<BasketDvdRepositoryModel> optionalBasketDvdRepositoryModel = basketDvdRepository.findById(id);
        if (optionalBasketDvdRepositoryModel.isPresent()){
            BasketDvdRepositoryModel basketDvdRepositoryModel = basketMapper.basketDvdServiceModelToBasketDvdRepositoryModel(basketDvdServiceModel);
            BasketDvdRepositoryModel saved = basketDvdRepository.save(basketDvdRepositoryModel);
            return basketMapper.basketDvdRepositoryModelToBasketDvdServiceModel(saved);
        } else {
            return null;
        }
    }


    public void deleteById(int id) {
        basketDvdRepository.deleteById(id);
    }




    public List<BasketDvdServiceModel> findAllByBasketId(int id) {
        Iterable<BasketDvdRepositoryModel> basketDvdRepositoryModelIterable = basketDvdRepository.findAllByBasketId(basketRepository.findById(id).get());
        return basketMapper.iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(basketDvdRepositoryModelIterable);
    }
}
