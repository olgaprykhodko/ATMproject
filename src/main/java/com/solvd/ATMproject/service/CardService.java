package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.dao.jdbs.realization.CardDAO;
import com.solvd.ATMproject.models.Card;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CardService {
    private final static Logger LOGGER = LogManager.getLogger(CardService.class);

    public static void getStatusCardByNumberCard(String cardNumber) {

        ICardDAO cardDAO=new CardDAO();
        Card card = cardDAO.read(cardNumber);

    }
}
