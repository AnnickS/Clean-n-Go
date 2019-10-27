
/*
    @author: Bellevue College CS 331 Group 7
    @email: nikitamog@bellevuecollege.edu 
    @description:
    mysql ddl statements to initialize the
    relational data structure of the
    cleaning shop.
*/

CREATE DATABASE clean;

USE clean;

CREATE TABLE customer(
       custID       MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, --max > 8mil.
       fName        VARCHAR(255) NOT NULL,
       lName        VARCHAR(255),
       street       VARCHAR(255),
       city         VARCHAR(255),
       stateInits   CHAR(2),
       zip          CHAR(5), --needs review
       email        VARCHAR(255),
       phoneNum     VARCHAR(20) --needs review
       );
       

/* service times can vary upon fulfillment.
   Start and end times are stored in 'provides'. */
CREATE TABLE service(
       servID       MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, --max > 8mil.
       sName        VARCHAR(255) NOT NULL,
       description  TINYTEXT, --brief description.
       rate         DECIMAL(7, 2) UNSIGNED -- assume worst case of $50k/hr.
       );

CREATE TABLE employee(
       eID          MEDIUMINT NOT NULL AUTO_INCREMENT PRIMARY KEY, --max > 8mil.
       gender       CHAR(1),
       jobTitle     VARCHAR(255), --position is a keyword
       dateHired    DATE,
       fName        VARCHAR(255),
       minit        CHAR(1),
       lName        VARCHAR(255),
       street       VARCHAR(255),
       city         VARCHAR(100), --longest name found was 89 chars.
       stateInits   CHAR(2),
       zip          CHAR(5)
       );
       
CREATE TABLE supplier(
       suppID       MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, --max > 8mil.
       sName        VARCHAR(255) NOT NULL,
       phoneNum     VARCHAR(20),
       currBalance  DECIMAL(11, 2), --we do not expect deals above 1bil.
       street       VARCHAR(255),
       city         VARCHAR(100), --longest name found was 89 chars.
       stateInits   CHAR(2),
       zip          CHAR(5)
       );
/* purchases > $1mil should consult board of directors. */
CREATE TABLE item(
       iID              MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       purchasePrice    DECIMAL(9, 2),
       iName            VARCHAR(255) NOT NULL,
       description      TINYTEXT
       );

/* americans eat 2billion cookies a year.
   At least that much soap should be accounted for. */
CREATE TABLE consumable( --aka cleaning supply
       consID            MEDIUMINT UNSIGNED NOT NULL,
       currInv           MEDIUMINT UNSIGNED NOT NULL, -- AKA Qty.
       safetyStockLvl    MEDIUMINT UNSIGNED, --SMALLINT insufficient.
       cUsage            TINYTEXT, --usage is a keyword. brief description.
       PRIMARY KEY (consID),
       FOREIGN KEY (consID) REFERENCES item(iID)
       );

/* stores equipment in use as well as their
   maintenance schedules. */
CREATE TABLE equipment(
       eID          MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       iID          MEDIUMINT UNSIGNED NOT NULL,
       eType        VARCHAR(20), -- needs review
       brand        VARCHAR(20),
       startDate    DATE NOT NULL,
       removeDate   DATE NOT NULL, -- COMPANY POLICY
       FOREIGN KEY (iID) REFERENCES item(iID)
       );
       
CREATE TABLE provides(
       custID       MEDIUMINT UNSIGNED NOT NULL,
       servID       MEDIUMINT UNSIGNED NOT NULL,
       eID          MEDIUMINT UNSIGNED NOT NULL,
       PRIMARY KEY (custID, servID, eID),
       FOREIGN KEY (custID) REFERENCES customer(custID),
       FOREIGN KEY (servID) REFERENCES service(servID),
       FOREIGN KEY (eID) REFERENCES employee(eID)
       );

CREATE TABLE purchased_from(
       transactionID        MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
       transactionDate      DATE,
       deliveryDate         DATE,
       qty                  MEDIUMINT
       );
       
