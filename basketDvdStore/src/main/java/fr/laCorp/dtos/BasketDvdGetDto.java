package fr.laCorp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasketDvdGetDto {
    private int id;
    private int idDvd;
    private int quantity;
    private float price;
}
