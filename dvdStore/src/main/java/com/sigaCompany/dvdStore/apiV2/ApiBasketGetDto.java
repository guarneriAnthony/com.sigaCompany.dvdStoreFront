package com.sigaCompany.dvdStore.apiV2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiBasketGetDto {
    private int id;
    private int idClient;
    private float totalPrice;
    private List<ApiBasketDvdGetDto> basketDvdGetDtoList;

}
