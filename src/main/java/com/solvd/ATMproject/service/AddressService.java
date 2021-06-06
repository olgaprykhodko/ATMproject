package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbs.realization.AddressDAO;
import com.solvd.ATMproject.util.ExceptionDAO;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AddressService {
    public static AddressDAO setNewAddress(String street, Scanner scanner) throws ExceptionDAO {

        AddressDAO address = new AddressDAO();

        if (address.read(street) == null) {

            log.info("The Address doesn't exist. Please insert the valid data");
            log.info("Enter the Country");
            String country = scanner.nextLine();
            log.info("Enter the City");
            String city = scanner.nextLine();
            log.info("Enter the Street");
            String Street = scanner.nextLine();
            int b = Integer.parseInt(street);
            log.info("New address is created");

            if (country
                    .matches("[a-zA-z]+") && city
                    .matches("[a-zA-z]+") && Street
                    .matches("\\d{1,2}"))
                throw new ExceptionDAO("Incorrect input of data");
        }
        return address;
    }
}
