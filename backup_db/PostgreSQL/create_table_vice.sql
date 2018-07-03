create table vice(
	id_vice serial primary key,
	nome character varying not null,
	foto character varying,
	sigla character varying unique not null,
	constraint fk_partido_sigla foreign key (sigla) references partido (sigla) 
);