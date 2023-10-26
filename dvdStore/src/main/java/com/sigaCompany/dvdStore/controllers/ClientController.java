package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.apiV2.ApiBasketDto;
import com.sigaCompany.dvdStore.apiV2.ApiBasketDvdDto;
import com.sigaCompany.dvdStore.dto.ClientDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.feign.MyClientFeign;
import com.sigaCompany.dvdStore.services.ClientService;
import com.sigaCompany.dvdStore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "clients")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    MyClientFeign myClientFeign;





    @PostMapping
    public boolean addClient(@RequestBody ClientDTO clientDTO) {
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO);
        ClientEntity object = clientService.add(clientServiceModel);
        myClientFeign.createBasket(new ApiBasketDto(object.getId()));
        return  object!= null;
    }
    @PostMapping("/{clientId}")
    public boolean createBasketDvd(@PathVariable int clientId, @RequestBody ApiBasketDvdDto apiBasketDvdDto) {
        myClientFeign.createBasketDvd(clientId, apiBasketDvdDto);
        return true;
    }
    @GetMapping("/basket")
    public List<ApiBasketDto> readAllBasket() {
        return myClientFeign.readAllBasket();
    }
    @GetMapping("/{clientId}/basket")
    public ApiBasketDto readBasketByClientId(@PathVariable int clientId) {
        return myClientFeign.readBasketByClientId(clientId);
    }
    @GetMapping
    public List<ClientDTO> findAll() {
        List<ClientServiceModel> clientServiceModels = clientService.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel client : clientServiceModels) {
            clientDTOS.add(new ClientDTO(client.getId(), client.getName(), client.getEmail()));
        }
        return clientDTOS;
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> findById(@PathVariable int clientId){
        ClientServiceModel client = clientService.findById(clientId);
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(),client.getEmail());
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }
    @GetMapping("/byname/{name}")
    public ResponseEntity<List<ClientDTO>> findByName(@PathVariable String name){
        List<ClientServiceModel> clientServiceModels = clientService.findByName(name);
        System.out.println(clientServiceModels);
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel clientServiceModel : clientServiceModels){
            clientDTOS.add(new ClientDTO(clientServiceModel.getId(), clientServiceModel.getName(), clientServiceModel.getEmail()));
        }
        return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
    }
    @GetMapping("/byemail/{email}")
    public ResponseEntity<List<ClientDTO>> findByEmail(@PathVariable String email){
        List<ClientServiceModel> clientServiceModels = clientService.findByEmail(email);
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel clientServiceModel : clientServiceModels){
            clientDTOS.add(new ClientDTO(clientServiceModel.getId(), clientServiceModel.getName(), clientServiceModel.getEmail()));
        }
        return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
    }
    @PutMapping("{clientId}/basket")
    public void updateBasketByClientId(@PathVariable int clientId, @RequestBody ApiBasketDto apiBasketDto) {
        myClientFeign.updateBasketByClientId(clientId, apiBasketDto);
    }

    @PutMapping("{clientId}/basket-dvd/{id}")
    public void updateBasketDvdById(@PathVariable int clientId, @PathVariable int id, @RequestBody ApiBasketDvdDto apiBasketDvdDto) {
        myClientFeign.updateBasketDvdById(clientId, id, apiBasketDvdDto);
    }
    @PutMapping("{id}")
    public void updateClient(@PathVariable int id, @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
    }
    @DeleteMapping("{clientId}")
    public void deleteBasketByClientId(@PathVariable int clientId) {
        myClientFeign.deleteBasketByClientId(clientId);
    }
    @DeleteMapping("{clientId}/basket-dvd/{id}")
    public void deleteBasketDvdById(@PathVariable int clientId, @PathVariable int id) {
        myClientFeign.deleteBasketDvdById(clientId, id);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        clientService.deleteById(id);
        myClientFeign.deleteBasketByClientId(id);
    }
    @DeleteMapping("/{clientId}/basket-dvd")
    public void deleteAllBasketDvdByClientId(@PathVariable int clientId) {
        myClientFeign.deleteAllBasketDvdByClientId(clientId);
    }




}
