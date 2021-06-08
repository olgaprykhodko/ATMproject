package com.solvd.ATMproject.dao.interfaces;

import com.solvd.ATMproject.models.ATM;

public interface IJoinDAO extends IEntityDAO<ATM, String> {
    ATM getAtmByStreet (String street);
}
