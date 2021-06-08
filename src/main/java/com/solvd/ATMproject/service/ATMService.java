package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAtmDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AtmDAO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ATMService {

    public static void getCommissionByCurrency(String currency) {
        IAtmDAO atmDAO = new AtmDAO();
        atmDAO.read(currency);
    }
}
