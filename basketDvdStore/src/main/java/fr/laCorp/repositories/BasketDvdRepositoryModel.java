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

      @ManyToOne
      @JoinColumn(name = "id_basket")
      private BasketRepositoryModel basketId;


    @Column(name = "id_dvd")
    private int idDvd;
    @Column
    private int quantity;
    @Column
    private float price;
}
