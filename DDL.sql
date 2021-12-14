CREATE TABLE "Administrateur"
(
	"AdministrateurID" integer NOT NULL
)
;

CREATE TABLE "Adresse"
(
	"Adresse1" varchar(50),
	"Adresse2" varchar(50),
	"CodePostal" integer,
	"Pays" varchar(50),
	"Region" varchar(50),
	"Ville" varchar(50),
	"AdresseID" integer NOT NULL
)
;

CREATE TABLE "ChefFabrique"
(
	"EntreeFabrique" timestamp without time zone,
	"CheffabriqueID" integer NOT NULL
)
;

CREATE TABLE "Classe"
(
	"DebutJournee" time without time zone,
	"FinJournee" time without time zone,
	"Nom" varchar(50),
	"ClasseID" integer NOT NULL,
	"FormateurID" integer NOT NULL
)
;

CREATE TABLE "Etudiant"
(
	"EtudiantID" integer NOT NULL,
	"ClasseID" integer,
	"FormateurID" integer,
	"SpecialiteID" integer,
	"PromotionID" integer
)
;

CREATE TABLE "Evenement"
(
	"Debut" timestamp without time zone,
	"Fin" timestamp without time zone,
	"Nom" varchar(50),
	"Status" boolean,
	"EvenementID" integer NOT NULL
)
;

CREATE TABLE "Formateur"
(
	"FormateurID" integer NOT NULL,
	"SpecialiteID" integer
)
;

CREATE TABLE "JournalEvenement"
(
	"Ajoute" timestamp without time zone,
	"Modification" timestamp without time zone,
	"Suppression" timestamp without time zone,
	"JournalevenementID" integer NOT NULL,
	"EvenementID" integer,
	"UtilisateurID" integer
)
;

CREATE TABLE "Pointage"
(
	"DateArrivee" timestamp without time zone,
	"DateDepart" timestamp without time zone,
	"PointageID" integer NOT NULL,
	"UtilisateurID" integer
)
;

CREATE TABLE "Promotion"
(
	"Debut" date,
	"Fin" date,
	"Nom" varchar(50),
	"PromotionID" integer NOT NULL
)
;

CREATE TABLE "Role"
(
	"Name" varchar(50),
	"RoleID" integer NOT NULL
)
;

CREATE TABLE "Secretaire"
(
	"EntreeFabrique" date,
	"SecretaireID" integer NOT NULL
)
;

CREATE TABLE "Specialite"
(
	"Nom" varchar(50),
	"SpecialiteID" integer NOT NULL
)
;

CREATE TABLE "Utilisateur"
(
	"Email" varchar(50),
	"MotDePasse" varchar(50),
	"Nom" varchar(50),
	"Prenom" varchar(50),
	"Telephone" varchar(50),
	"UtilisateurID" integer NOT NULL,
	"AdresseID" integer,
	"RoleID" integer
)
;

ALTER TABLE "Administrateur" ADD CONSTRAINT "PK_Administrateur"
	PRIMARY KEY ("AdministrateurID")
;

ALTER TABLE "Adresse" ADD CONSTRAINT "PK_Adresse"
	PRIMARY KEY ("AdresseID")
;

ALTER TABLE "ChefFabrique" ADD CONSTRAINT "PK_ChefFabrique"
	PRIMARY KEY ("CheffabriqueID")
;

ALTER TABLE "Classe" ADD CONSTRAINT "PK_Classe"
	PRIMARY KEY ("ClasseID")
;

ALTER TABLE "Etudiant" ADD CONSTRAINT "PK_Etudiant"
	PRIMARY KEY ("EtudiantID")
;

ALTER TABLE "Evenement" ADD CONSTRAINT "PK_Evenement"
	PRIMARY KEY ("EvenementID")
;

ALTER TABLE "Formateur" ADD CONSTRAINT "PK_Formateur"
	PRIMARY KEY ("FormateurID")
;

ALTER TABLE "JournalEvenement" ADD CONSTRAINT "PK_JournalEvenement"
	PRIMARY KEY ("JournalevenementID")
;

ALTER TABLE "Pointage" ADD CONSTRAINT "PK_Pointage"
	PRIMARY KEY ("PointageID")
;

ALTER TABLE "Promotion" ADD CONSTRAINT "PK_Promotion"
	PRIMARY KEY ("PromotionID")
;

ALTER TABLE "Role" ADD CONSTRAINT "PK_Role"
	PRIMARY KEY ("RoleID")
;

ALTER TABLE "Secretaire" ADD CONSTRAINT "PK_Secretaire"
	PRIMARY KEY ("SecretaireID")
;

ALTER TABLE "Specialite" ADD CONSTRAINT "PK_Specialite"
	PRIMARY KEY ("SpecialiteID")
;

ALTER TABLE "Utilisateur" ADD CONSTRAINT "PK_Utilisateur"
	PRIMARY KEY ("UtilisateurID")
;

ALTER TABLE "Administrateur" ADD CONSTRAINT "FK_Administrateur_Utilisateur"
	FOREIGN KEY ("AdministrateurID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "ChefFabrique" ADD CONSTRAINT "FK_ChefFabrique_Utilisateur"
	FOREIGN KEY ("CheffabriqueID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Classe" ADD CONSTRAINT "FK_Classe_Formateur"
	FOREIGN KEY ("FormateurID") REFERENCES "Formateur" ("FormateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Etudiant" ADD CONSTRAINT "FK_Etudiant_Classe"
	FOREIGN KEY ("ClasseID") REFERENCES "Classe" ("ClasseID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Etudiant" ADD CONSTRAINT "FK_Etudiant_Formateur"
	FOREIGN KEY ("FormateurID") REFERENCES "Formateur" ("FormateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Etudiant" ADD CONSTRAINT "FK_Etudiant_Specialite"
	FOREIGN KEY ("SpecialiteID") REFERENCES "Specialite" ("SpecialiteID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Etudiant" ADD CONSTRAINT "FK_Etudiant_Utilisateur"
	FOREIGN KEY ("EtudiantID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Etudiant" ADD CONSTRAINT "FK_Etudiant_Promotion"
	FOREIGN KEY ("PromotionID") REFERENCES "Promotion" ("PromotionID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Formateur" ADD CONSTRAINT "FK_Formateur_Specialite"
	FOREIGN KEY ("SpecialiteID") REFERENCES "Specialite" ("SpecialiteID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Formateur" ADD CONSTRAINT "FK_Formateur_Utilisateur"
	FOREIGN KEY ("FormateurID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "JournalEvenement" ADD CONSTRAINT "FK_JournalEvenement_Evenement"
	FOREIGN KEY ("EvenementID") REFERENCES "Evenement" ("EvenementID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "JournalEvenement" ADD CONSTRAINT "FK_JournalEvenement_Utilisateur"
	FOREIGN KEY ("UtilisateurID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Pointage" ADD CONSTRAINT "FK_Pointage_Utilisateur"
	FOREIGN KEY ("UtilisateurID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Secretaire" ADD CONSTRAINT "FK_Secretaire_Utilisateur"
	FOREIGN KEY ("SecretaireID") REFERENCES "Utilisateur" ("UtilisateurID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Utilisateur" ADD CONSTRAINT "FK_Utilisateur_Adresse"
	FOREIGN KEY ("AdresseID") REFERENCES "Adresse" ("AdresseID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Utilisateur" ADD CONSTRAINT "FK_Utilisateur_Role"
	FOREIGN KEY ("RoleID") REFERENCES "Role" ("RoleID") ON DELETE No Action ON UPDATE No Action
;
