package hu.flowacademy.kappa._ora1controller;

import lombok.Data;

@Data
public class RequestModel {
    private String name;
    private String category;
    private String settlement;
    private String zip;
    private String address;
}
