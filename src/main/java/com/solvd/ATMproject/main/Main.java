package com.solvd.ATMproject.main;

import com.solvd.ATMproject.models.Address;
import com.solvd.ATMproject.service.*;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {

        log.info("Welcome to BSB bank");

        Scanner scanner = new Scanner(System.in);
        log.info("Please enter the name of street to find the ATM in the DataBase");
        String street = scanner.nextLine();
        JoinService.getATMByStreet(street);
        Address address = AddressService.getAddress(street);

        CollectionService.getCashCollectionTime();

        CardService.getStatusCardByNumberCard("1234123412341234");

        int op = OperationService.getOperation();

        ATMService.getCommissionByCurrency("dollars");

        int balance = 800;
        BalanceService.getCardBalance(balance);
        log.info("Please enter the sum");

        int sum = Integer.parseInt(scanner.nextLine());
        WhichOperation wh = new WhichOperation();
        wh.whichOperation(op, balance, sum);
        log.info("Thank you for using this ATM");
        scanner.close();
    }
}