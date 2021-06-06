package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Card {
    int idCard;
    int balance;
    String status;
    int idUser;
}