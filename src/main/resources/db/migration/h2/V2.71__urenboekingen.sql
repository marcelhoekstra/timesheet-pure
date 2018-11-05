DROP TABLE projectboeking;
DROP TABLE uren_boekingen;
CREATE TABLE IF NOT EXISTS `uren_boekingen` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `kilometerType` varchar(255) DEFAULT NULL,
  `kilometers` int(10) NOT NULL,
  `mutatieDatum` datetime DEFAULT NULL,
  `opmerking` varchar(255) DEFAULT NULL,
  `uren` double NOT NULL,
  `version` int(10) NOT NULL,
  `project_id` bigint(19) DEFAULT NULL,
  `timesheet_id` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
