package com.solvd.ATMproject.service;

import com.solvd.ATMproject.util.OperationException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WhichOperation {

    public double whichOperation(int operationId, double balance, double sum) throws OperationException {

         double finalBalance = 0;
        switch (operationId) {
            case (1):
                finalBalance = balance -(sum + sum*0.05);
                break;
            case (2):

                finalBalance = balance - sum -sum*0.05;
                break;
            case (3):
                finalBalance = balance - sum - sum*0.05;
                break;
            case (4):
                finalBalance = balance - sum - sum*0.05;

                break;
            case (5):
                throw new OperationException("This operation is currently not supported");
            case (6):

                finalBalance = balance + sum - sum*0.05;

                break;
            default:
                throw new OperationException("Wrong operation index");
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
