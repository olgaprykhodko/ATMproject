package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbc.realization.JoinDAO;
import com.solvd.ATMproject.models.ATM;

public class JoinService {
    public static ATM getATMByStreet(String street) {
        JoinDAO joinDAO = new JoinDAO();
        return joinDAO.getAtmByStreet(street);
    }
}
