package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IBalanceDAO;
import com.solvd.ATMproject.dao.jdbc.realization.BalanceDAO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BalanceService {
    public static void getCardBalance(int balance) {
        IBalanceDAO balanceDAO = new BalanceDAO();
        balanceDAO.read(balance);
    }
}
