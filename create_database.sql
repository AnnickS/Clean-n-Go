
/*
    @author: Bellevue College CS 331 Group 7
    @email: nikitamog@bellevuecollege.edu 
    @description:
    mysql ddl statements to initialize the
    relational data structure of the
    cleaning shop.
*/

CREATE DATABASE IF NOT EXISTS clean;

USE clean;

/* zip and phone num need review */
CREATE TABLE customer(
       custID       MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       fName        VARCHAR(255) NOT NULL,
       lName        VARCHAR(255),
       street       VARCHAR(255),
       city         VARCHAR(255),
       stateInits   CHAR(2),
       zip          CHAR(5),
       email        VARCHAR(255),
       phoneNum     VARCHAR(20),
       CONSTRAINT contactInfoUnique UNIQUE (phoneNum, email),
       INDEX address (street, city, stateInits, zip),
       INDEX cName (fName, lName)
       );
       

/* service times can vary upon fulfillment.
   Start and end times are stored in 'provides'.
   description must be brief.
   rate assumes a worst case of $50k/hr.
 */
CREATE TABLE service(
       servID       MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       sName        VARCHAR(255) NOT NULL,
       description  TINYTEXT,
       rate         DECIMAL(7, 2) UNSIGNED
       );

/*
    Primary key max > 8 million.
    Longest city name found was 89 characters
    after some short research.
*/
CREATE TABLE employee(
       eID          MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       gender       CHAR(1),
       jobTitle     VARCHAR(255),
       dateHired    DATE,
       fName        VARCHAR(255),
       minit        CHAR(1),
       lName        VARCHAR(255),
       street       VARCHAR(255),
       city         VARCHAR(100),
       stateInits   CHAR(2),
       zip          CHAR(5),
       INDEX eName (fName, minit, lName)
       );

/* Primary key max > 8 million
   current balance assumes no amounts more than $1bil
*/
CREATE TABLE supplier(
       suppID       MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       sName        VARCHAR(255) NOT NULL,
       phoneNum     VARCHAR(20),
       currBalance  DECIMAL(11, 2),
       street       VARCHAR(255),
       city         VARCHAR(100),
       stateInits   CHAR(2),
       zip          CHAR(5),
       INDEX address (street, city, stateInits, zip)       
       );

/* purchases > $1mil should consult board of directors. */
CREATE TABLE item(
       iID              MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       purchasePrice    DECIMAL(9, 2),
       iName            VARCHAR(255) NOT NULL,
       description      TINYTEXT
       );

/* aka cleaning supply
   currInv represents qty
   americans eat 2billion cookies a year.
   At least that much soap should be accounted for
   within for safetystocks.
   usage is a sql keyword
 */
CREATE TABLE consumable(
       consID            MEDIUMINT UNSIGNED NOT NULL,
       currInv           MEDIUMINT UNSIGNED NOT NULL,
       safetyStockLvl    MEDIUMINT UNSIGNED,
       cUsage            TINYTEXT,
       PRIMARY KEY (consID),
       FOREIGN KEY (consID) REFERENCES item(iID)
       );

/* stores equipment in use as well as their
   maintenance schedules. 
   type name needs review.
   start and remove dates are REQUIRED
   because of COMPANY POLICY.
*/
CREATE TABLE equipment(
       eID          MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       iID          MEDIUMINT UNSIGNED NOT NULL,
       eType        VARCHAR(20),
       brand        VARCHAR(20),
       startDate    DATE NOT NULL,
       removeDate   DATE NOT NULL,
       FOREIGN KEY (iID) REFERENCES item(iID),
       INDEX maintenanceSchedule (startDate, removeDate)
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

/* A purchase manifest of each transaction between
   the cleaning company and a supplier. */
CREATE TABLE purchased_from(
       transactionID        MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
       iID                  MEDIUMINT UNSIGNED NOT NULL,
       suppID               MEDIUMINT UNSIGNED NOT NULL,
       transactionDate      DATE,
       deliveryDate         DATE,
       qty                  MEDIUMINT,
       FOREIGN KEY (iID) REFERENCES item(iID),
       FOREIGN KEY (suppID) REFERENCES supplier(suppID)
       );

/*
    Tracks items available for purchase
    from each supplier.
*/
CREATE TABLE offers(
       iID           MEDIUMINT UNSIGNED NOT NULL,
       suppID           MEDIUMINT UNSIGNED NOT NULL,
       PRIMARY KEY (iID, suppID),
       FOREIGN KEY (suppID) REFERENCES supplier(suppID),
       FOREIGN KEY (iID) REFERENCES item(iID)
       );

/* tracks the items and amounts used
   during a service. */
CREATE TABLE uses(
       servID   MEDIUMINT UNSIGNED NOT NULL,
       iID      MEDIUMINT UNSIGNED NOT NULL,
       qty      MEDIUMINT UNSIGNED,
       PRIMARY KEY (servID, iID),
       FOREIGN KEY (servID) REFERENCES service(servID),
       FOREIGN KEY (iID) REFERENCES item(iID)
);
