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
FOREIGN KEY (Cards_idCards) REFERENCES Cards(idCards) ON DELETE CASCADE
);
INSERT INTO ATMs(banknote, commission,Cards_idCards) VALUES ('belRub',5,1),                                          
                                                           ('dollar',5,2),
                                                              ('UAH',5,3);																

CREATE TABLE banks(
idBanks INT NOT NULL AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
registerNumber VARCHAR(5) NOT NULL,
ATMs_idATMs INT NOT NULL,
PRIMARY KEY(idBanks),
FOREIGN KEY(ATMs_idATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO banks (name,registerNumber,ATMs_idATMs) VALUES ('BelarusBank','11111',1),
										                   ('PrivateBank','22222',2),
                                                           ('BTABank','33333',3);
              																																																														
CREATE TABLE cash_collection(
idCash_Collection INT NOT NULL AUTO_INCREMENT,
schedule DATETIME NOT NULL,
ATMs_idATMs INT NOT NULL,
PRIMARY KEY(idCash_Collection),
FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs (idATMs) ON DELETE CASCADE
);

INSERT INTO cash_collection(schedule ,ATMs_idATMs) VALUES ('2021-06-08',1),
													 ('2021-06-09',1),
                                                     ('2021-06-10',2),
                                                     ('2021-06-06',2),
                                                     ('2021-06-08',3),
                                                     ('2021-06-10',3);
CREATE TABLE banknotes(
idBanknotes INT NOT NULL AUTO_INCREMENT,
denomination INT NOT NULL,
number_of_banknotes INT NOT NULL,
PRIMARY KEY(idBanknotes)
);
INSERT INTO banknotes(denomination,Number_of_banknotes) VALUES (10,13),
												  (50,21),
                                                  (100,19),
                                                  (500,7),
                                                  (1000,40),
                                                  (200,90),
                                                  (100,34),
                                                  (10,10),
                                                  (20,2);
 
 CREATE TABLE ATMs_has_Banknotes(
 ATMs_idATMs INT NOT NULL,
 Banknotes_idBanknotes INT NOT NULL,
 FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs (idATMs),
 FOREIGN KEY (Banknotes_idBanknotes) REFERENCES Banknotes(idBanknotes)
 );
 INSERT INTO ATMs_has_Banknotes (ATMs_idATMs,Banknotes_idBanknotes) VALUES (1,1),
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
FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs(idATMs) ON DELETE CASCADE
);
INSERT INTO address (street,country,ATMs_idATMs) VALUES ('Mira 45','Ukraine',1),
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

 CREATE TABLE ATMs_has_Operations(
 ATMs_idATMs INT NOT NULL,
 Operations_idOperations INT NOT NULL,
 FOREIGN KEY (ATMs_idATMs) REFERENCES ATMs (idATMs),
 FOREIGN KEY (Operations_idOperations) REFERENCES Operations(idOperations)
 );
 INSERT INTO ATMs_has_Operations (ATMs_idATMs,Operations_idOperations) VALUES (1,1),
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
                                          
                                          
                                          
                                          
                                          
                                          

                                                                      
