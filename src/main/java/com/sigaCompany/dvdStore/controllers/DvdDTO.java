package com.sigaCompany.dvdStore.controllers;

import java.util.Optional;

public record DvdDTO(Long id, String name, String type, int quantity, int price, String description, String image) {
}
