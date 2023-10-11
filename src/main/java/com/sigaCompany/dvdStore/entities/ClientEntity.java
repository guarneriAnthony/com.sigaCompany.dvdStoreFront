package com.sigaCompany.dvdStore.entities;

import com.sigaCompany.dvdStore.services.ClientServiceModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Client entity.
 */
@NoArgsConstructor
@Entity
@Data
@Table(name = "Client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "clientEntity")
    private Set<SellEntity> sellEntities = new HashSet<>();

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    /**
     * Instantiates a new Client entity.
     *
     * @param name  the name
     * @param email the email
     */
    public ClientEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Instantiates a new Client entity.
     *
     * @param id    the id
     * @param name  the name
     * @param email the email
     */
    public ClientEntity(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Instantiates a new Client entity.
     *
     * @param client the client
     */
    public ClientEntity(ClientServiceModel client){
        name = client.getName();
        email = client.getEmail();
    }

    /**
     * Instantiates a new Client entity.
     *
     * @param id     the id
     * @param client the client
     */
    public ClientEntity( long id,ClientServiceModel client) {
        this.id = id;
        name = client.getName();
        email = client.getEmail();
    }
}
