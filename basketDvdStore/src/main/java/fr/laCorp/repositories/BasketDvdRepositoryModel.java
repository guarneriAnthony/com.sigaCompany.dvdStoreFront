package fr.laCorp.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "dvd_basket")
public class BasketDvdRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_basket")
    private int idBasket;
    @Column(name = "id_dvd")
    private int idDvd;
    @Column
    private int quantity;
    @Column
    private float price;
}
