package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.dto.ClientDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientServiceModel {
    private long id;
    private String name;
    private String email;

    public ClientServiceModel(ClientDTO clientDTO){
        this.name = clientDTO.name();
        this.email = clientDTO.email();
    }
    public ClientServiceModel(ClientEntity client){
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
    }
}
