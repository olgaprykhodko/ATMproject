package com.solvd.ATMproject.main;

import com.solvd.ATMproject.service.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {

        log.info("Welcome to BSB bank");

        AddressService.getAddress("Mira");
        log.info("You choose the ATM on Mira street");

        CollectionService.getCashCollectionTime();

        CardService.getStatusCardByNumberCard("1234123412341234");
        log.info("Your card is active");

        OperationService.getOperation();

        ATMService.getCommissionByCurrency("dollars");
        log.info("You choose the currency - dollars");

        BalanceService.getCardBalance(800);
        log.info("Your balance is 800");

        log.info("Thank you for using this ATM");
    }
}