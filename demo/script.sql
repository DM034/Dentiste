create database dentiste;

--dent
create table genre(
    id integer primary key,
    nom varchar
);
create sequence genre_seq;

create table patient(
    id integer primary key,
    nom varchar,
    dtn Date,
    id_genre integer,
    foreign key (id_genre) references genre(id)
);
create sequence patient_seq;

create table type(
    id integer primary key,
    nom varchar,
    valeur integer
);
create sequence type_seq;

create table dent(
    id integer primary key,
    nom varchar,
    code varchar,
    id_type integer,
    foreign key (id_type) references type(id)
);
create sequence dent_seq;

create table dent_patient(
    id integer primary key,
    id_patient integer,
    id_dent integer,
    etat integer,
    foreign key (id_patient) references patient(id),
    foreign key (id_dent) references dent(id) 
);
create sequence dent_patient_seq;

create table traitement(
    id integer primary key,
    nom varchar,
    valeur integer,
    cout float8
);
create sequence traitement_seq;

create table traitement_patient(
    id integer primary key,
    id_patient integer,
    id_traitement integer,
    etat integer,
    foreign key (id_patient) references patient(id),
    foreign key (id_traitement) references traitement(id) 
);
create sequence traitement_patient_seq;

create table rdv(
    id integer primary key,
    dateheure timestamp,
    id_traitement_patient integer,
    foreign key (id_traitement_patient) references traitement_patient(id) 
);
create sequence rdv_seq;

create table cout_traitement(
    id serial primary key,
    id_traitement integer,
    id_dent integer,
    cout float8,
    foreign key (id_traitement) references traitement(id), 
    foreign key (id_dent) references dent(id) 
);

create table budget_patient(
    id integer primary key,
    id_patient integer,
    budget float8,
    etat integer,
    foreign key (id_patient) references patient(id)
);
create sequence budget_patient_seq;

create table traitement_etat(
    id serial primary key,
    etat integer,
    id_traitement integer,
    foreign key (id_traitement) references traitement(id)
);


insert into genre values(1, 'masculin');
insert into genre values(2, 'feminin');


insert into patient values(1,'Rakoto','2000-01-01',1);
insert into patient values(2,'Rasoa','2001-01-01',2);
insert into patient values(3,'Ravao','2001-02-01',2);

insert into type values(1,'beaute',10);
insert into type values(2,'sanitaire',20);

insert into dent values(1,'HMolaire 1','A1',2);
insert into dent values(2,'HMolaire 2','A2',2);
insert into dent values(3,'HMolaire 3','A3',2);
insert into dent values(4,'HPreMolaire 1','A4',2);
insert into dent values(5,'HPreMolaire 2','A5',2);
insert into dent values(6,'HCanine 1','A6',1);
insert into dent values(7,'HIncisive 1','A7',1);
insert into dent values(8,'HIncisive 2','A8',1);
insert into dent values(9,'HIncisive 3','A9',1);
insert into dent values(10,'HIncisive 4','A10',1);
insert into dent values(11,'HCanine 2','A11',1);
insert into dent values(12,'HPreMolaire 3','A12',2);
insert into dent values(13,'HPreMolaire 4','A13',2);
insert into dent values(14,'HMolaire 4','A14',2);
insert into dent values(15,'HMolaire 5','A15',2);
insert into dent values(16,'HMolaire 6','A16',2);

insert into dent values(17,'BMolaire 1','B1',2);
insert into dent values(18,'BMolaire 2','B2',2);
insert into dent values(19,'BMolaire 3','B3',2);
insert into dent values(20,'BPreMolaire 1','B4',2);
insert into dent values(21,'BPreMolaire 2','B5',2);
insert into dent values(22,'BCanine 1','B6',1);
insert into dent values(23,'BIncisive 1','B7',1);
insert into dent values(24,'BIncisive 2','B8',1);
insert into dent values(25,'BIncisive 3','B9',1);
insert into dent values(26,'BIncisive 4','B10',1);
insert into dent values(27,'BCanine 2','B11',1);
insert into dent values(28,'BPreMolaire 3','B12',2);
insert into dent values(29,'BPreMolaire 4','B13',2);
insert into dent values(30,'BMolaire 4','B14',2);
insert into dent values(31,'BMolaire 5','B15',2);
insert into dent values(32,'BMolaire 6','B16',2);


