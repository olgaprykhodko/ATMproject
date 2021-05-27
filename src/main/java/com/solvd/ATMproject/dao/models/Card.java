package java.com.solvd.ATMproject.dao.models;

import lombok.Data;

@Data
public class Card {
    int idCard;
    int balance;
    String status;
    User isUser;
}