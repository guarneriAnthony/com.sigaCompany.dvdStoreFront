package com.sigaCompany.dvdStore.entities;

import com.sigaCompany.dvdStore.services.ClientServiceModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "Client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "clientEntity")
    private Set<SellEntity> sellEntities = new HashSet<>();

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public ClientEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ClientEntity(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public ClientEntity(ClientServiceModel client){
        name = client.getName();
        email = client.getEmail();
    }

    public ClientEntity( int id,ClientServiceModel client) {
        this.id = id;
        name = client.getName();
        email = client.getEmail();
    }
}
