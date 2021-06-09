package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAddressDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AddressDAO;
import com.solvd.ATMproject.models.ATM;
import com.solvd.ATMproject.models.Address;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AddressService {

    public static void getAddress(String street) {
        IAddressDAO addressDAO = new AddressDAO();
        Address address = addressDAO.read(street);
        log.info("The ATM on " + street + " has id ATM = " + address.getIdATM());
    }

    public static void getCommissionBy(String street) {
        IAddressDAO addressDAO = new AddressDAO();
        ATM atm = addressDAO.getBy(street);
        log.info("You have commission - " + atm.getCommission() + " % ");
    }
}
