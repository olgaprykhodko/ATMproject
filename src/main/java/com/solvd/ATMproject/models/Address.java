package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Address {
    private int idAddress;
    private String country;
    private String city;
    private String street;
    private int idATM;
    private int idBank;
}