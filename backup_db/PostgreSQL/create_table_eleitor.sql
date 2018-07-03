create table eleitor(
	numero_inscricao character varying not null,
	nome character varying,
	cep character varying,
	rg character varying,
	cpf character varying,
	data_nascimento date,
	data_emissao timestamp with time zone,
	constraint eleitor_pkey primary key (numero_inscricao)
);

alter table eleitor add column orgao_emissor character varying;

insert into eleitor(numero_inscricao, nome, cep, rg, orgao_emissor, cpf, data_nascimento, data_emissao) values
('1596 2198 0345', 'Maicon Canedo Rocha Paradela', '25810-310', '223.323.232', 'DETRAN-RJ', '187.435.567-18', '1995-12-23', now());

select * from eleitor;

