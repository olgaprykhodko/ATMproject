package com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class Address {
    int idAddress;
    String country;
    String city;
    String street;
    ATM idATM;
    Bank idBank;
}
