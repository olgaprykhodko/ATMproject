package java.com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class Bank {
    int idBank;
    String name;
    int registerNumber;
    ATM idATM;
}