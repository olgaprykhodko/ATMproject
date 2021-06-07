package com.solvd.ATMproject.main;

import com.solvd.ATMproject.service.ATMService;
import com.solvd.ATMproject.service.AddressService;
import com.solvd.ATMproject.service.BalanceService;
import com.solvd.ATMproject.service.CardService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {

        AddressService.getAddress("Mira");

        CardService.getStatusCardByNumberCard("1234123412341234");

        ATMService.getCommissionByCurrency("dollars");

        BalanceService.getCardBalance(800);
    }
}