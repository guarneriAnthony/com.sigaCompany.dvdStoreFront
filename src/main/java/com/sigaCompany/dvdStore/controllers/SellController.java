package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.services.SellService;
import com.sigaCompany.dvdStore.services.SellServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("selling")
public class SellController {
    @Autowired
    SellService sellService;

    @PostMapping
    public void createSale(@RequestBody SellDTO sellDTO){
        sellService.save(new SellServiceModel(sellDTO.clientId(), sellDTO.dvdId(), sellDTO.quantity()));
    }

}
