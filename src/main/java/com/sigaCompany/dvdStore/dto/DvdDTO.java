package com.sigaCompany.dvdStore.dto;

/**
 * The type Dvd dto.
 */
public record DvdDTO(Long id, String name, String type, int quantity, int price, String description, String image) {
}
