--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2021-12-16 10:36:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 68422)
-- Name: Utilisateur; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Utilisateur" (
    email character varying,
    "motDePasse" character varying,
    nom character varying,
    prenom character varying,
    telephone character varying,
    id integer NOT NULL,
    "roleId" integer
);


--
-- TOC entry 206 (class 1259 OID 68486)
-- Name: Administrateur; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Administrateur" (
)
INHERITS (public."Utilisateur");


--
-- TOC entry 207 (class 1259 OID 68492)
-- Name: Adresse; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Adresse" (
    adresse1 character varying,
    adresse2 character varying,
    "codePostal" character varying,
    pays character varying,
    region character varying,
    ville character varying,
    id integer NOT NULL,
    "utilisateurId" integer
);


--
-- TOC entry 220 (class 1259 OID 68594)
-- Name: Adresse_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Adresse" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Adresse_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 68459)
-- Name: ChefFabrique; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."ChefFabrique" (
    "entreeFabrique" timestamp without time zone
)
INHERITS (public."Utilisateur");


--
-- TOC entry 211 (class 1259 OID 68538)
-- Name: Classe; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Classe" (
    "debutJournee" time without time zone,
    "finJournee" time without time zone,
    id integer NOT NULL,
    nom character varying
);


--
-- TOC entry 219 (class 1259 OID 68592)
-- Name: Classe_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Classe" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Classe_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 210 (class 1259 OID 68532)
-- Name: Etudiant; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Etudiant" (
    "classeId" integer,
    "promotionId" integer
)
INHERITS (public."Utilisateur");


--
-- TOC entry 204 (class 1259 OID 68465)
-- Name: Evenement; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Evenement" (
    description character varying,
    nom character varying,
    proposer boolean,
    id integer NOT NULL,
    debut timestamp without time zone,
    fin timestamp without time zone
);


--
-- TOC entry 218 (class 1259 OID 68590)
-- Name: Evenement_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Evenement" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Evenement_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 68596)
-- Name: Formateur; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Formateur" (
    "roleId" integer,
    "specialiteId" integer,
    "classeId" integer
)
INHERITS (public."Utilisateur");


--
-- TOC entry 205 (class 1259 OID 68473)
-- Name: JournalEvenement; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."JournalEvenement" (
    "utilisateurId" integer,
    "evenementId" integer,
    ajoute timestamp without time zone,
    suppression timestamp without time zone,
    modification timestamp without time zone
);


--
-- TOC entry 202 (class 1259 OID 68449)
-- Name: Pointage; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Pointage" (
    "dateEtHeure" timestamp without time zone,
    id integer NOT NULL,
    "utilisateurId" integer
);


--
-- TOC entry 217 (class 1259 OID 68588)
-- Name: Pointage_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Pointage" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Pointage_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 212 (class 1259 OID 68567)
-- Name: Promotion; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Promotion" (
    debut date,
    fin date,
    nom character varying,
    id integer NOT NULL
);


--
-- TOC entry 216 (class 1259 OID 68586)
-- Name: Promotion_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Promotion" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Promotion_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 208 (class 1259 OID 68505)
-- Name: Role; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Role" (
    nom character varying,
    id integer NOT NULL
);


--
-- TOC entry 215 (class 1259 OID 68584)
-- Name: Role_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Role" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Role_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 68441)
-- Name: Secretaire; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Secretaire" (
    id integer,
    "entreeFabrique" date
)
INHERITS (public."Utilisateur");


--
-- TOC entry 209 (class 1259 OID 68524)
-- Name: Specialite; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public."Specialite" (
    nom character varying,
    id integer NOT NULL
);


--
-- TOC entry 214 (class 1259 OID 68582)
-- Name: Specialite_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Specialite" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Specialite_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 68580)
-- Name: Utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public."Utilisateur" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Utilisateur_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2939 (class 2606 OID 69003)
-- Name: Administrateur Administrateur_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Administrateur"
    ADD CONSTRAINT "Administrateur_pkey" PRIMARY KEY (id);


--
-- TOC entry 2941 (class 2606 OID 68499)
-- Name: Adresse Adresse_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Adresse"
    ADD CONSTRAINT "Adresse_pkey" PRIMARY KEY (id);


--
-- TOC entry 2935 (class 2606 OID 69001)
-- Name: ChefFabrique ChefFabrique_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."ChefFabrique"
    ADD CONSTRAINT "ChefFabrique_pkey" PRIMARY KEY (id);


--
-- TOC entry 2949 (class 2606 OID 68545)
-- Name: Classe Classe_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Classe"
    ADD CONSTRAINT "Classe_pkey" PRIMARY KEY (id);


