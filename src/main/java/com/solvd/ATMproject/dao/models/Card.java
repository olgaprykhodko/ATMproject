package com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class Card {
    int idCard;
    int balance;
    boolean status;
    User isUser;
    Bank idBank;
}
