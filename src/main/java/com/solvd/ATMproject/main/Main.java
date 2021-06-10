package com.solvd.ATMproject.main;

import com.solvd.ATMproject.dao.jdbc.realization.CardDAO;
import com.solvd.ATMproject.models.Address;
import com.solvd.ATMproject.service.*;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        log.info("Welcome to BSB bank");
        AddressService.getAddress("Mira 45");
        CollectionService.getCashCollectionTime();
        CardService.getStatusCardByNumberCard("1234123412341234");
        int op = OperationService.getOperation();
        AddressService.getCommissionBy("Mira 45");
        double balance = BalanceService.getCardBalance("1234123412341234");
        log.info("Please enter the sum");
        double sum = Double.parseDouble(scanner.nextLine());
        WhichOperation wh = new WhichOperation();
        wh.whichOperation(op, balance, sum);
        log.info("Thank you for using this ATM");
        scanner.close();
    }
}