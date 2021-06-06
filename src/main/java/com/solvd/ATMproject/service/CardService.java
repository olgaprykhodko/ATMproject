//package com.solvd.ATMproject.service;
//
//import com.solvd.ATMproject.dao.interfaces.ICardDAO;
//import com.solvd.ATMproject.dao.realization.CardDAO;
//import com.solvd.ATMproject.models.Card;
//import com.solvd.ATMproject.models.User;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class CardService {
//    private final static Logger LOGGER = LogManager.getLogger(CardService.class);
//
//    public static void getStatusCardByNumberCard(long cardNumber) {
//
//        ICardDAO cardDAO=new CardDAO();
//        Card card = cardDAO.getById(card.getStatus());
//
//        LOGGER.info(String.format("\n" +
//                        "card Number: %s\n"+
//                        "status: %s",
//                card.getStatus()));
//    }
//}
