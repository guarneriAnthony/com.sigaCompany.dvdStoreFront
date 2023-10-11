package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.dto.ClientDTO;
import com.sigaCompany.dvdStore.services.ClientService;
import com.sigaCompany.dvdStore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "client")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class ClientController {
    @Autowired
    ClientService clientService;


    @CrossOrigin (origins = "http://localhost:4200/")


    // Add new Client
    @PostMapping
    public boolean addClient(@RequestBody ClientDTO clientDTO) {
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO);
        return clientService.add(clientServiceModel);
    }

    // find all Clients
    @GetMapping
    public List<ClientDTO> findAll() {
        List<ClientServiceModel> clientServiceModels = clientService.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel client : clientServiceModels) {
            clientDTOS.add(new ClientDTO(client.getId(), client.getName(), client.getEmail()));
        }
        return clientDTOS;
    }

    // Function to find information from one client, by id
    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable long id){
        ClientServiceModel client = clientService.finById(id);
        ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(),client.getEmail());
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }

    //Find Client by Name
    @GetMapping("/byname/{name}")
    public ResponseEntity<List<ClientDTO>> findByName(@PathVariable String name){
        List<ClientServiceModel> clientServiceModels = clientService.findByName(name);
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel clientServiceModel : clientServiceModels){
            clientDTOS.add(new ClientDTO(clientServiceModel.getId(), clientServiceModel.getName(), clientServiceModel.getEmail()));
        }
        return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
    }
    //Find Client by Email
    @GetMapping("/byemail/{email}")
    public ResponseEntity<List<ClientDTO>> findByEmail(@PathVariable String email){
        List<ClientServiceModel> clientServiceModels = clientService.findByEmail(email);
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel clientServiceModel : clientServiceModels){
            clientDTOS.add(new ClientDTO(clientServiceModel.getId(), clientServiceModel.getName(), clientServiceModel.getEmail()));
        }
        return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
    }

    //Update one client
    @PutMapping("{id}")
    public void updateClient(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(id, clientDTO);
    }

    //Delete one client
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        clientService.deleteById(id);
    }
}
