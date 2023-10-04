package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.controllers.ClientDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientServiceModel {
    private String name;
    private String email;

    public ClientServiceModel(ClientDTO clientDTO){
        this.name = clientDTO.name();
        this.email = clientDTO.email();
    }
    public ClientServiceModel(ClientEntity client){
        this.name = client.getName();
        this.email = client.getEmail();
    }
}
