package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAddressDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AddressDAO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AddressService {
    public static void getAddress(String street) {
        IAddressDAO addressDAO = new AddressDAO();
        addressDAO.read(street);
    }
}
