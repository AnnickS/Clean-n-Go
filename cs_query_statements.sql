/*
1.	When the user chooses option 1(Analyze the progress of the business) from the interface in Figure 2, it should take you to new UI interface that gives the options to retrieve the following:
a.	Option A (Total number of new customers): It should present the total number of new customers during the current year.
b.	Option B (Total number of service transactions): It should present the total number of service transactions during the current month.
*/
/*1a*/
SELECT count(custID)
FROM customer
WHERE YEAR(signDate) = 2019;
/*1b*/
SELECT count(*)
FROM uses
WHERE YEAR(useDate) = 2019
	AND MONTH(useDate) = 11;

 /*
2.	When the user choose option 2 (Services) from the main interface it should take you 
	 to a new UI interface that gives the option to retrieve the following
a.	Option A (Requested services): It should report the most requested type of service.
b.	Option B (Service transactions): Total number of service transactions per month during the last six months. 
c.	Option C (Annual revenues from services): It calculates the annual 
	 revenues from services provided to customers. Group this information by service type. 
*/
/*2a*/
SELECT S.sName, U.servID, count(*)
FROM service AS S, uses as U
WHERE U.servID = S.servID
GROUP BY servID
ORDER BY count(*) DESC;
/*2b*/
SELECT MONTH(useDate), count(*)
FROM uses
WHERE YEAR(useDate) = 2019
	AND MONTH(useDate) >= 5
	AND MONTH(useDate) < 12
GROUP BY MONTH(useDate);
/*2c*/
SELECT sName, SUM(S.rate * S.servTime)
FROM service AS S, uses AS U
WHERE S.servID = U.servID
	AND YEAR(useDate) = 2019
GROUP BY sName;



/*
3.	When the user chooses option 3 (Customers) from the main interface it should take you 
	to new UI interface that gives the option to retrieve the following
a.	Option A (Customer list for a service) It should prompt for the name of a service and 
	returns a list of customers they used it. 
b.	Option B (Customers number): It should present the total number of customers per month 
	during the year. The application prompt for the year data.
*/
/*3a*/
SELECT sName
FROM service;

SELECT fName, lName
FROM customer AS C, uses AS U, service AS S
WHERE C.custID = U.cId
	AND U.servID = S.servID
	AND sName like "%coin washing%";
/*3b*/
SELECT Month(useDate), count(*)
FROM customer AS C, uses AS U
WHERE C.custID = U.cID
	AND YEAR(useDate) = 2019
GROUP BY MONTH(useDate);





