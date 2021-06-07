package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.ICardDAO;
import com.solvd.ATMproject.dao.jdbs.realization.CardDAO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CardService {
    public static void getStatusCardByNumberCard(String cardNumber) {
        ICardDAO cardDAO = new CardDAO();
        cardDAO.read(cardNumber);
    }
}
