package com.solvd.ATMproject.main;

import com.solvd.ATMproject.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        
        CardService.getStatusCardByNumberCard(1234123412341234L);

    }
}