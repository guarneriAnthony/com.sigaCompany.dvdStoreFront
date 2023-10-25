package fr.laCorp.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BasketServiceModel {
    private int id;
    private int idClient;
    private float totalPrice;
}
