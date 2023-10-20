package fr.laCorp.controllers;

import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.services.BasketDvdService;
import fr.laCorp.services.BasketDvdServiceModel;
import fr.laCorp.services.BasketService;
import fr.laCorp.utils.BasketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "basketDvd")
public class BasketDvdController {
    @Autowired
    BasketDvdService basketDvdService;

    private final BasketMapper basketMapper = BasketMapper.INSTANCE;


    @PostMapping()
    public BasketDvdDto create(@RequestBody BasketDvdDto basketDvdDto) {
        BasketDvdServiceModel basketDvdServiceModel = basketMapper.basketDvdDtoToBasketDvdServiceModel(basketDvdDto);
        BasketDvdServiceModel saved = basketDvdService.save(basketDvdServiceModel);
        return basketMapper.basketDvdServiceModelToBasketDvdDto(saved);
    }

    @GetMapping()
    public List<BasketDvdDto> findAll() {
        List<BasketDvdServiceModel> basketDvdServiceModels = basketDvdService.findAll();
        return basketMapper.listBasketDvdServiceModelToBasketDvdDto(basketDvdServiceModels);
    }

    @GetMapping("/{id}")
    public BasketDvdDto findById(@PathVariable int id) {
        return basketMapper.basketDvdServiceModelToBasketDvdDto(basketDvdService.findById(id));
    }

    @PutMapping("/{id}")
    public BasketDvdDto update(@PathVariable int id, @RequestBody BasketDvdDto basketDvdDto) {
        BasketDvdServiceModel basketDvdServiceModel = basketMapper.basketDvdDtoToBasketDvdServiceModel(basketDvdDto);
        BasketDvdServiceModel saved = basketDvdService.update(id, basketDvdServiceModel);
        return basketMapper.basketDvdServiceModelToBasketDvdDto(saved);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        basketDvdService.deleteById(id);
    }

}
