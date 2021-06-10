package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IBalanceDAO;
import com.solvd.ATMproject.dao.jdbc.realization.BalanceDAO;
import com.solvd.ATMproject.models.Card;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BalanceService {
    public static void getCardBalance(String cardNumber) {
        IBalanceDAO balanceDAO = new BalanceDAO();
        Card card = balanceDAO.read(cardNumber);
        log.info("Balance on your card: " + card.getBalance());
    }
}
