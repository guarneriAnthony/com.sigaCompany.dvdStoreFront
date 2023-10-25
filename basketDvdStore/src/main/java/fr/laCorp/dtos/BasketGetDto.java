package fr.laCorp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BasketGetDto  {
    private int id;
    private int idClient;
    private float totalPrice;
    private List<BasketDvdGetDto> basketDvdGetDtoList;
}
