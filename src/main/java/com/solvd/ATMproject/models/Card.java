package com.solvd.ATMproject.models;

import lombok.Data;

@Data
public class Card {
    int idCard;
    int balance;
    String status;
<<<<<<< HEAD
    int idUser;
=======
    int cardNumber;
    int PIN;
    User isUser;
>>>>>>> 915ca7cd0734faf34118fb487e885497786f5bb9
}