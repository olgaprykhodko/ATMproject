package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Address {
    int idAddress;
    String country;
    String city;
    String street;
    int idATM;
    int idBank;
}