--
-- TOC entry 2947 (class 2606 OID 68999)
-- Name: Etudiant Etudiant_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Etudiant"
    ADD CONSTRAINT "Etudiant_pkey" PRIMARY KEY (id);


--
-- TOC entry 2937 (class 2606 OID 68472)
-- Name: Evenement Evenement_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Evenement"
    ADD CONSTRAINT "Evenement_pkey" PRIMARY KEY (id);


--
-- TOC entry 2953 (class 2606 OID 68997)
-- Name: Formateur Formateur_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Formateur"
    ADD CONSTRAINT "Formateur_pkey" PRIMARY KEY (id);


--
-- TOC entry 2933 (class 2606 OID 68453)
-- Name: Pointage Pointage_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Pointage"
    ADD CONSTRAINT "Pointage_pkey" PRIMARY KEY (id);


--
-- TOC entry 2951 (class 2606 OID 68574)
-- Name: Promotion Promotion_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Promotion"
    ADD CONSTRAINT "Promotion_pkey" PRIMARY KEY (id);


--
-- TOC entry 2943 (class 2606 OID 68512)
-- Name: Role Role_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Role"
    ADD CONSTRAINT "Role_pkey" PRIMARY KEY (id);


--
-- TOC entry 2931 (class 2606 OID 68448)
-- Name: Secretaire Secretaire_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Secretaire"
    ADD CONSTRAINT "Secretaire_pkey" PRIMARY KEY (id);


--
-- TOC entry 2945 (class 2606 OID 68531)
-- Name: Specialite Specialite_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Specialite"
    ADD CONSTRAINT "Specialite_pkey" PRIMARY KEY (id);


--
-- TOC entry 2929 (class 2606 OID 68429)
-- Name: Utilisateur Utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT "Utilisateur_pkey" PRIMARY KEY (id);


--
-- TOC entry 2958 (class 2606 OID 68500)
-- Name: Adresse Adresse_utilisateurId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Adresse"
    ADD CONSTRAINT "Adresse_utilisateurId_fkey" FOREIGN KEY ("utilisateurId") REFERENCES public."Utilisateur"(id);


--
-- TOC entry 2959 (class 2606 OID 68557)
-- Name: Etudiant Etudiant_classeId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Etudiant"
    ADD CONSTRAINT "Etudiant_classeId_fkey" FOREIGN KEY ("classeId") REFERENCES public."Classe"(id) NOT VALID;


--
-- TOC entry 2960 (class 2606 OID 68575)
-- Name: Etudiant Etudiant_promotionId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Etudiant"
    ADD CONSTRAINT "Etudiant_promotionId_fkey" FOREIGN KEY ("promotionId") REFERENCES public."Promotion"(id) NOT VALID;


--
-- TOC entry 2962 (class 2606 OID 68607)
-- Name: Formateur Formateur_classeId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Formateur"
    ADD CONSTRAINT "Formateur_classeId_fkey" FOREIGN KEY ("classeId") REFERENCES public."Classe"(id);


--
-- TOC entry 2961 (class 2606 OID 68602)
-- Name: Formateur Formateur_specialiteId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Formateur"
    ADD CONSTRAINT "Formateur_specialiteId_fkey" FOREIGN KEY ("specialiteId") REFERENCES public."Specialite"(id);


--
-- TOC entry 2957 (class 2606 OID 68481)
-- Name: JournalEvenement JournalEvenement_evenementId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."JournalEvenement"
    ADD CONSTRAINT "JournalEvenement_evenementId_fkey" FOREIGN KEY ("evenementId") REFERENCES public."Evenement"(id);


--
-- TOC entry 2956 (class 2606 OID 68476)
-- Name: JournalEvenement JournalEvenement_utilisateurId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."JournalEvenement"
    ADD CONSTRAINT "JournalEvenement_utilisateurId_fkey" FOREIGN KEY ("utilisateurId") REFERENCES public."Utilisateur"(id);


--
-- TOC entry 2955 (class 2606 OID 68454)
-- Name: Pointage Pointage_utilisateurId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Pointage"
    ADD CONSTRAINT "Pointage_utilisateurId_fkey" FOREIGN KEY ("utilisateurId") REFERENCES public."Utilisateur"(id);


--
-- TOC entry 2954 (class 2606 OID 68562)
-- Name: Utilisateur Utilisateur_roleId_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public."Utilisateur"
    ADD CONSTRAINT "Utilisateur_roleId_fkey" FOREIGN KEY ("roleId") REFERENCES public."Role"(id) NOT VALID;


-- Completed on 2021-12-16 10:36:16

--
-- PostgreSQL database dump complete
--

