package hu.flowacademy.kappa.controllers.model;

import lombok.Data;

@Data
public class ShopRequest {
    private String name;
    private String category;
    private String settlement;
    private String zip;
    private String address;
}
