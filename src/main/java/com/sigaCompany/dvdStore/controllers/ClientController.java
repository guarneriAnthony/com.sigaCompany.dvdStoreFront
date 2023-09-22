package com.sigaCompany.dvdStore.controllers;

import com.sigaCompany.dvdStore.services.ClientService;
import com.sigaCompany.dvdStore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    ClientService clientService;

    // Add new Client
    @PostMapping
    public boolean addClient(@RequestBody ClientDTO clientDTO) {
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.name(), clientDTO.email());
        return clientService.add(clientServiceModel);
    }

    // find all Clients
    @GetMapping
    public List<ClientDTO> findAll() {
        List<ClientServiceModel> clientServiceModels = clientService.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (ClientServiceModel client : clientServiceModels) {
            clientDTOS.add(new ClientDTO(client.getName(), client.getEmail()));
        }
        return clientDTOS;
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
