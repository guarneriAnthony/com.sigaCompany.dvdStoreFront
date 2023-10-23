package fr.laCorp.services;

import fr.laCorp.repositories.BasketRepositoryModel;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasketDvdServiceModel {
    private int id;
    private int idBasket;
    private int idDvd;
    private int quantity;
    private float price;

}
