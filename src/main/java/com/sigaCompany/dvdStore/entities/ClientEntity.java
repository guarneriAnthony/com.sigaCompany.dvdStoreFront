package com.sigaCompany.dvdStore.entities;

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
    private Long id;
//    @OneToMany(mappedBy = "ClientEntity")
//    private Set<SellEntity> sellEntities = new HashSet<>();

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public ClientEntity(String name, String email){
        this.name = name;
        this.email = email;
    }

    public ClientEntity(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
