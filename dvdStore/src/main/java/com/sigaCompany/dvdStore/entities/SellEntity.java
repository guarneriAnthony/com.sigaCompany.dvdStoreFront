package com.sigaCompany.dvdStore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "SellEntity")
public class SellEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity clientEntity;

    @ManyToOne
    @JoinColumn(name = "dvd_id", nullable = false)
    private DvdEntity dvdEntity;

    private int quantity;

    public SellEntity(ClientEntity clientEntity, DvdEntity dvdEntity, int quantity) {
        this.clientEntity = clientEntity;
        this.dvdEntity = dvdEntity;
        this.quantity = quantity;
    }
}
