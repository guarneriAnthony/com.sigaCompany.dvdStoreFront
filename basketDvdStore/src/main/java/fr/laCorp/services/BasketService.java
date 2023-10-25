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
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    BasketDvdRepository basketDvdRepository;

    public boolean createBasket(BasketServiceModel basketServiceModel) {
        basketRepository.save(basketMapper.basketServiceModelTobasketRepositoryModel(basketServiceModel));
        return true;
    }


    public boolean createBasketDvd(int clientId, BasketDvdServiceModel basketDvdServiceModel) {
        if (basketRepository.findByIdClient(clientId).isPresent()) {
            basketDvdRepository.save(basketMapper.basketDvdServiceModelToBasketDvdRepositoryModel(basketDvdServiceModel, basketRepository.findByIdClient(clientId).get()));
            return true;
        } else {
            return false;
        }
    }


    public List<BasketServiceModel> readAllBasket() {
        Iterable<BasketRepositoryModel> baskets = basketRepository.findAll();
        return basketMapper.iterableBasketRepositoryModelToListBasketServiceModel(baskets);
    }


    public BasketServiceModel readBasketByClientId(int clientId) {
        BasketRepositoryModel basket = basketRepository.findByIdClient(clientId).orElse(null);
        return basketMapper.basketRepositoryModelToBasketServiceModel(basket);
    }


    public boolean updateBasketByClientId(int clientId, BasketServiceModel basketServiceModel) {
        if (basketRepository.findByIdClient(clientId).isPresent()) {
            BasketRepositoryModel oldBasket = basketRepository.findByIdClient(clientId).get();
            BasketRepositoryModel newBasket = basketMapper.basketServiceModelTobasketRepositoryModel(basketServiceModel);
            newBasket.setId(oldBasket.getId());
            basketRepository.save(newBasket);
            return true;
        } else {
            return false;
        }

    }


    public boolean updateBasketDvdById(int clientId, int id, BasketDvdServiceModel basketDvdServiceModel) {
        if (basketRepository.findByIdClient(clientId).isPresent()) {
            BasketRepositoryModel basket = basketRepository.findByIdClient(clientId).get();
            if (basketDvdRepository.findById(id).isPresent()) {
                BasketDvdRepositoryModel oldBasketDvd = basketDvdRepository.findById(id).get();
                BasketDvdRepositoryModel newBasketDvd = basketMapper.basketDvdServiceModelToBasketDvdRepositoryModel(basketDvdServiceModel, basket);
                newBasketDvd.setId(oldBasketDvd.getId());
                basketDvdRepository.save(newBasketDvd);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public boolean deleteBasketByClientId(int clientId) {
        basketRepository.deleteByIdClient(clientId);
        return true;
    }

    public boolean deleteBasketDvdById(int clientId, int id) {
        if (basketRepository.findByIdClient(clientId).isPresent()) {
            basketDvdRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }


    public boolean deleteAllBasketDvdByClientId(int clientId) {
        if (basketRepository.findByIdClient(clientId).isPresent()) {
            basketDvdRepository.deleteAllByBasketId(basketRepository.findByIdClient(clientId).get());
            return true;
        } else {
            return false;
        }

    }


    public List<BasketDvdServiceModel> readAllBasketDvdByClientId(int clientId) {
        return basketMapper.iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(basketDvdRepository.findAllByBasketId(basketRepository.findByIdClient(clientId).get()));
    }
}
