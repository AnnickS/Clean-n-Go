LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//customer_data.dat"
INTO TABLE customer
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//service_data.dat"
INTO TABLE service
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//employee_data.dat"
INTO TABLE employee
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//supplier_data.dat"
INTO TABLE supplier
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//item_data.dat"
INTO TABLE item
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//consumable_data.dat"
INTO TABLE consumable
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//equipment_data.dat"
INTO TABLE equipment
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//provides_data.dat"
INTO TABLE provides
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//purchase_from_data.dat"
INTO TABLE purchased_from
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//offers_data.dat"
INTO TABLE offers
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//equipment_maintenance_data.dat"
INTO TABLE equipment_maintenance
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;
LOAD DATA LOCAL INFILE "C://CS331//cs331-project-2-clean-n-go//employee_schedule_data.dat"
INTO TABLE employee_schedule
FIELDS ENCLOSED BY "\"" TERMINATED BY ","
;