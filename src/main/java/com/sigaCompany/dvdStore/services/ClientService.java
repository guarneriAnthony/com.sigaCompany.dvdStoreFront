package com.sigaCompany.dvdStore.services;

import com.sigaCompany.dvdStore.dto.ClientDTO;
import com.sigaCompany.dvdStore.entities.ClientEntity;
import com.sigaCompany.dvdStore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Client service.
 */
@Service
public class ClientService {
    /**
     * The Client repository.
     */
    @Autowired
    ClientRepository clientRepository;

    /**
     * Add boolean.
     *
     * @param clientServiceModel the client service model
     * @return the boolean
     */
//Adds a new Client
    public boolean add(ClientServiceModel clientServiceModel) {
        ClientEntity clientEntity = new ClientEntity(clientServiceModel.getName(), clientServiceModel.getEmail());
        ClientEntity object = clientRepository.save(clientEntity);
        return object != null;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
//Update an existing Client
    public List<ClientServiceModel> findAll() {
        List<ClientEntity> clientEntities = clientRepository.findAll();
        List<ClientServiceModel> clientServiceModels = new ArrayList<>();
        for (ClientEntity client : clientEntities) {
            clientServiceModels.add(new ClientServiceModel(client));
        }
        return clientServiceModels;
    }

    /**
     * Update client.
     *
     * @param id        the id
     * @param clientDTO the client dto
     */
//Update an existing Client
    public void updateClient(long id, ClientDTO clientDTO) {
        clientRepository.save(new ClientEntity(id, clientDTO.name(), clientDTO.email()));
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
//Deletes a client by its ID
    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

    /**
     * Fin by id client service model.
     *
     * @param id the id
     * @return the client service model
     */
// Find information from one Client, by id
    public ClientServiceModel finById(long id) {
        ClientEntity client = clientRepository.findById(id);
        return new ClientServiceModel(client);
    }

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
// Find Client by Name
    public List<ClientServiceModel> findByName(String name) {
        List<ClientEntity> clientEntities = clientRepository.findByName(name);
        List<ClientServiceModel> clientServiceModels = new ArrayList<>();
        for ( ClientEntity client : clientEntities) {
            clientServiceModels.add(new ClientServiceModel(client));
        }
        return clientServiceModels;
    }

    /**
     * Find by email list.
     *
     * @param email the email
     * @return the list
     */
// Find Client by Email
    public List<ClientServiceModel> findByEmail(String email) {
        List<ClientEntity> clientEntities = clientRepository.findByEmail(email);
        List<ClientServiceModel> clientServiceModels = new ArrayList<>();
        for ( ClientEntity client : clientEntities) {
            clientServiceModels.add(new ClientServiceModel(client));
        }
        return clientServiceModels;
    }
}
