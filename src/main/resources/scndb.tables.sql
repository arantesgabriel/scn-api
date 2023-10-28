CREATE TABLE scndb.taluno
(
    codaln   NUMERIC NOT NULL,
    codcs    NUMERIC NOT NULL,
    nomealn  VARCHAR(255),
    usraln   VARCHAR(255),
    senhaaln VARCHAR(255),
    PRIMARY KEY (codaln),
    FOREIGN KEY (codcs) REFERENCES scndb.tcurso (codcs)
);

CREATE TABLE scndb.tcurso
(
    codcs     NUMERIC NOT NULL,
    codsm     NUMERIC NOT NULL,
    nomecs    VARCHAR(255),
    duracaocs DATE,
    PRIMARY KEY (codcs),
    FOREIGN KEY (codsm) REFERENCES scndb.tsemestre (codsm)
);

CREATE TABLE scndb.tsemestre
(
    codsm        NUMERIC NOT NULL,
    coddcp       NUMERIC NOT NULL,
    nomedsm      VARCHAR(255),
    mediasm      DECIMAL,
    statusaprvsm BOOLEAN,
    PRIMARY KEY (codsm),
    FOREIGN KEY (coddcp) REFERENCES scndb.tdisciplina (coddcp)
);

CREATE TABLE scndb.tdisciplina
(
    coddcp       NUMERIC NOT NULL,
    codavl       NUMERIC NOT NULL,
    codtrb       NUMERIC NOT NULL,
    nomedcp      VARCHAR(255),
    qtdfaltadcp  INTEGER,
    professordcp VARCHAR(150),
    totnotadcp   DECIMAL NOT NULL,
    PRIMARY KEY (coddcp),
    FOREIGN KEY (codtrb) REFERENCES scndb.ttrabalho (codtrb),
    FOREIGN KEY (codavl) REFERENCES scndb.tavaliacao (codavl)
);

CREATE TABLE scndb.ttrabalho
(
    codtrb  NUMERIC NOT NULL,
    nometrb VARCHAR(255),
    notatrb DECIMAL NOT NULL,
    PRIMARY KEY (codtrb)
);

CREATE TABLE scndb.tavaliacao
(
    codavl  NUMERIC,
    nomeavl VARCHAR(255),
    notaavl DECIMAL NOT NULL,
    PRIMARY KEY (codavl)
);

DROP TABLE scndb.ttrabalho;
DROP TABLE scndb.tavaliacao;
DROP TABLE scndb.tdisciplina;