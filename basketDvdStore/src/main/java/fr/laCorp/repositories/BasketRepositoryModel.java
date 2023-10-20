package fr.laCorp.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "basket")
public class BasketRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_client")
    private int idClient;
    @Column(name = "total_price")
    private float totalPrice;

}
