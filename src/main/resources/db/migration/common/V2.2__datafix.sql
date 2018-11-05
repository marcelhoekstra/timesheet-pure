update urenboeking set mutatiedatum = now() where mutatiedatum is null;
update project set begindatum = '2014-11-01' where begindatum is null;