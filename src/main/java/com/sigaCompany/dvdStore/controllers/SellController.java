package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.dto.SellDTO;
import com.sigaCompany.dvdStore.dto.SellGetDTO;
import com.sigaCompany.dvdStore.services.SellService;
import com.sigaCompany.dvdStore.services.SellServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Sell controller.
 */
@RestController
@RequestMapping("selling")
public class SellController {
    /**
     * The Sell service.
     */
    @Autowired
    SellService sellService;

    /**
     * Create sale.
     *
     * @param sellDTO the sell dto
     */
    @PostMapping
    public void createSale(@RequestBody SellDTO sellDTO) {
        sellService.save(new SellServiceModel(sellDTO));
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
// Find all infortation from one sale
    @GetMapping("{id}")
    public ResponseEntity<SellDTO> findById(@PathVariable long id) {
        SellServiceModel sellServiceModel = sellService.findById(id);

        if (sellServiceModel != null) {
            SellDTO sellDTO = new SellDTO(sellServiceModel.getId(), sellServiceModel.getClient().getId(), sellServiceModel.getDvd().getId(), sellServiceModel.getQuantity());
            return new ResponseEntity<>(sellDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<SellGetDTO> findAll(){
        List<SellServiceModel> sellServiceModels = sellService.findAll();
        List<SellGetDTO> sellGetDTOS = new ArrayList<>();
        for (SellServiceModel sell : sellServiceModels){
            sellGetDTOS.add(new SellGetDTO(sell));
        }
        return  sellGetDTOS;
    }

}
