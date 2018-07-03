create table eleitor(
	numero_inscricao varchar(14) not null,
	nome varchar(45) not null,
	cep varchar(9) not null,
	rg varchar(12) not null,
	cpf varchar(14) not null unique,
	data_nascimento date not null,
	data_emissao timestamp with time zone not null,
	constraint eleitor_pkey primary key (numero_inscricao)
);

alter table eleitor add column orgao_emissor varchar;

insert into eleitor(numero_inscricao, nome, cep, rg, orgao_emissor, cpf, data_nascimento, data_emissao) values
('1596 2198 0345', 'Maicon Canedo Rocha Paradela', '25810-310', '223.323.232', 'DETRAN-RJ', '187.435.567-18', '1995-12-23', now());

select * from eleitor;

