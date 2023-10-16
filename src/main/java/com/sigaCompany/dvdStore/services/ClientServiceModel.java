package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.dto.ClientDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Client service model.
 */
@Data
@AllArgsConstructor
public class ClientServiceModel {
    private long id;
    private String name;
    private String email;

    /**
     * Instantiates a new Client service model.
     *
     * @param clientDTO the client dto
     */
    public ClientServiceModel(ClientDTO clientDTO){
        this.name = clientDTO.name();
        this.email = clientDTO.email();
    }

    /**
     * Instantiates a new Client service model.
     *
     * @param client the client
     */
    public ClientServiceModel(ClientEntity client){
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
    }
}
