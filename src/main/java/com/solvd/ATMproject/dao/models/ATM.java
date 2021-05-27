package com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class ATM {
    int idATM;
    double numberAtm;
    String banknote;
    int commission;
    Card idCard;
    Bank idBank;
    CashCollection idCashCollection;
}
