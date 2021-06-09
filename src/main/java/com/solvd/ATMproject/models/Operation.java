package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Operation {
    private int idOperation;
    private String operationName;
    private int operationCode;
}