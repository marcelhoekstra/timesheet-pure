ALTER TABLE `urenboeking`
	DROP FOREIGN KEY `FK_PRJB`;
ALTER TABLE `urenboeking`
	ADD CONSTRAINT `FK_PRJB` FOREIGN KEY (`projectboeking_id`) REFERENCES `projectboeking` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE;