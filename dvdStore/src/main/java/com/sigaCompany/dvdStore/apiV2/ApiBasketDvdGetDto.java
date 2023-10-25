package com.sigaCompany.dvdStore.apiV2;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiBasketDvdGetDto {
    private int id;
    private int idDvd;
    private int quantity;
    private float price;
}
