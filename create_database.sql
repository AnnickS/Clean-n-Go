
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
       CustID       MEDIUMINT NOT NULL AUTO_INCREMENT, --max > 8mil.
       fName        varchar(255) NOT NULL,
       lName        varchar(255),
       Street         varchar(255),
       City            varchar(255),
       StateInits     char(2),
       zip            char(5), --needs review
       email          varchar(255),
       phone_num      varchar(20) --needs review
       );
       

