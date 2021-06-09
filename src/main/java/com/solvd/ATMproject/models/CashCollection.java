package com.solvd.ATMproject.models;

import lombok.Data;

import java.util.Date;

@Data
public class CashCollection {
    private int idCashCollection;
    private Date schedule;

}