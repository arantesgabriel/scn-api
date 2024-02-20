CREATE TABLE scndb.tcurso
(
    codcs  INT          NOT NULL AUTO_INCREMENT,
    nomecs VARCHAR(255) NOT NULL,
    drccs  NUMERIC      NOT NULL,
    codaln INT,
    codgrd INT,
    indatv BOOLEAN      NOT NULL,
    PRIMARY KEY (codcs),
    FOREIGN KEY (codaln)
        REFERENCES scndb.taluno (codaln)
);

CREATE TABLE scndb.trelacaogrddcp
(
    codgrd INT,
    coddcp INT,
    PRIMARY KEY (codgrd, coddcp),
    FOREIGN KEY (codgrd) REFERENCES scndb.tgrade (codgrd),
    FOREIGN KEY (coddcp) REFERENCES scndb.tdisciplina (coddcp)
);

CREATE TABLE scndb.trelacaoalndcp
(
    codaln INT,
    coddcp INT,
    PRIMARY KEY (codaln, coddcp)
);

CREATE TABLE scndb.tsemestre
(
    codsm  INT AUTO_INCREMENT,
    idtsm  VARCHAR(255),
    datini DATE NOT NULL,
    datfim DATE NOT NULL,
    codaln INT,
    indatv BOOLEAN,
    PRIMARY KEY (codsm),
    FOREIGN KEY (codaln)
        REFERENCES scndb.taluno (codaln)
);

CREATE TABLE scndb.taluno
(
    codaln   INT          NOT NULL AUTO_INCREMENT,
    nomealn  VARCHAR(255) NOT NULL,
    usraln   VARCHAR(255) NOT NULL,
    senhaaln VARCHAR(255) NOT NULL,
    codcra   INT          NOT NULL,
    datcad   DATE,
    indatv   BOOLEAN,
    PRIMARY KEY (codaln),
    FOREIGN KEY (codcra)
        REFERENCES scndb.tcra (codcra)
);

CREATE TABLE scndb.tcra
(
    codcra  INT NOT NULL AUTO_INCREMENT,
    mediasm DECIMAL DEFAULT 0,
    mediacs DECIMAL DEFAULT 0,
    PRIMARY KEY (codcra)
);

CREATE TABLE scndb.tgrade
(
    codgrd INT AUTO_INCREMENT,
    numpr  NUMERIC,
    coddcp INT,
    PRIMARY KEY (codgrd),
    FOREIGN KEY (coddcp)
        REFERENCES scndb.tdisciplina (coddcp)
);

CREATE TABLE scndb.tdisciplina
(
    coddcp       INT AUTO_INCREMENT,
    nomedcp      VARCHAR(255) NOT NULL,
    qtdfaltadcp  INTEGER,
    professordcp VARCHAR(150),
    totnotadcp   DECIMAL DEFAULT 0,
    statapr      BOOLEAN DEFAULT FALSE,
    codavl       INT,
    codtrb       INT,
    indatv       BOOLEAN,
    PRIMARY KEY (coddcp),
    FOREIGN KEY (codtrb)
        REFERENCES scndb.ttrabalho (codtrb),
    FOREIGN KEY (codavl)
        REFERENCES scndb.tavaliacao (codavl)
);

CREATE TABLE scndb.ttrabalho
(
    codtrb     INT AUTO_INCREMENT,
    nometrb    VARCHAR(255),
    notatottrb DECIMAL NOT NULL,
    notafintrb DECIMAL NOT NULL,
    datrb      DATE,
    PRIMARY KEY (codtrb)
);

CREATE TABLE scndb.tavaliacao
(
    codavl     INT AUTO_INCREMENT,
    nomeavl    VARCHAR(255),
    notatotavl DECIMAL NOT NULL,
    notafinavl DECIMAL NOT NULL,
    datavl     DATE,
    PRIMARY KEY (codavl)
);