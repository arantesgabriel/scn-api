CREATE TABLE scndb.tcurso
(
    codcs  INT          NOT NULL AUTO_INCREMENT,
    nomecs VARCHAR(255) NOT NULL,
    drccs  NUMERIC      NOT NULL,
    codgrd INT          NOT NULL,
    indatv BOOLEAN      NOT NULL,
    PRIMARY KEY (codcs)
);

CREATE TABLE scndb.tsemestre
(
    codsm  INT AUTO_INCREMENT,
    idtsm  VARCHAR(255),
    datini DATE NOT NULL,
    datfim DATE NOT NULL,
    indatv BOOLEAN,
    PRIMARY KEY (codsm)
);

CREATE TABLE scndb.taluno
(
    codaln   INT          NOT NULL AUTO_INCREMENT,
    nomealn  VARCHAR(255) NOT NULL,
    usraln   VARCHAR(255) NOT NULL,
    senhaaln VARCHAR(255) NOT NULL,
    codsm    INT          NOT NULL,
    codcs    INT          NOT NULL,
    codcra   INT,
    datcad   DATE         NOT NULL,
    indatv   BOOLEAN      NOT NULL,
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
    codgrd INT     NOT NULL AUTO_INCREMENT,
    codsm  INT     NOT NULL,
    indatv BOOLEAN NOT NULL,
    PRIMARY KEY (codgrd)
);

CREATE TABLE scndb.tdisciplina
(
    coddcp       INT AUTO_INCREMENT,
    nomedcp      VARCHAR(255) NOT NULL,
    qtdfaltadcp  INTEGER,
    codgrd       INT          NOT NULL,
    professordcp VARCHAR(150),
    totnotadcp   DECIMAL DEFAULT 0,
    statapr      BOOLEAN DEFAULT FALSE,
    codavl       INT,
    codtrb       INT,
    indatv       BOOLEAN      NOT NULL,
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
    codaln     INT     NOT NULL,
    PRIMARY KEY (codtrb)
);

CREATE TABLE scndb.tavaliacao
(
    codavl     INT AUTO_INCREMENT,
    nomeavl    VARCHAR(255),
    notatotavl DECIMAL NOT NULL,
    notafinavl DECIMAL NOT NULL,
    datavl     DATE,
    codaln     INT     NOT NULL,
    PRIMARY KEY (codavl)
);