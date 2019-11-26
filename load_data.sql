LOAD DATA LOCAL INFILE "C:/CS331/Project2/customer_data.dat"
INTO TABLE customer
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/service_data.dat"
INTO TABLE service
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/employee_data.dat"
INTO TABLE employee
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/supplier_data.dat"
INTO TABLE supplier
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/item_data.dat"
INTO TABLE item
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/consumable_data.dat"
INTO TABLE consumable
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/equipment_data.dat"
INTO TABLE equipment
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/provides_data.dat"
INTO TABLE provides
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/purchase_from_data.dat"
INTO TABLE purchase_from
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/offers_data.dat"
INTO TABLE offers
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/equipment_maintenance_data.dat"
INTO TABLE equipment_maintenance
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C:/CS331/Project2/employee_schedule_data.dat"
INTO TABLE employee_schedule
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;