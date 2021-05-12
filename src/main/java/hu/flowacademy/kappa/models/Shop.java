package hu.flowacademy.kappa.models;

import lombok.Data;

@Data
public class Shop {
    private Integer id;
    private String name;
    private String category;
    private String settlement;
    private String zip;
    private String address;
}
