package com.solvd.ATMproject.main;

import com.solvd.ATMproject.service.ATMService;
import com.solvd.ATMproject.service.AddressService;
import com.solvd.ATMproject.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


       CardService cardService=new CardService();
       CardService.getStatusCardByNumberCard("1234123412341234");


        ATMService atmService=new ATMService();
        ATMService.getCommissionByCurrency("dollars");
    }
}