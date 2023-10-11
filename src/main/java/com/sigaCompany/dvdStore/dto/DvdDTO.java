package com.sigaCompany.dvdStore.dto;

public record DvdDTO(Long id, String name, String type, int quantity, int price, String description, String image) {
}
