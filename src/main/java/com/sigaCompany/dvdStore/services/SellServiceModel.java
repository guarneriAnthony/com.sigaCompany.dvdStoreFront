package com.sigaCompany.dvdStore.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellServiceModel {
    private long clientId;
    private long dvdId;
    private int quantity;
}
