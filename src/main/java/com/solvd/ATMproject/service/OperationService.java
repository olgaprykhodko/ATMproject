package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbc.realization.OperationDAO;
import com.solvd.ATMproject.models.Operation;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class OperationService {
    public static void getOperation() {
        OperationDAO operation = new OperationDAO();
        Operation operationName = new Operation();
        operation.readOperation();
        Scanner scanner = new Scanner(System.in);
        log.debug("Please choose the operation");
        operationName = operation.read(Integer.valueOf(scanner.nextLine()));
        log.debug("You have chosen operation " + operationName);
        scanner.close();
    }
}
