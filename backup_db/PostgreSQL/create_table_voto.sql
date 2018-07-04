create table voto(
	id_voto bigserial primary key,
	numero_inscricao varchar(14) unique not null,
	numero integer default 0,
	data_hora timestamp,
	constraint fk_eleitor foreign key (numero_inscricao) references eleitor (numero_inscricao),
	constraint fk_candidato foreign key (numero) references candidato (numero)
);