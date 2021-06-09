package com.solvd.ATMproject.dao.interfaces;

import com.solvd.ATMproject.models.ATM;
import com.solvd.ATMproject.models.Address;

public interface IAddressDAO extends IEntityDAO<Address, String> {
    ATM getBy(String T);
}
