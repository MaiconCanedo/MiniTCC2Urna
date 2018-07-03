create table partido(
	numero integer not null,
	nome varchar not null,
	sigla varchar not null,
	legenda varchar not null,
	constraint partido_pkey primary key (numero)
);

insert into partido (numero, nome, sigla) values (13, 'Partido dos Trabalhadores', 'PT'), 
(45, 'Partido da Social Democracia Brasileira', 'PSDB'), (15, 'Movimento Democrático Brasileiro', 'MDB'),
(40, 'Partido Socialista Brasileiro', 'PSB'), (50, 'Partido Socialismo e Liberdade', 'PSOL'),
(20, 'Partido Social Cristão', 'PSC'), (28, 'Partido Renovador Trabalhista Brasileiro', 'PRTB'),
(43, 'Partido Verde', 'PV'), (16, 'Partido Socialista dos Trabalhadores Unificado', 'PSTU'),
(27, 'Partido Social Democrata Cristão', 'PSDC'), (21, 'Partido Comunista Brasileiro', 'PCB'),
(65, 'Partido Comunista do Brasil', 'PCdoB'), (14, 'Partido Trabalhista Brasileiro', 'PTB'),
(23, 'Partido Popular Socialista', 'PPS'), (22, 'Partido da República', 'PR'),
(11, 'Partido Progressista', 'PP'), (12, 'Partido Democrático Trabalhista', 'PDT'),
(18, 'Rede Sustentabilidade', 'REDE'), (17, 'Partido Social Liberal', 'PSL'),
(19, 'Podemos', 'PODE'), (55, 'Partido Social Democrático', 'PSD');
(0, 'Voto Nulo', 'NULO'), (1, 'Voto em Branco', 'BRANCO');

select * from partido order by numero;
