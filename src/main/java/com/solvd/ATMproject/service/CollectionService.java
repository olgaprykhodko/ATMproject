package com.solvd.ATMproject.service;

import com.solvd.ATMproject.dao.jdbc.realization.CollectionTimeDAO;
import com.solvd.ATMproject.models.CashCollection;
import lombok.extern.log4j.Log4j2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class CollectionService {
    public static void getCashCollectionTime() throws ParseException {
        CollectionTimeDAO cTime = new CollectionTimeDAO();
        Date date = new Date();
        cTime.read(date);
        log.info("The ATM is active");
    }
}
