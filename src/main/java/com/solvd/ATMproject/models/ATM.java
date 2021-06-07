package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class ATM {
    int idATM;
    String banknote;
    int commission;
    Card idCard;
    Bank idBank;
    CashCollection idCashCollection;
}