insert into dent_patient values(1,1,1,10);
insert into dent_patient values(2,1,2,10);
insert into dent_patient values(3,1,3,10);
insert into dent_patient values(4,1,4,10);
insert into dent_patient values(5,1,5,10);
insert into dent_patient values(6,1,6,10);
insert into dent_patient values(7,1,7,10);
insert into dent_patient values(8,1,8,0);
insert into dent_patient values(9,1,9,2);
insert into dent_patient values(10,1,10,10);
insert into dent_patient values(11,1,11,10);
insert into dent_patient values(12,1,12,10);
insert into dent_patient values(13,1,13,10);
insert into dent_patient values(14,1,14,10);
insert into dent_patient values(15,1,15,10);
insert into dent_patient values(16,1,16,10);

insert into dent_patient values(17,1,17,4);
insert into dent_patient values(18,1,18,10);
insert into dent_patient values(19,1,19,10);
insert into dent_patient values(20,1,20,10);
insert into dent_patient values(21,1,21,10);
insert into dent_patient values(22,1,22,10);
insert into dent_patient values(23,1,23,10);
insert into dent_patient values(24,1,24,10);
insert into dent_patient values(25,1,25,10);
insert into dent_patient values(26,1,26,10);
insert into dent_patient values(27,1,27,10);
insert into dent_patient values(28,1,28,10);
insert into dent_patient values(29,1,29,10);
insert into dent_patient values(30,1,30,10);
insert into dent_patient values(31,1,31,10);
insert into dent_patient values(32,1,32,10);

delete from dent_patient;

insert into traitement values(1,'Nettoyage', 0, 0);
insert into traitement values(2,'Reparation', 5, 0);
insert into traitement values(3,'Enlevement', 10, 0);
insert into traitement values(4,'Remplacement', 15, 0);


insert into cout_traitement values(default,1,1,1000);
insert into cout_traitement values(default,1,2,1000);
insert into cout_traitement values(default,1,3,1000);
insert into cout_traitement values(default,1,4,1000);
insert into cout_traitement values(default,1,5,1000);
insert into cout_traitement values(default,1,6,1000);
insert into cout_traitement values(default,1,7,1000);
insert into cout_traitement values(default,1,8,1000);
insert into cout_traitement values(default,1,9,1000);
insert into cout_traitement values(default,1,10,1000);
insert into cout_traitement values(default,1,11,1000);
insert into cout_traitement values(default,1,12,1000);
insert into cout_traitement values(default,1,13,1000);
insert into cout_traitement values(default,1,14,1000);
insert into cout_traitement values(default,1,15,1000);
insert into cout_traitement values(default,1,16,1000);
insert into cout_traitement values(default,1,17,1000);
insert into cout_traitement values(default,1,18,1000);
insert into cout_traitement values(default,1,19,1000);
insert into cout_traitement values(default,1,20,1000);
insert into cout_traitement values(default,1,21,1000);
insert into cout_traitement values(default,1,22,1000);
insert into cout_traitement values(default,1,23,1000);
insert into cout_traitement values(default,1,24,1000);
insert into cout_traitement values(default,1,25,1000);
insert into cout_traitement values(default,1,26,1000);
insert into cout_traitement values(default,1,27,1000);
insert into cout_traitement values(default,1,28,1000);
insert into cout_traitement values(default,1,29,1000);
insert into cout_traitement values(default,1,30,1000);
insert into cout_traitement values(default,1,31,1000);
insert into cout_traitement values(default,1,32,1000);

insert into cout_traitement values(default,2,1,2000);
insert into cout_traitement values(default,2,2,2000);
insert into cout_traitement values(default,2,3,2000);
insert into cout_traitement values(default,2,4,2000);
insert into cout_traitement values(default,2,5,2000);
insert into cout_traitement values(default,2,6,2000);
insert into cout_traitement values(default,2,7,2000);
insert into cout_traitement values(default,2,8,2000);
insert into cout_traitement values(default,2,9,2000);
insert into cout_traitement values(default,2,10,2000);
insert into cout_traitement values(default,2,11,2000);
insert into cout_traitement values(default,2,12,2000);
insert into cout_traitement values(default,2,13,2000);
insert into cout_traitement values(default,2,14,2000);
insert into cout_traitement values(default,2,15,2000);
insert into cout_traitement values(default,2,16,2000);
insert into cout_traitement values(default,2,17,2000);
insert into cout_traitement values(default,2,18,2000);
insert into cout_traitement values(default,2,19,2000);
insert into cout_traitement values(default,2,20,2000);
insert into cout_traitement values(default,2,21,2000);
insert into cout_traitement values(default,2,22,2000);
insert into cout_traitement values(default,2,23,2000);
insert into cout_traitement values(default,2,24,2000);
insert into cout_traitement values(default,2,25,2000);
insert into cout_traitement values(default,2,26,2000);
insert into cout_traitement values(default,2,27,2000);
insert into cout_traitement values(default,2,28,2000);
insert into cout_traitement values(default,2,29,2000);
insert into cout_traitement values(default,2,30,2000);
insert into cout_traitement values(default,2,31,2000);
insert into cout_traitement values(default,2,32,2000);

