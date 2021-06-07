package com.solvd.ATMproject.main;

import com.solvd.ATMproject.service.AddressService;
import com.solvd.ATMproject.service.CardService;
import com.solvd.ATMproject.util.ExceptionDAO;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class Main {
    public static void main(String[] args) {

        CardService.getStatusCardByNumberCard("1234123412341234");

        Scanner scanner = new Scanner(System.in);
        log.info("Please enter the name of street to find into the Data Base");
        String street = scanner.nextLine();
        try {
            AddressService.setAddress(street, scanner);
            scanner.nextLine();
        } catch (ExceptionDAO e) {
            e.printStackTrace();
        }
    }
}