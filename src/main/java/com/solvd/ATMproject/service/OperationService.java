package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbc.realization.OperationDAO;
import com.solvd.ATMproject.models.Operation;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class OperationService {
    public static int getOperation() {
        OperationDAO operation = new OperationDAO();
        Operation operationName = new Operation();
        Scanner scanner = new Scanner(System.in);
        operation.readOperation();
        log.info("Please choose the operation");
        operationName = operation.read(Integer.valueOf(scanner.nextLine()));
        log.info("You have chosen operation " + operationName.getOperationName());
        return operationName.getIdOperation();
    }
}
