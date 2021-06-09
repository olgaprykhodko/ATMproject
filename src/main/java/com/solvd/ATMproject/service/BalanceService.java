package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.dao.jdbc.realization.CardDAO;
import com.solvd.ATMproject.models.Card;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BalanceService {
    public static void getCardBalance(String cardNumber) {
        ICardDAO cardDAO = new CardDAO();
        Card card = cardDAO.read(cardNumber);
        log.info("Your balance of card number - "+ cardNumber+" is " + card.getBalance());
    }
}
