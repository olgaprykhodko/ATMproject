package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAtmDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AtmDAO;
import com.solvd.ATMproject.models.ATM;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ATMService {
    public static void getCommissionById(int idATMs) {
        IAtmDAO atmDAO = new AtmDAO();
        ATM atm= atmDAO.getById(idATMs);
        log.info("You have commission - " + atm.getCommission() + " % ");
    }
}
