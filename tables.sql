CREATE TABLE IF NOT EXISTS centro  (
    ID SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    regiao TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS inscricao  (
    codigo VARCHAR NOT NULL PRIMARY KEY,
    centroID SERIAL NOT NULL,
    nome TEXT NOT NULL,
    genero TEXT NOT NULL,
    idade INT NOT NULL,
    efeitosSecundarios TEXT NOT NULL,
    foreign key (centroID) references centro(ID) on delete cascade
);

CREATE TABLE IF NOT EXISTS vacinado  (
    codigo VARCHAR PRIMARY KEY NOT NULL,
    centroID SERIAL NOT NULL,
    nome TEXT NOT NULL,
    genero TEXT NOT NULL,
    idade INT NOT NULL,
    quando DATE NOT NULL,
    tipo TEXT NOT NULL
);

INSERT INTO centro (nome, regiao) values('Arena de Évora','Évora');
INSERT INTO centro (nome, regiao) values('Centro de Saúde de Reguengos de Monsaraz','Reguengos de Monsaraz');


INSERT INTO inscricao values('C1', 1, 'João Pereira dos Santos Pavia Pedro Pais com K', 'Masculino', 21,'');

INSERT INTO vacinado values('C2',1,'miguel','Masculino','21',NOW() ,'A');

SELECT nome FROM inscricao WHERE codigo='c3';

INSERT vacinado INTO ('C1','1','João Pereira dos Santos Pavia Pedro Pais com K','Masculino','NOW()','A');