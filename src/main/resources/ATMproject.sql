CREATE DATABASE ATMproject;
USE ATMProject;
CREATE TABLE users(
idUsers INT NOT NULL AUTO_INCREMENT,
name VARCHAR(15) NOT NULL,
surname VARCHAR(25) NOT NULL,
phoneNumber VARCHAR(45) NOT NULL,
PRIMARY KEY (idUsers)
);
INSERT INTO users(name,surname, phoneNumber) VALUES ('Ivan','Ivanov','0951234123'),
																	  ('Petr','Petrov','0955678567'),	
																	  ('Stepan','Stepanov','0951234432'),
                                                                      ('Alina','Alinova','0661237911'),
                                                                      ('Katya','Katina','0506663337');

CREATE TABLE cards(
idCards INT NOT NULL AUTO_INCREMENT,
balance INT NOT NULL,
status VARCHAR(16) NOT NULL,
cardNumber VARCHAR(16) NOT NULL,
PIN VARCHAR(4) NOT NULL,
UsersIdUsers INT NOT NULL,
PRIMARY KEY (idCards),
FOREIGN KEY (UsersIdUsers) REFERENCES Users (idUsers) ON DELETE CASCADE
);
INSERT INTO cards (balance,status,cardNumber, PIN,usersIdUsers) VALUES (800,'active','1234123412341234','1234',1),
																		(500,'blocked','5678567856785678','5678',1),
																		(1000,'active','1234432112344321','4321',2),
																		(950,'active','1222111133334445','5673',4),
																		(718,'active','7777777777777777','7777',5); 

CREATE TABLE ATMs(
idATMs INT NOT NULL AUTO_INCREMENT,
banknote VARCHAR(45) NOT NULL,
commission INT NOT NULL,
Cards_idCards  INT NOT NULL,
PRIMARY KEY (idATMs),
FOREIGN KEY (CardsIdCards) REFERENCES Cards(idCards) ON DELETE CASCADE
);
INSERT INTO ATMs(banknote, commission,CardsIdCards) VALUES ('belRub',5,1),                                          
                                                           ('dollar',5,2),
                                                              ('UAH',5,3);																

CREATE TABLE banks(
idBanks INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
registerNumber VARCHAR(5) NOT NULL,
ATMsIdATMs INT NOT NULL,
PRIMARY KEY(idBanks),
FOREIGN KEY(ATMsIdATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO banks (name,registerNumber,ATMsIdATMs) VALUES ('BelarusBank','11111',1),
										                   ('PrivateBank','22222',2),
                                                           ('BTABank','33333',3);
              																																																														
CREATE TABLE cashCollection(
idCashCollection INT NOT NULL AUTO_INCREMENT,
schedule VARCHAR(10) NOT NULL,
ATMsIdATMs INT NOT NULL,
PRIMARY KEY(idCashCollection),
FOREIGN KEY (ATMsIdATMs) REFERENCES ATMs (idATMs) ON DELETE CASCADE
);

INSERT INTO cashCollection(schedule ,ATMsIdATMs) VALUES ('active',1),													
                                                     ('blocked',2),                                                    											
                                                     ('active',3);
CREATE TABLE banknotes(
idBanknotes INT NOT NULL AUTO_INCREMENT,
denomination INT NOT NULL,
numberOfBanknotes INT NOT NULL,
PRIMARY KEY(idBanknotes)
);
INSERT INTO banknotes(denomination,numberOfBanknotes) VALUES (10,13),
												  (50,21),
                                                  (100,19),
                                                  (500,7),
                                                  (1000,40),
                                                  (200,90),
                                                  (100,34),
                                                  (10,10),
                                                  (20,2);
 
 CREATE TABLE ATMsHasBanknotes(
 ATMsIdATMs INT NOT NULL,
 BanknotesIdBanknotes INT NOT NULL,
 FOREIGN KEY (ATMsIdATMs) REFERENCES ATMs (idATMs),
 FOREIGN KEY (BanknotesIdBanknotes) REFERENCES Banknotes(idBanknotes)
 );
 INSERT INTO ATMsHasBanknotes (ATMsIdATMs,BanknotesIdBanknotes) VALUES (1,1),
																			(1,2),
                                                                            (1,3),
                                                                            (1,4),
                                                                            (1,5),
                                                                            (1,6),
                                                                            (2,1),
																		    (2,2),
                                                                            (2,3),
                                                                            (2,4),
                                                                            (3,1),
                                                                            (3,2),
                                                                            (3,4);																														
CREATE TABLE Address(
idAddress INT NOT NULL AUTO_INCREMENT,
street VARCHAR(45) NOT NULL,
country VARCHAR(45) NOT NULL,
ATMs_idATMs INT NOT NULL,
PRIMARY KEY(idAddress),
FOREIGN KEY (ATMsIdATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO address (street,country,ATMsIdATMs) VALUES ('Mira 45','Ukraine',1),
											('Proletarskaya 34','Belarus',2),
                                            ('Pryluzhna 4/15','Ukraine',3);
CREATE TABLE Operations(
idOperations INT NOT NULL AUTO_INCREMENT,
operationName VARCHAR(45) NOT NULL,
operationCode INT NOT NULL,
PRIMARY KEY (idOperations)
);
INSERT INTO Operations(operationName,operationCode) VALUES ('payment of the penalty',01),
								('payment of utility services',02),
                                ('mobile phone replenishment',03),
                                ('cash withdrawal',04),
                                ('money exchange',05),
                                ('money input',06);

 CREATE TABLE ATMsHasOperations(
 ATMsIdATMs INT NOT NULL,
 OperationsIdOperations INT NOT NULL,
 FOREIGN KEY (ATMsIdATMs) REFERENCES ATMs (idATMs),
 FOREIGN KEY (OperationsIdOperations) REFERENCES Operations(idOperations)
 );
 INSERT INTO ATMsHasOperations (ATMsIdATMs,OperationsIdOperations) VALUES (1,1),
																			  (1,2),
                                                                              (1,3),
                                                                              (1,4),
                                                                              (1,5),
                                                                              (2,1),
                                                                              (2,2),
                                                                              (2,3),
                                                                              (2,4),
                                                                              (3,1),
                                                                              (3,2),
                                                                              (3,3),
                                                                              (3,4);
                                          
                                          
                                          
                                          
                                          
                                          

                                                                      
