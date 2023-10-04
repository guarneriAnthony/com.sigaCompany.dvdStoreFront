package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.services.SellService;
import com.sigaCompany.dvdStore.services.SellServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("selling")
public class SellController {
    @Autowired
    SellService sellService;

    @PostMapping
    public void createSale(@RequestBody SellDTO sellDTO) {
        sellService.save(new SellServiceModel(sellDTO.clientId(), sellDTO.dvdId(), sellDTO.quantity()));
    }

    // Find all infortation from one sale
    @GetMapping("{id}")
    public ResponseEntity<SellGetDTO> findById(@PathVariable long id) {
        SellServiceModel sellServiceModel = sellService.findById(id);

        if (sellServiceModel != null) {
            SellGetDTO sellGetDTO = new SellGetDTO(sellServiceModel.getClient(), sellServiceModel.getDvd(), sellServiceModel.getQuantity());
            return new ResponseEntity<>(sellGetDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping
//    public List<SellDTO> findAll(){
//        List<SellServiceModel> sellServiceModels = sellService.findAll();
//        List<SellDTO> sellDTOS = new ArrayList<>();
//        for (SellServiceModel sell : sellServiceModels){
//            sellDTOS.add(new SellDTO(sell.getClientId(), sell.getDvdId(), sell.getQuantity()));
//        }
//        return  sellDTOS;
//    }

}
