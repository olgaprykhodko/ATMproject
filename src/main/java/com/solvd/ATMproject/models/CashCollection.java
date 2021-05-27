package com.solvd.ATMproject.models;

import lombok.Data;

import java.util.Date;

@Data
public class CashCollection {
    int idCashCollection;
    Date schedule;
    String responsible;
}