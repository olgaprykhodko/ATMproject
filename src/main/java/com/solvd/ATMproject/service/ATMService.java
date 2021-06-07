package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAtmDAO;
import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.dao.jdbs.realization.AtmDAO;
import com.solvd.ATMproject.dao.jdbs.realization.CardDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ATMService {
    private final static Logger LOGGER = LogManager.getLogger(CardService.class);

    public static void getCommissionByCurrency(String currency) {

        IAtmDAO atmDAO=new AtmDAO();
        atmDAO.read(currency);

    }
}
