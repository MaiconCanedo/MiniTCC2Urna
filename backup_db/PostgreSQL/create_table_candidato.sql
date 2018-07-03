/*create table candidato(
	numero integer primary key unique,
	nome character varying not null,
	foto character varying,
	id_vice integer not null unique,
	constraint fk_vice foreign key (id_vice) references vice (id_vice),
	constraint fk_numero foreign key (numero) references partido (numero)
);*/
create table candidato(
	numero integer primary key unique,
	nome character varying not null,
	nome_vice character varying not null,
	foto character varying,
	foto_vice character varying,
	constraint fk_partido foreign key (numero) references partido (numero)
);

insert into candidato (numero, nome, nome_vice) values (0, 'Voto Nulo', 'Nulo'), (1, 'Voto em Branco', 'Branco');