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
INSERT INTO centro (nome, regiao) values('Centro de Vacinação Municipal nas Olaias','Lisboa');
INSERT INTO centro (nome, regiao) values('Politécnico do Porto','Porto');

INSERT INTO inscricao values('C1', 2, 'MiguelNdeCarvalho', 'Masculino', 20,'');
INSERT INTO inscricao values('C2', 1, 'JPeras243', 'Masculino', 21,'');