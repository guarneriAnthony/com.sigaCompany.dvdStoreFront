package com.sigaCompany.dvdStore.feign;

import com.sigaCompany.dvdStore.apiV2.ApiBasketDto;
import com.sigaCompany.dvdStore.apiV2.ApiBasketDvdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name= "BasketDvdController", url= "http://localhost:9090/basket")
public interface MyClientFeign {

    @PostMapping
    boolean createBasket(@RequestBody ApiBasketDto apiBasketDto);
    @PostMapping("/{clientId}")
    boolean createBasketDvd(@PathVariable int clientId, @RequestBody ApiBasketDvdDto apiBasketDvdDto);
    @GetMapping("")
    List<ApiBasketDto> readAllBasket();
    @GetMapping("/{clientId}")
    ApiBasketDto readBasketByClientId(@PathVariable int clientId);
    @PutMapping("/{clientId}")
    boolean updateBasketByClientId(@PathVariable int clientId, @RequestBody ApiBasketDto apiBasketDto);
    @PutMapping("/{clientId}/basket-dvd/{id}")
    boolean updateBasketDvdById(@PathVariable int clientId, @PathVariable int id, @RequestBody ApiBasketDvdDto apiBasketDvdDto);
    @DeleteMapping("/{clientId}")
    boolean deleteBasketByClientId(@PathVariable int clientId);
    @DeleteMapping("/{clientId}/basket-dvd/{id}")
    boolean deleteBasketDvdById(@PathVariable int clientId, @PathVariable int id);
    @DeleteMapping("/{clientId}/basket-dvd")
    boolean deleteAllBasketDvdByClientId(@PathVariable int clientId);
}
