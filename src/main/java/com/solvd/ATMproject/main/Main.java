package com.solvd.ATMproject.main;

import com.solvd.ATMproject.models.ATM;
import com.solvd.ATMproject.models.Address;
import com.solvd.ATMproject.models.Card;
import com.solvd.ATMproject.service.*;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {

//        log.info("Welcome to BSB bank");
//        Scanner scanner = new Scanner(System.in);
//        log.info("Please enter the name of street to find into the Data Base");
//        String street = scanner.nextLine();
//       JoinService.getATMByStreet(street);
//        Address address = AddressService.getAddress(street);
//        log.info("You have chosen the ATM on " + street + " street");


//      CollectionService.getCashCollectionTime();
//      log.info("This ATM is active");

//        Scanner scanner1 = new Scanner(System.in);
//        log.info("Please enter the card number to find into the Data Base");
//        String cardNumber = scanner1.nextLine();
//        Card card = CardService.getStatusCardByNumberCard(cardNumber);
//        log.info("Your card number is:" + card);
//
//        OperationService.getOperation();
//
        Scanner scanner = new Scanner(System.in);
        log.info("Please enter the currency to find into the Data Base");
        String currency = scanner.nextLine();
        log.info("You have chosen the currency:"+ currency);
        ATMService.getCommissionByCurrency(currency);
//
//        BalanceService.getCardBalance(800);
//        log.info("Your balance is 800");
//
//        log.info("Thank you for using this ATM");
    }
}