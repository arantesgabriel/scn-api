CREATE TABLE scndb.taluno
(
    codaln   INT NOT NULL AUTO_INCREMENT,
	nomealn  VARCHAR(255),
	usraln   VARCHAR(255),
    senhaaln VARCHAR(255),
	codcs    INT NOT NULL,
    PRIMARY KEY (codaln),
    FOREIGN KEY (codcs) REFERENCES scndb.tcurso (codcs)
);

CREATE TABLE scndb.tcurso
(
    codcs     INT NOT NULL AUTO_INCREMENT,
	nomecs    VARCHAR(255),
	duracaocs NUMERIC,
    codsm     INT,
    PRIMARY KEY (codcs),
    FOREIGN KEY (codsm) REFERENCES scndb.tsemestre (codsm)
);

CREATE TABLE scndb.tsemestre
(
    codsm        INT AUTO_INCREMENT,
	nomedsm      VARCHAR(255),
	mediasm      DECIMAL,
    statusaprvsm BOOLEAN,
    coddcp       INT NOT NULL,
    PRIMARY KEY (codsm),
    FOREIGN KEY (coddcp) REFERENCES scndb.tdisciplina (coddcp)
);

CREATE TABLE scndb.tdisciplina
(
    coddcp       INT AUTO_INCREMENT,
	nomedcp      VARCHAR(255),
	qtdfaltadcp  INTEGER,
	professordcp VARCHAR(150),
	totnotadcp   DECIMAL DEFAULT 0,
    codavl       INT,
    codtrb       INT,
    PRIMARY KEY (coddcp),
    FOREIGN KEY (codtrb) REFERENCES scndb.ttrabalho (codtrb),
    FOREIGN KEY (codavl) REFERENCES scndb.tavaliacao (codavl)
);

CREATE TABLE scndb.ttrabalho
(
    codtrb  INT AUTO_INCREMENT,
    nometrb VARCHAR(255),
    notatrb DECIMAL NOT NULL,
    datent  DATE,
    PRIMARY KEY (codtrb)
);

CREATE TABLE scndb.tavaliacao (
    codavl INT AUTO_INCREMENT,
    nomeavl VARCHAR(255),
    notaavl DECIMAL NOT NULL,
	datent  DATE,
    PRIMARY KEY (codavl)
);