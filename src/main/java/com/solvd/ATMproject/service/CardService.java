package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.dao.jdbc.realization.CardDAO;

import com.solvd.ATMproject.models.Card;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CardService {
    public static Card getStatusCardByNumberCard(String cardNumber) {
        ICardDAO cardDAO = new CardDAO();
        return cardDAO.read(cardNumber);
    }
}
