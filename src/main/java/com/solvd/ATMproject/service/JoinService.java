package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.interfaces.IAtmDAO;
import com.solvd.ATMproject.dao.jdbc.realization.AtmDAO;
import com.solvd.ATMproject.dao.jdbc.realization.JoinDAO;

public class JoinService {
    public static void getATMByStreet(int ATMsIdATMs){
        JoinDAO joinDAO=new JoinDAO();
        joinDAO.getAtmByStreet("Mira");
    }
}
