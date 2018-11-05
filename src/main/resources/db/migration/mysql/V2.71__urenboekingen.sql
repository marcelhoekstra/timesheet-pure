DELETE FROM projectboeking where timesheet_id is null;
UPDATE
    uren_boekingen ub,
    projectboeking pb
SET
    ub.project_id = pb.project_id,
    ub.timesheet_id = pb.timesheet_id
WHERE
    ub.projectboeking_id = pb.id;
ALTER TABLE uren_boekingen MODIFY project_id BIGINT NOT NULL;
ALTER TABLE uren_boekingen MODIFY timesheet_id BIGINT NOT NULL;
ALTER TABLE uren_boekingen DROP FOREIGN KEY `FK_PRJB`;
ALTER TABLE `uren_boekingen` DROP INDEX `FK_PRJB`;

ALTER TABLE uren_boekingen drop column projectboeking_id;

DROP TABLE projectboeking;