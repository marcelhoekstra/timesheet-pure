ALTER TABLE urenboeking RENAME TO uren_boekingen;
ALTER TABLE `uren_boekingen`
	ADD COLUMN `project_id` BIGINT NULL;

ALTER TABLE `uren_boekingen`
    	ADD COLUMN `timesheet_id` BIGINT NULL;





