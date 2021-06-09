package com.solvd.ATMproject.service;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WhichOperation {
    public int whichOperation(int operationId, int balance, int sum) {
        int finalBalance = 0;
        switch (operationId) {
            case (1):
                finalBalance = balance - sum/20;
                break;
            case (2):
                finalBalance = balance - sum/20;
                break;
            case (3):
                finalBalance = balance - sum/20;
                break;
            case (4):
                finalBalance = balance - sum/20;
                break;
            case (5):
                finalBalance = balance;
                log.error("This operation is currently not supported");
                break;
            case (6):
                finalBalance = balance + sum;
                break;
            default:
                log.error("This operation is not supported");
                break;
        }
        if (finalBalance < 0) {
            log.error("Insufficient funds");
            return balance;
        } else {
            log.info("Operation is completed");
            log.info("Your balance is " + finalBalance);
            return finalBalance;
        }
    }
}
