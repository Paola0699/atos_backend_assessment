--Paola Perez Valencia
--Assessment Backend SQL

--1 . Create 2 data table in SQLExpress (SQL senteces)
CREATE TABLE Languages(
    LanguageID int NOT NULL,
    Name varchar(50),
    PRIMARY KEY (LanguageID)
);
CREATE TABLE Countries(
    CountryID int NOT NULL,
    Name varchar(50),
    Capital varchar(50),
    Population int,
    LanguageID int,
    PRIMARY KEY (CountryID),
    FOREIGN KEY (LanguageID) REFERENCES Languages(LanguageID)
);

--2. Insert 2 records in each table (SQL senteces)
INSERT INTO Languages VALUES (1,'English');
INSERT INTO Languages VALUES (2,'French');
INSERT INTO Languages VALUES (3,'Spanish');

INSERT INTO Countries VALUES (1, 'United States','Washington DC', 329500, 1);
INSERT INTO Countries VALUES (2, 'France','Paris', 673900, 2);
INSERT INTO Countries VALUES (3, 'Canada', 'Ottawa', 10000, 1);

--3. update the first record the population field by 250000 (SQL senteces)
UPDATE Countries SET Population = 250000 WHERE CountryID = 1;

--4. Delete countries with populations greater than 100,000 (SQL senteces)
DELETE FROM Countries 
WHERE Population > 100000;

--5. Create SQLSentence  joining the 2 tables.
SELECT *
FROM Countries c JOIN Languages l 
ON c.LanguageID = l.LanguageID;

--6. Create SQL Sentence  grouping  by Languages.
SELECT COUNT(CountryID), LanguageID
FROM Countries 
GROUP BY LanguageID;

--7. Create Store Procedures (Insert,Update,Delete,Select all) 
--7.1 Insert

CREATE OR REPLACE PROCEDURE InsertCountry(
    c_ID IN COUNTRIES.COUNTRYID%TYPE,
    c_Name IN COUNTRIES.NAME%TYPE,
    c_Capital IN COUNTRIES.CAPITAL%TYPE,
    c_Population IN COUNTRIES.POPULATION%TYPE,
    c_LanguageID IN COUNTRIES.LANGUAGEID%TYPE
) IS 
BEGIN
  INSERT INTO Countries VALUES(c_ID, c_Name, c_Capital, c_Population, c_LanguageID);
COMMIT;
END;

BEGIN
InsertCountry(4,'Mexico', 'Mexico City', 230909, 1);
END;

--7.2 Update

CREATE OR REPLACE PROCEDURE UpdateCountryPopulation(
    c_ID IN COUNTRIES.COUNTRYID%TYPE,
    c_Population IN COUNTRIES.POPULATION%TYPE
) IS 
BEGIN
  UPDATE Countries SET Population = c_Population WHERE CountryID = c_ID;
COMMIT;
END;

BEGIN
UpdateCountryPopulation(4,100000);
END;

CREATE OR REPLACE PROCEDURE UpdateLanguageName(
    lan_ID IN LANGUAGES.LANGUAGEID%TYPE,
    lan_name IN LANGUAGES.NAME%TYPE
) IS 
BEGIN
  UPDATE Languages SET Name = lan_name WHERE LanguageID = lan_ID;
COMMIT;
END;

BEGIN
UpdateLanguageName(2,'Francois');
END;

--7.3 Delete
CREATE OR REPLACE PROCEDURE DeleteCountry(
    c_ID IN COUNTRIES.COUNTRYID%TYPE
) IS 
BEGIN
    DELETE FROM Countries WHERE CountryID =  c_ID;
COMMIT;
END;

BEGIN
DeleteCountry(4);
END;

CREATE OR REPLACE PROCEDURE DeleteLanguage(
    lan_ID IN LANGUAGES.LANGUAGEID%TYPE
) IS 
BEGIN
    DELETE FROM Languages WHERE LanguageID = lan_ID;
COMMIT;
END;

BEGIN
DeleteLanguage(3);
END;

--7.4 Select All
create or replace procedure selectall(retval in out sys_refcursor) is
begin
  open retval for
    select COUNTRYID, NAME from COUNTRIES;
end selectall;

 DECLARE 
   myrefcur sys_refcursor;
   c_id COUNTRIES.COUNTRYID%type;
   c_name COUNTRIES.NAME%type;
 BEGIN
   selectall(myrefcur);
   LOOP
     FETCH myrefcur INTO c_id, c_name;
     EXIT WHEN myrefcur%notfound;
     dbms_output.put_line(c_name);
   END LOOP;
   CLOSE myrefcur;
 END;