insert into cout_traitement values(default,3,1,5000);
insert into cout_traitement values(default,3,2,5000);
insert into cout_traitement values(default,3,3,5000);
insert into cout_traitement values(default,3,4,5000);
insert into cout_traitement values(default,3,5,5000);
insert into cout_traitement values(default,3,6,5000);
insert into cout_traitement values(default,3,7,5000);
insert into cout_traitement values(default,3,8,5000);
insert into cout_traitement values(default,3,9,5000);
insert into cout_traitement values(default,3,10,5000);
insert into cout_traitement values(default,3,11,5000);
insert into cout_traitement values(default,3,12,5000);
insert into cout_traitement values(default,3,13,5000);
insert into cout_traitement values(default,3,14,5000);
insert into cout_traitement values(default,3,15,5000);
insert into cout_traitement values(default,3,16,5000);
insert into cout_traitement values(default,3,17,5000);
insert into cout_traitement values(default,3,18,5000);
insert into cout_traitement values(default,3,19,5000);
insert into cout_traitement values(default,3,20,5000);
insert into cout_traitement values(default,3,21,5000);
insert into cout_traitement values(default,3,22,5000);
insert into cout_traitement values(default,3,23,5000);
insert into cout_traitement values(default,3,24,5000);
insert into cout_traitement values(default,3,25,5000);
insert into cout_traitement values(default,3,26,5000);
insert into cout_traitement values(default,3,27,5000);
insert into cout_traitement values(default,3,28,5000);
insert into cout_traitement values(default,3,29,5000);
insert into cout_traitement values(default,3,30,5000);
insert into cout_traitement values(default,3,31,5000);
insert into cout_traitement values(default,3,32,5000);

insert into cout_traitement values(default,4,1,100000);
insert into cout_traitement values(default,4,2,100000);
insert into cout_traitement values(default,4,3,100000);
insert into cout_traitement values(default,4,4,100000);
insert into cout_traitement values(default,4,5,100000);
insert into cout_traitement values(default,4,6,100000);
insert into cout_traitement values(default,4,7,100000);
insert into cout_traitement values(default,4,8,100000);
insert into cout_traitement values(default,4,9,100000);
insert into cout_traitement values(default,4,10,100000);
insert into cout_traitement values(default,4,11,100000);
insert into cout_traitement values(default,4,12,100000);
insert into cout_traitement values(default,4,13,100000);
insert into cout_traitement values(default,4,14,100000);
insert into cout_traitement values(default,4,15,100000);
insert into cout_traitement values(default,4,16,100000);
insert into cout_traitement values(default,4,17,100000);
insert into cout_traitement values(default,4,18,100000);
insert into cout_traitement values(default,4,19,100000);
insert into cout_traitement values(default,4,20,100000);
insert into cout_traitement values(default,4,21,100000);
insert into cout_traitement values(default,4,22,100000);
insert into cout_traitement values(default,4,23,100000);
insert into cout_traitement values(default,4,24,100000);
insert into cout_traitement values(default,4,25,100000);
insert into cout_traitement values(default,4,26,100000);
insert into cout_traitement values(default,4,27,100000);
insert into cout_traitement values(default,4,28,100000);
insert into cout_traitement values(default,4,29,100000);
insert into cout_traitement values(default,4,30,100000);
insert into cout_traitement values(default,4,31,100000);
insert into cout_traitement values(default,4,32,100000);

delete from cout_traitement;

insert into budget_patient values(1, 1, 200000, 1);
update budget_patient set budget = 119500 where id_patient = 1;

delete from budget_patient;

insert into traitement_etat values(default, 0, 4);
insert into traitement_etat values(default, 1, 3);
insert into traitement_etat values(default, 2, 3);
insert into traitement_etat values(default, 3, 3);
insert into traitement_etat values(default, 4, 2);
insert into traitement_etat values(default, 5, 2);
insert into traitement_etat values(default, 6, 2);
insert into traitement_etat values(default, 7, 1);
insert into traitement_etat values(default, 8, 1);
insert into traitement_etat values(default, 9, 1);


create view v_dent_patient as select dent_patient.id, id_patient, patient.nom, id_dent, dent.code, dent.id_type, dent_patient.etat from dent_patient
    join patient on patient.id = dent_patient.id_patient
    join dent on dent.id = dent_patient.id_dent
    group by dent_patient.id, id_patient, patient.nom, id_dent, dent.code,dent.id_type, dent_patient.etat
    order by id asc;


