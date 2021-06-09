package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class ATM {
    private int idATM;
    private String banknote;
    private int commission;
    private int idCard;
    private int idBank;
    private int idCashCollection;
}