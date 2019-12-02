/*
	Insert Menu Functions
*/
DELIMITER $$

/*Equipment*/
CREATE PROCEDURE insertEquipment(IN eID MEDIUMINT UNSIGNED, IN iID MEDIUMINT UNSIGNED, IN eType VARCHAR(20),
IN brand VARCHAR(20), IN installationDate DATE, IN removeDate DATE)
BEGIN
INSERT INTO equipment
VALUES(eID, iID, eType, brand, installationDate, removeDate);
END$$

/*Service*/
CREATE PROCEDURE insertService(IN servID MEDIUMINT UNSIGNED, IN sName VARCHAR(255), IN description TINYTEXT,
IN rate DECIMAL(7,2) UNSIGNED, IN satRating TINYINT, IN startTime TIMESTAMP, IN endTIME TIMESTAMP)
BEGIN
INSERT INTO service
VALUES(servID, sName, description, rate, satRating, startTime, endTime);
END$$

/*Customer*/
CREATE PROCEDURE insertCustomer(IN custID MEDIUMINT UNSIGNED, IN fName VARCHAR(255), IN lName VARCHAR(255),
IN street VARCHAR(255), IN city VARCHAR(255), IN stateInits CHAR(2), IN zip CHAR(5), IN email VARCHAR(255),
IN phoneNum VARCHAR(20), currBalance DECIMAL(14,2), creditCard CHAR(16))
BEGIN
INSERT INTO customer
VALUES(cusID, fName, lName, street, city, stateInits, zip, email, phoneNum, currBalance,
creditCard);
END$$

/*Employee*/
CREATE PROCEDURE insertEmployee(IN eID MEDIUMINT UNSIGNED, IN gender CHAR(1), IN jobTitle VARCHAR(255),
IN dateHired DATE, IN fName VARCHAR(255), IN minit CHAR(1), IN lNAME VARCHAR(255), IN street VARCHAR(255),
IN city VARCHAR(255), IN stateInits CHAR(2), IN zip CHAR(5))
BEGIN
INSERT INTO employee
VALUES(eID, gender, jobTitle, dateHired, fName, minit, lName, street, city, stateInits, zip);
END$$

DELIMITER ;


DROP PROCEDURE insertEquipment;
DROP PROCEDURE insertService;
DROP PROCEDURE insertCustomer;
DROP PROCEDURE insertEmployee;
/*
	Update Menu Functions
*/
/*Equipment*/
/*CREATE PROCEDURE updateEquipment(
	@eID MEDIUMINT UNSIGNED,
    @iID MEDIUMINT UNSIGNED,
    @eType VARCHAR(20),
	@brand VARCHAR(20),
    @installationDate DATE,
    @removeDate DATE
    AS
    BEGIN
		SET NOCOUNT ON;
        UPDATE equipment
        SET
        
    UPDATE tableName
    SET change
    WHERE parameter
        */
/*Service*/
/*Customer*/
/*Employee*/

/*
	Delete Menu Functions
*/

DELIMITER $$
/*Equipment*/
CREATE PROCEDURE deleteEquip(IN columnName VARCHAR(255), IN reqCon VARCHAR(255))
BEGIN

DECLARE sql1 VARCHAR(2000);

SET @sql1 = CONCAT('DELETE FROM equipment WHERE ', columnName, ' = ', reqCon, ' ;');
PREPARE sql2 FROM @sql1;
EXECUTE sql2;
END$$

/*Service*/
CREATE PROCEDURE deleteServ(IN columnName VARCHAR(255), IN reqCon VARCHAR(255))
BEGIN

DECLARE sql1 VARCHAR(2000);

SET @sql1 = CONCAT('DELETE FROM service WHERE ', columnName, ' = ', reqCon, ' ;');
PREPARE sql2 FROM @sql1;
EXECUTE sql2;
END$$

/*Customer*/
CREATE PROCEDURE deleteCust(IN columnName VARCHAR(255), IN reqCon VARCHAR(255))
BEGIN

DECLARE sql1 VARCHAR(2000);

SET @sql1 = CONCAT('DELETE FROM customer WHERE ', columnName, ' = ', reqCon, ' ;');
PREPARE sql2 FROM @sql1;
EXECUTE sql2;
END$$

/*Employee*/
CREATE PROCEDURE deleteEmpl(IN columnName VARCHAR(255), IN reqCon VARCHAR(255))
BEGIN

DECLARE sql1 VARCHAR(2000);
DECLARE ret INT;

SET @sql1 = CONCAT('DELETE FROM employee WHERE ', columnName, ' = ', reqCon, ' ;');
PREPARE sql2 FROM @sql1;
EXECUTE sql2;
END$$


/*
	Show List Functions
*/
CREATE PROCEDURE showEq()
BEGIN
SELECT * FROM PROJECT2.equipment;
END$$

CREATE PROCEDURE showSer()
BEGIN
SELECT * FROM PROJECT2.service;
END$$

CREATE PROCEDURE showCus()
BEGIN
SELECT * FROM PROJECT2.customer;
END$$

CREATE PROCEDURE showEmp()
BEGIN
SELECT * FROM PROJECT2.employee;
END$$
DELIMITER ;

DROP PROCEDURE deleteEquip;
DROP PROCEDURE deleteServ;
DROP PROCEDURE deleteCust;
DROP PROCEDURE deleteEmpl;
DROP PROCEDURE showEq;
DROP PROCEDURE showSer;
DROP PROCEDURE showCus;
DROP PROCEDURE showEmp;

CALL deleteServ('SName', 'drop-off');
CALL deleteCust("fName", "\'John\'");
CALL deleteEquip('iID', '9');
DELETE FROM customer WHERE fName = 'Gareth';