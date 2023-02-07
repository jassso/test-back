CREATE DATABASE finantial_schema;

USE finantial_schema;
 

CREATE TABLE IF NOT EXISTS `investments` (
	`id` INTEGER PRIMARY KEY,
	`year` INTEGER,
	`initial_balance` NUMERIC(20,2),
	`contribution` NUMERIC(20,2),
	`investment_return` NUMERIC(20,2),
	`final_balance` NUMERIC (20,2));