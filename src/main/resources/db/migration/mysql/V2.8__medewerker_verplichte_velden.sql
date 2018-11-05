ALTER TABLE medewerker
	ALTER `achterNaam` DROP DEFAULT,
	ALTER `email` DROP DEFAULT,
	ALTER `inlognaam` DROP DEFAULT,
	ALTER `voorNaam` DROP DEFAULT,
	ALTER `version` DROP DEFAULT,
	ALTER `password` DROP DEFAULT;
ALTER TABLE `medewerker`
	CHANGE COLUMN `achterNaam` `achterNaam` VARCHAR(255) NOT NULL AFTER `id`,
	CHANGE COLUMN `actief` `actief` INT(1) NOT NULL DEFAULT '1' AFTER `achterNaam`,
	CHANGE COLUMN `email` `email` VARCHAR(255) NOT NULL AFTER `contractUren`,
	CHANGE COLUMN `inlognaam` `inlognaam` VARCHAR(255) NOT NULL AFTER `email`,
	CHANGE COLUMN `voorNaam` `voorNaam` VARCHAR(255) NOT NULL AFTER `inlognaam`,
	CHANGE COLUMN `version` `version` INT(11) NOT NULL AFTER `voorNaam`,
	CHANGE COLUMN `password` `password` VARCHAR(100) NOT NULL AFTER `version`;