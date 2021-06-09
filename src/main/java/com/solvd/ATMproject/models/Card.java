package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Card {
    private int idCard;
    private int balance;
    private String status;
    private int idUser;
    private String cardNumber;
    private int PIN;
}