package com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class Bank {
    int idBank;
    String name;
    int registerNumber;
    Address idAddress;
    ATM idATM;
}
