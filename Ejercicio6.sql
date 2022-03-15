|================================== "CREACIÓN TABLAS" =================================|

CREATE TABLE Countries(
CountryID INT,
CountryName VARCHAR(50),
CountryCode VARCHAR(3)
);

---------------------------------------------------------------------------------------

CREATE TABLE States(
StateID INT,
StateName VARCHAR(50),
StateCode VARCHAR(3),
CountryID INT);

|================================== "INSERTS TABLAS" ==================================|

INSERT INTO Countries VALUES (1,'United States','USA');
INSERT INTO Countries VALUES (1,'United States','USA');

---------------------------------------------------------------------------------------

INSERT INTO States VALUES (1,'Texas','TX',1);
INSERT INTO States VALUES (2,'Arizona','AZ',1);

|=============================== "RESTRICCIONES TABLAS" ===============================|

ALTER TABLE Countries
ADD CONSTRAINT PK_Countries
PRIMARY KEY (CountryID);

---------------------------------------------------------------------------------------

ALTER TABLE States
ADD CONSTRAINT PK_States
PRIMARY KEY (StateID);

ALTER TABLE States
ADD CONSTRAINT FK_States
FOREIGN KEY (CountryID) REFERENCES Countries (CountryID);

|=========================== "MODIFICACIONES RESTRICCIONES" ===========================|

ALTER TABLE States 
ADD CONSTRAINT FK_StatesV2 
FOREIGN KEY (CountryID) REFERENCES Countries (CountryID) 
ON DELETE CASCADE;

DELETE FROM Countries WHERE CountryID=1;
