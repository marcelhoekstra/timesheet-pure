-- wachtwoord is quintor
INSERT INTO `medewerker` (`id`, `achterNaam`, `actief`, `contractUren`, `email`, `inlognaam`, `voorNaam`, `version`, `password`, `partimeDagen`) VALUES
	(1, 'Hoekstra', 0, 36, 'ma@m.nl', 'mhoekstra', 'Marcel', 1, '$2a$10$AHwjXk3dwl2JgvyTTdmsZ.MZkEfQj33qhG0EcLqRuSjJDzkC.f.Eu', 'option2'),
	(2, 'hoekstra', 1, 40, 'hoekstra.marcel@gmail.com', 'corrie', 'corrie', 0, '$2a$10$AHwjXk3dwl2JgvyTTdmsZ.MZkEfQj33qhG0EcLqRuSjJDzkC.f.Eu', NULL),
	(3, 'hoekstra', 1, 40, 'thomas@gmail.com', 'thomas', 'thomas', 0, '$2a$10$AHwjXk3dwl2JgvyTTdmsZ.MZkEfQj33qhG0EcLqRuSjJDzkC.f.Eu', NULL),
	(4, 'emma', 1, 40, 'emma@emma.nl', 'emma', 'emma', 0, '$2a$10$AHwjXk3dwl2JgvyTTdmsZ.MZkEfQj33qhG0EcLqRuSjJDzkC.f.Eu', NULL);

INSERT INTO `auto` (`id`, `kenteken`, `medewerker_id`, `vervangendVervoer`, `version`, `beginDatum`, `eindDatum`) VALUES
	(1, 'ab-ab-2', 1, 0, 3, '2015-06-16', '2015-11-19'),
	(2, 'cc-cc-22', 1, 0, 2, '2015-09-02', NULL),
	(10, 'aab', 1, 0, 0, '2015-11-17', '2015-12-17'),
	(11, 'ddw', 1, 0, 0, '2015-12-24', '2015-12-24'),
	(12, 'aasf', 2, 0, 0, '2016-01-07', NULL),
	(13, 'xl-07-09', 4, 0, 0, '2016-02-03', NULL);

INSERT INTO `project` (`id`, `naam`, `standaard`, `version`, `beginDatum`, `eindDatum`, `medewerker_id`) VALUES
	(1, 'Rabobank', 0, 0, '2015-10-02', NULL, 1),
	(2, 'verlof', 1, 0, '2015-10-02', NULL, 2),
	(422, 'ING', 0, 0, '2014-01-19', NULL, 0),
	(423, 'scala-event', 0, 0, '2016-01-20', NULL, 0),
	(424, 'scala', 1, 0, '2016-01-13', NULL, 0),
	(425, 'sdfsdf', 0, 0, '2015-12-31', NULL, 0),
	(426, 'dddddd', 0, 0, '2016-01-29', NULL, 1),
	(427, 'raspberry', 1, 0, '2016-01-14', NULL, 1),
	(428, 'aegon', 1, 0, '2016-01-15', NULL, 0),
	(429, 'duo', 0, 0, '2016-01-29', NULL, 1),
	(430, 'partime dag', 1, 0, '2016-01-30', NULL, 0);
