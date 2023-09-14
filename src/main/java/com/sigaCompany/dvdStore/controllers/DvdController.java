package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.services.DvdService;
import com.sigaCompany.dvdStore.services.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "dvdStore")
public class DvdController {
    @Autowired
    DvdService dvdService;

    @PostMapping
    public boolean addDvdStore(@RequestBody DvdDTO dvdDTO){
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdDTO.name(), dvdDTO.gender(), dvdDTO.quantity(), dvdDTO.price());
        return dvdService.add(dvdServiceModel);
    }

}
