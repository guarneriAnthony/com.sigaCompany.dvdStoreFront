package com.sigaCompany.dvdStore.controllers;

import java.util.Optional;

public record DvdDTO(int id, String name, String type, int quantity, int price, String description, String image) {
}