update budget_patient set budget = 30000;
delete from dent_patient;

--lalana
create table typeLalana(
    id serial primary key,
    nom varchar
);

create table route(
    id serial primary key,
    nom varchar
);

create table lalana(
    id serial primary key,
    nom varchar,
    code varchar,
    id_type_lalana integer,
    foreign key (id_type_lalana) references typeLalana(id)
);

create table routeLalana(
    id serial primary key,
    id_route integer,
    id_lalana integer,
    etat integer,
    foreign key (id_route) references route(id),
    foreign key (id_lalana) references lalana(id) 
);

create table cout_traitementLalana(
    id serial primary key,
    id_traitement integer,
    id_lalana integer,
    cout float8,
    foreign key (id_traitement) references traitement(id), 
    foreign key (id_lalana) references lalana(id)
);

create table budget_fanja(
    id serial primary key,
    id_route integer,
    budget float8,
    etat integer,
    foreign key (id_route) references route(id)
);

insert into typeLalana values(default,'ville');
insert into typeLalana values(default,'hors ville');

insert into route values(default,'R1');
insert into route values(default,'R2');

insert into lalana values(default,'PK1 ','PK1',2);
insert into lalana values(default,'PK2 ','PK2',2);
insert into lalana values(default,'PK3 ','PK3',2);
insert into lalana values(default,'PK4 ','PK4',2);
insert into lalana values(default,'PK5 ','PK5',1);
insert into lalana values(default,'PK6 ','PK6',1);
insert into lalana values(default,'PK7 ','PK7',1);
insert into lalana values(default,'PK8 ','PK8',1);
insert into lalana values(default,'PK9 ','PK9',1);
insert into lalana values(default,'PK10 ','PK10',1);
insert into lalana values(default,'PK11 ','PK11',1);
insert into lalana values(default,'PK12 ','PK12',1);
insert into lalana values(default,'PK13 ','PK13',2);
insert into lalana values(default,'PK14 ','PK14',2);
insert into lalana values(default,'PK15 ','PK15',2);
insert into lalana values(default,'PK16 ','PK16',2);

insert into routeLalana values(default,1,1,10);
insert into routeLalana values(default,1,2,5);
insert into routeLalana values(default,1,3,5);
insert into routeLalana values(default,1,4,10);
insert into routeLalana values(default,1,5,10);
insert into routeLalana values(default,1,6,0);
insert into routeLalana values(default,1,7,10);
insert into routeLalana values(default,1,8,9);
insert into routeLalana values(default,1,9,8);
insert into routeLalana values(default,1,10,10);
insert into routeLalana values(default,1,11,5);
insert into routeLalana values(default,1,12,10);
insert into routeLalana values(default,1,13,3);
insert into routeLalana values(default,1,14,0);
insert into routeLalana values(default,1,15,10);
insert into routeLalana values(default,1,16,0);

insert into cout_traitementLalana values(default,2,1,10000);
insert into cout_traitementLalana values(default,2,2,10000);
insert into cout_traitementLalana values(default,2,3,10000);
insert into cout_traitementLalana values(default,2,4,10000);
insert into cout_traitementLalana values(default,2,5,10000);
insert into cout_traitementLalana values(default,2,6,10000);
insert into cout_traitementLalana values(default,2,7,10000);
insert into cout_traitementLalana values(default,2,8,10000);
insert into cout_traitementLalana values(default,2,9,10000);
insert into cout_traitementLalana values(default,2,10,10000);
insert into cout_traitementLalana values(default,2,11,10000);
insert into cout_traitementLalana values(default,2,12,10000);
insert into cout_traitementLalana values(default,2,13,10000);
insert into cout_traitementLalana values(default,2,14,10000);
insert into cout_traitementLalana values(default,2,15,10000);
insert into cout_traitementLalana values(default,2,16,10000);

delete from routeLalana;

insert into budget_fanja values(1, 1, 200000, 1);

update budget_fanja set budget = 1000000 where id = 1;

create view v_routeLalana as select routeLalana.id, id_route, route.nom, id_lalana, lalana.code, lalana.id_type_lalana, routeLalana.etat from routeLalana
    join route on route.id = routeLalana.id_route
    join lalana on lalana.id = routeLalana.id_lalana
    group by routeLalana.id, id_route, route.nom, id_lalana, lalana.code,lalana.id_type_lalana, routeLalana.etat
    order by id asc;


create table alea(
    id serial primary key,
    nify varchar,
    note varchar
);

delete from alea;























