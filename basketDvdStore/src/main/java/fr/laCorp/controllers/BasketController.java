package fr.laCorp.controllers;

import fr.laCorp.dtos.BasketDto;
import fr.laCorp.services.BasketService;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    @Autowired
    BasketService basketService;

    private final BasketMapper basketMapper = BasketMapper.INSTANCE;


    @GetMapping("/{id}")
    public BasketDto findById(@PathVariable int id) {
        return basketMapper.basketServiceModelToBasketDto(basketService.findById(id));
    }

}
