package fr.laCorp.controllers;

import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.services.BasketDvdService;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "basket")
public class BasketDvdController {
    @Autowired
    BasketDvdService basketDvdService;

    private final BasketMapper basketMapper = BasketMapper.INSTANCE;

    @GetMapping("/{id}")
    public BasketDvdDto findById(@PathVariable int id) {
        return basketMapper.basketDvdServiceModelToBasketDvdDto(basketDvdService.findById(id));
    }

}
