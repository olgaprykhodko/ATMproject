package com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class User {
    int idUser;
    String firstName;
    String lastName;
    int cardNumber;
    int PIN;
    int phoneNumber;
}
