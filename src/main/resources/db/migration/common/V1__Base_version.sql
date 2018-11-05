-- Structuur van  tabel timesheet.medewerker wordt geschreven
CREATE TABLE IF NOT EXISTS `medewerker` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `achterNaam` varchar(255) DEFAULT NULL,
  `actief` int(1) NOT NULL,
  `contractUren` int(10) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `inlognaam` varchar(255) DEFAULT NULL,
  `voorNaam` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `partimeDagen` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Structuur van  tabel timesheet.auto wordt geschreven
CREATE TABLE IF NOT EXISTS `auto` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `kenteken` varchar(255) DEFAULT NULL,
  `medewerker_id` bigint(19) DEFAULT NULL,
  `vervangendVervoer` int(1) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `beginDatum` date DEFAULT NULL,
  `eindDatum` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_90wmawgmbeeyjuyxx1sfnk220` FOREIGN KEY (`medewerker_id`) REFERENCES `medewerker` (`id`)
);

-- Structuur van  tabel timesheet.DATABASECHANGELOG wordt geschreven
CREATE TABLE IF NOT EXISTS `DATABASECHANGELOG` (
  `ID` varchar(63) NOT NULL,
  `AUTHOR` varchar(63) NOT NULL,
  `FILENAME` varchar(200) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`,`AUTHOR`,`FILENAME`)
);

-- Structuur van  tabel timesheet.DATABASECHANGELOGLOCK wordt geschreven
CREATE TABLE IF NOT EXISTS `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

-- Structuur van  tabel timesheet.project wordt geschreven
CREATE TABLE IF NOT EXISTS `project` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) DEFAULT NULL,
  `standaard` int(1) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `beginDatum` date DEFAULT NULL,
  `eindDatum` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_PROJECT_NAAM` (`naam`)
);


-- Structuur van  tabel timesheet.timesheet wordt geschreven
CREATE TABLE IF NOT EXISTS `timesheet` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `jaar` int(10) NOT NULL,
  `maand` int(10) NOT NULL,
  `timesheetStatus` varchar(255) DEFAULT NULL,
  `medewerker_id` bigint(19) DEFAULT NULL,
  `opmerking` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `lastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_6mesbx1dpr7tl4ibm5afb3vjq` FOREIGN KEY (`medewerker_id`) REFERENCES `medewerker` (`id`)
);

-- Structuur van  tabel timesheet.kilometerregistratie wordt geschreven
CREATE TABLE IF NOT EXISTS `kilometerregistratie` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `beginStand` int(10) NOT NULL,
  `eindStand` int(10) NOT NULL,
  `auto_id` bigint(19) DEFAULT NULL,
  `timesheet_id` bigint(19) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_1swmsaps6ipufkn0s7b45wnnk` FOREIGN KEY (`auto_id`) REFERENCES `auto` (`id`),
  CONSTRAINT `FK_o857dh2yoynql60ono3opn9qm` FOREIGN KEY (`timesheet_id`) REFERENCES `timesheet` (`id`)
);


-- Structuur van  tabel timesheet.projectboeking wordt geschreven
CREATE TABLE IF NOT EXISTS `projectboeking` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `project_id` bigint(19) DEFAULT NULL,
  `timesheet_id` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FK_timesheet` FOREIGN KEY (`timesheet_id`) REFERENCES `timesheet` (`id`)
);


-- Structuur van  tabel timesheet.kilometerboeking wordt geschreven
CREATE TABLE IF NOT EXISTS `kilometerboeking` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `kilometers` int(11) DEFAULT NULL,
  `timesheet_id` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_timesheet_kilometers` FOREIGN KEY (`timesheet_id`) REFERENCES `timesheet` (`id`)
);

-- Structuur van  tabel timesheet.urenboeking wordt geschreven
CREATE TABLE IF NOT EXISTS `urenboeking` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `kilometerType` varchar(255) DEFAULT NULL,
  `kilometers` int(10) NOT NULL,
  `mutatieDatum` datetime DEFAULT NULL,
  `opmerking` varchar(255) DEFAULT NULL,
  `uren` double NOT NULL,
  `version` int(10) NOT NULL,
  `projectboeking_id` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_PRJB` FOREIGN KEY (`projectboeking_id`) REFERENCES `projectboeking` (`id`)
);


-- Structuur van  tabel timesheet.verlof wordt geschreven
CREATE TABLE IF NOT EXISTS `verlof` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `version` int(10) NOT NULL,
  `jaar` int(4) NOT NULL,
  `maand` int(2) DEFAULT NULL,
  `uren` double NOT NULL,
  `datum` date NOT NULL,
  `verloftype` varchar(255) NOT NULL,
  `medewerker_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_verlof_medewerker` FOREIGN KEY (`medewerker_id`) REFERENCES `medewerker` (`id`)
);

