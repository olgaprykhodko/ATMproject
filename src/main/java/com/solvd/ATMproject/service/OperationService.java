package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbs.realization.OperationDAO;
import com.solvd.ATMproject.models.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class OperationService {
    private final static Logger LOGGER = LogManager.getLogger(OperationService.class);
    public static void getID() {
        OperationDAO operation = new OperationDAO();
        Operation operationName = new Operation();
        operation.readOperation();
        Scanner scanner = new Scanner(System.in);
        operationName = operation.read(Integer.valueOf(scanner.nextLine()));
        LOGGER.debug("You have chosen operation " + operationName);
        scanner.close();
    }
}
