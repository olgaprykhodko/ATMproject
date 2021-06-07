package com.solvd.ATMproject.dao.interfaces;

import com.solvd.ATMproject.models.Card;

public interface IBalanceDAO extends IEntityDAO<Card, Integer>{
    void read(int T);
}
