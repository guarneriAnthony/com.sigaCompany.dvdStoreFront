package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.services.DvdService;
import com.sigaCompany.dvdStore.services.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "dvdStore")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class DvdController {
    @Autowired
    DvdService dvdService;


    // Function to add a new Dvd to the store
    @PostMapping
    public boolean addDvdStore(@RequestBody DvdDTO dvdDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdDTO);
        return dvdService.add(dvdServiceModel);
    }

    //Function to update an existing Dvd in the store
    @PutMapping("{id}")
    public ResponseEntity<String> updateDvd(@PathVariable long id, @RequestBody DvdDTO dvdDTO) {
        boolean update = dvdService.updateDvd(id, dvdDTO);
        if (update) {
            return ResponseEntity.ok("Dvd updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Function to findAll all Dvd in the bdd
    @GetMapping()
    public List<DvdDTO> findAll() {
        List<DvdServiceModel> dvdServiceModels = dvdService.findAll();
        List<DvdDTO> dvdDTOS = new ArrayList<>();
        for (DvdServiceModel dvd : dvdServiceModels) {
            dvdDTOS.add(new DvdDTO(dvd.getId(), dvd.getName(), dvd.getType(), dvd.getQuantity(), dvd.getPrice(), dvd.getDescription(), dvd.getImage()));
        }
        return dvdDTOS;
    }

    // Find information from Dvd, using the Name
    @GetMapping("/byname/{name}")
    public ResponseEntity<List<DvdDTO>> findByName(@PathVariable String name){
        List<DvdServiceModel> dvds = dvdService.findByName(name);
        List<DvdDTO> dvdDTOS = new ArrayList<>();
        for (DvdServiceModel dvd : dvds){
            dvdDTOS.add(new DvdDTO(dvd.getId(),dvd.getName(),dvd.getType(),dvd.getQuantity(), dvd.getPrice(), dvd.getDescription(), dvd.getImage()));
        }
        return new ResponseEntity<>(dvdDTOS, HttpStatus.OK);
    }


    // Find Dvd by Type
    @GetMapping("/bytype/{type}")
    public ResponseEntity<List<DvdDTO>> findByType(@PathVariable String type){
        List<DvdServiceModel> dvds = dvdService.findByType(type);
        List<DvdDTO> dvdDTOS = new ArrayList<>();
        for (DvdServiceModel dvd : dvds){
            dvdDTOS.add(new DvdDTO(dvd.getId(),dvd.getName(),dvd.getType(),dvd.getQuantity(), dvd.getPrice(), dvd.getDescription(), dvd.getImage()));
        }
        return new ResponseEntity<>(dvdDTOS, HttpStatus.OK);
    }


    //Function to Find Information From one Dvd, by id
    @GetMapping("{id}")
    public ResponseEntity<DvdDTO> findById(@PathVariable long id) {
        DvdServiceModel dvdServiceModel = dvdService.findById(id);
        DvdDTO dvdDTO = new DvdDTO(dvdServiceModel.getId(), dvdServiceModel.getName(), dvdServiceModel.getType(), dvdServiceModel.getQuantity(), dvdServiceModel.getPrice(), dvdServiceModel.getDescription(), dvdServiceModel.getImage());
        return new ResponseEntity<>(dvdDTO, HttpStatus.OK);
    }

    //Function to Delete One Dvd, by id
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        dvdService.deleteById(id);
    }

}
