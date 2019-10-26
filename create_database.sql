
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
       custID       MEDIUMINT NOT NULL AUTO_INCREMENT, --max > 8mil.
       fName        VARCHAR(255) NOT NULL,
       lName        VARCHAR(255),
       street         VARCHAR(255),
       city            VARCHAR(255),
       stateInits     CHAR(2),
       zip            CHAR(5), --needs review
       email          VARCHAR(255),
       phoneNum      VARCHAR(20) --needs review
       );
       

/* service times can vary upon fulfillment.
   Start and end times are stored in 'provides'. */
CREATE TABLE service(
       servID       MEDIUMINT NOT NULL AUTO_INCREMENT, --max > 8mil.
       sName        VARCHAR(255) NOT NULL,
       description  TINYTEXT, --brief description.
       rate         DECIMAL(7, 2) UNSIGNED -- assume worst case of $50k/hr.
       );

CREATE TABLE employee(
       eID          MEDIUMINT NOT NULL AUTO_INCREMENT, --max > 8mil.
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
       
