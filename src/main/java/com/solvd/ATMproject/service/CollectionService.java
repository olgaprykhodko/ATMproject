package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbc.realization.CollectionTimeDAO;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
public class CollectionService {
    public static void getCashCollectionTime(){
        CollectionTimeDAO cTime = new CollectionTimeDAO();
        Date date = new Date();
        if ( cTime.read(date) != null)
            log.info("The ATM is active");
        else log.info("Sorry the ATM is currently on cash collection. Please try later");
    }
}
