package java.com.solvd.ATMproject.dao.models;

import lombok.Data;

import java.util.Date;

@Data
public class CashCollection {
    int idCashCollection;
    Date schedule;
    String responsible;
}