CREATE DATABASE ATMProject;
USE ATMProject;
CREATE TABLE users(
idUsers INT NOT NULL AUTO_INCREMENT,
name VARCHAR(15) NOT NULL,
surname VARCHAR(25) NOT NULL,
cardNumber VARCHAR(16) NOT NULL,
PIN VARCHAR(4) NOT NULL,
phoneNumber VARCHAR(45) NOT NULL,
PRIMARY KEY (idUsers)
);
INSERT INTO users(idUsers, name, cardNumber, PIN, phoneNumber) VALUES ('Ivan','Ivanov','1234123412341234','1234','0951234123'),
																	  ('Petr','Petrov','5678567856785678','5678','0955678567'),	
																	  ('Stepan','Stepanov','1234432112344321','4321','0951234432'),
                                                                      ('Alina','Alinova','1222111133334445','5673','0661237911'),
                                                                      ('Katya','Katina','7777777777777777','7777','0506663337');
																

CREATE TABLE cards(
idCards INT NOT NULL AUTO_INCREMENT,
balance INT NOT NULL,
status VARCHAR(16) NOT NULL,
users_idUsers INT NOT NULL,
banks_idBanks INT NOT NULL,
FOREIGN KEY (users_idUsers) REFERENCES USERS(idUsers) ON DELETE CASCADE,
FOREIGN KEY (banks_idBanks) REFERENCES BANKS(idBanks) ON DELETE CASCADE
);
INSERT INTO cards (balance,status) VALUES (800,'active'),
										  (500,'blocked'),
                                          (1000,'active'),
                                          (950,'active'),
                                          (718,'active'),
                                          (120,'blocked');                                          																								
                                          
CREATE TABLE ATMs(
idATM INT NOT NULL AUTO_INCREMENT,
banknote VARCHAR(45) NOT NULL,
commission INT NOT NULL,
FOREIGN KEY (banknotes_idBanknotes) REFERENCES BANKNOTES(idBanknotes) ON DELETE CASCADE
);
INSERT INTO ATMs(banknote, commission) VALUES ('belRub',5),                                          
                                              ('dollar',5),
                                              ('UAH',5);
CREATE TABLE cash_collection(
idCash_Collection INT NOT NULL AUTO_INCREMENT,
schedule DATETIME NOT NULL,
status VARCHAR(45) NOT NULL,
FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs (idATMs) ON DELETE CASCADE
);
INSERT INTO cash_collection(schedule ,status) VALUES (2021-05-25, 'on cash collection'),
													 (2021-06-01,'not on cash collection'),
                                                     (2021-06-02,'on cash collection'),
                                                     (2021-06-03,'not on cash collection'),
                                                     (2021-06-04,'on cash collection'),
                                                     (2021-06-05,'not on cash collection');
CREATE TABLE banknotes(
idBanknote INT NOT NULL AUTO_INCREMENT,
denomination INT NOT NULL,
number_of_banknotes INT NOT NULL
);
INSERT INTO banknotes(denomination,number) VALUES (10,13),
												  (50,21),
                                                  (100,19),
                                                  (500,7),
                                                  (1000,40),
                                                  (200,90),
                                                  (100,34),
                                                  (10,10),
                                                  (20,2);
CREATE TABLE banks(
idBanks INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
registerNumber VARCHAR(5) NOT NULL,
FOREIGN KEY (Address_idAddress) REFERENCES Address(idAddress) ON DELETE CASCADE,
FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO banks (name,registerNumber) VALUES ('BelarusBank','11111'),
										       ('PrivateBank','22222'),
                                               ('BTABank','33333'),
                                               ('AlfaBank','44444');
                                          
CREATE TABLE Address(
idAddress INT NOT NULL AUTO_INCREMENT,
street VARCHAR(45) NOT NULL,
country VARCHAR(45) NOT NULL,
FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO address (street,country) VALUES ('Mira','Ukraine'),
											('Proletarskaya','Belarus'),
                                            ('Pryluzhna','Ukraine');
CREATE TABLE Operations(
idOperations INT NOT NULL AUTO_INCREMENT,
operationName VARCHAR(45) NOT NULL,
operationCode INT NOT NULL,
FOREIGN KEY(ATMs_idATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO Operations() VALUES ('payment of the penalty',01),
								('payment of utility services',02),
                                ('mobile phone replenishment',03),
                                ('cash withdrawal',04),
                                ('money exchange',05),
                                ('money input',06);
                                          
                                          
                                          
                                          
                                          
                                          
                                          

                                                                      
