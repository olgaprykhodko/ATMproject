package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAddressDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AddressDAO;
import com.solvd.ATMproject.models.Address;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

@Log4j2
public class AddressService {
    public static Address getAddress(String street)  {
        IAddressDAO addressDAO = new AddressDAO();
        return addressDAO.read(street);
    }
}
