package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Bank {
    int idBank;
    String name;
    int registerNumber;
    ATM idATM;
}