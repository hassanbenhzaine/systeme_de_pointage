DROP TABLE IF EXISTS Promotion;
DROP TABLE IF EXISTS Promotion;

CREATE TABLE Promotion(
    debut date,
    fin date,
    nom character varying,
    id integer NOT NULL
);
CREATE TABLE Classe(
    "debutJournee" time without time zone,
    "finJournee" time without time zone,
    id integer NOT NULL,
    nom character varying
);

