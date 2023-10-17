package com.sigaCompany.dvdStore.controllers;

/**
 * The type Sell dto.
 */
public record SellDTO(long id, long clientId, long dvdId, int quantity) {
}
