package fr.laCorp.repositories;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "basket")
public class BasketRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "basketId", fetch = FetchType.EAGER)
    private Set<BasketDvdRepositoryModel> basketId = new HashSet<>();


    @Column(name = "id_client")
    private int idClient;
    @Column(name = "total_price")
    private float totalPrice;
}
