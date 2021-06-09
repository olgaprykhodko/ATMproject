package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class User {
    private int idUser;
    private String firstName;
    private String lastName;
    private long cardNumber;
    private int PIN;
}