package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbc.realization.CollectionTimeDAO;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
public class CollectionService {
    public static void getCashCollectionTime() {
        CollectionTimeDAO cTime = new CollectionTimeDAO();
        Date date = new Date();
        cTime.read(date);
        log.info("The ATM is active");
    }
}
