package com.solvd.ATMproject.dao.interfaces;

import com.solvd.ATMproject.models.Card;

public interface ICardDAO extends IEntityDAO<Card>{

    Card getById(int cardNumber);
}
