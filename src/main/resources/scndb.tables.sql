CREATE TABLE scndb.tcurso
(
    codcs  INT     NOT NULL AUTO_INCREMENT,
    nomecs VARCHAR(255),
    durccs NUMERIC NOT NULL,
    codaln INT,
    PRIMARY KEY (codcs),
    FOREIGN KEY (codaln)
        REFERENCES scndb.taluno (codaln)
);

CREATE TABLE scndb.taluno
(
    codaln   INT NOT NULL AUTO_INCREMENT,
    nomealn  VARCHAR(255),
    usraln   VARCHAR(255),
    senhaaln VARCHAR(255),
    codsm    INT,
    coddcp   INT,
    PRIMARY KEY (codaln),
    FOREIGN KEY (codsm)
        REFERENCES scndb.tsemestre (codsm),
    FOREIGN KEY (coddcp)
        REFERENCES scndb.tdisciplina (coddcp)
);

CREATE TABLE scndb.tsemestre
(
    codsm   INT AUTO_INCREMENT,
    numpr   NUMERIC,
    mediasm DECIMAL DEFAULT 0,
    PRIMARY KEY (codsm)
);

CREATE TABLE scndb.tdisciplina
(
    coddcp       INT AUTO_INCREMENT,
    nomedcp      VARCHAR(255),
    qtdfaltadcp  INTEGER,
    professordcp VARCHAR(150),
    totnotadcp   DECIMAL DEFAULT 0,
    statapr      BOOLEAN DEFAULT FALSE,
    codavl       INT,
    codtrb       INT,
    PRIMARY KEY (coddcp),
    FOREIGN KEY (codtrb)
        REFERENCES scndb.ttrabalho (codtrb),
    FOREIGN KEY (codavl)
        REFERENCES scndb.tavaliacao (codavl)
);

CREATE TABLE scndb.tgrade
(
    codgrd INT AUTO_INCREMENT,
    numpr  VARCHAR(255),
    codcs  INT,
    coddcp INT,
    PRIMARY KEY (codgrd),
    FOREIGN KEY (codcs)
        REFERENCES scndb.tdisciplina (codcs),
    FOREIGN KEY (coddcp)
        REFERENCES scndb.tdisciplina (coddcp)
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