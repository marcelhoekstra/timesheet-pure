DROP INDEX UQ_PROJECT_NAAM on project;
CREATE unique INDEX `naam_medewerker_id` ON project (`naam`, `medewerker_id`);