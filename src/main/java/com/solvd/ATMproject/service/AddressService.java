package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAddressDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AddressDAO;
import com.solvd.ATMproject.models.Address;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AddressService {

    public static Address getAddress(String street)  {
        IAddressDAO addressDAO = new AddressDAO();
        log.info("You have chosen the ATM on " + street + " street");
        return addressDAO.read(street);

    }
}
