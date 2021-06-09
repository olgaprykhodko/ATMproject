package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Bank {
    private int idBank;
    private String name;
    private int registerNumber;
    private int idATM;
}