package fr.laCorp.controllers;

import fr.laCorp.dtos.BasketDto;
import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.dtos.BasketDvdGetDto;
import fr.laCorp.dtos.BasketGetDto;
import fr.laCorp.services.BasketService;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;
    @Autowired
    BasketService basketService;

    @PostMapping
    public boolean createBasket(@RequestBody BasketDto basketDto) {
        basketService.createBasket(basketMapper.basketDtoToBasketServiceModel(basketDto));
        return true;
    }

    @PostMapping("/{clientId}")
    public boolean createBasketDvd(@PathVariable int clientId, @RequestBody BasketDvdDto basketDvdDto) {
        basketService.createBasketDvd(clientId, basketMapper.basketDvdDtoToBasketDvdServiceModel(basketDvdDto));
        return true;
    }

    @GetMapping
    public List<BasketGetDto> readAllBasket() {
        return basketMapper.listBasketServiceModelToBasketGetDto(basketService.readAllBasket());
    }



    @GetMapping("/{clientId}")
    public BasketGetDto readBasketByClientId(@PathVariable int clientId) {
        return basketMapper.BasketServiceModelToBasketGetDto(basketService.readBasketByClientId(clientId), readAllBasketDvdByClientId(clientId));
    }

    public List<BasketDvdGetDto> readAllBasketDvdByClientId(@PathVariable int clientId) {
        return basketMapper.listBasketDvdServiceModelToBasketDvdGetDto(basketService.readAllBasketDvdByClientId(clientId));
    }

    @PutMapping("/{clientId}")
    public boolean updateBasketByClientId(@PathVariable int clientId, @RequestBody BasketDto basketDto) {
        basketService.updateBasketByClientId(clientId, basketMapper.basketDtoToBasketServiceModel(basketDto));
        return true;
    }

    @PutMapping("/{clientId}/basket-dvd/{id}")
    public boolean updateBasketDvdById(@PathVariable int clientId, @PathVariable int id, @RequestBody BasketDvdDto basketDvdDto) {
        basketService.updateBasketDvdById(clientId, id, basketMapper.basketDvdDtoToBasketDvdServiceModel(basketDvdDto));
        return true;
    }

    @DeleteMapping("/{clientId}")
    public boolean deleteBasketByClientId(@PathVariable int clientId) {
        basketService.deleteBasketByClientId(clientId);
        return true;
    }
    @DeleteMapping("/{clientId}/basket-dvd/{id}")
    public boolean deleteBasketDvdById(@PathVariable int clientId, @PathVariable int id) {
        basketService.deleteBasketDvdById(clientId, id);
        return true;
    }

    @DeleteMapping("/{clientId}/basket-dvd")
    public boolean deleteAllBasketDvdByClientId(@PathVariable int clientId) {
        basketService.deleteAllBasketDvdByClientId(clientId);
        return true;
    }






}
