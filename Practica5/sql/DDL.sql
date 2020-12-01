
--ALTER ROLE desarrollador SET SCHEMA 'desarrollo';
--Cambiamos configuracion de clientes
SET statement_timeout = 0; 						--abortar si alguna operacion tarda mas de n milisegundos
SET lock_timeout = 0;      						-- bloquear objeto manipulado si operación tarda mas de n milisegundos
SET client_encoding = 'UTF8'; 				-- codificacion que utiliza el client_encoding
SET client_min_messages = warning;    -- nivel de logs
SET DateStyle = ISO;                  -- formato de fechas por default YYYY-MM-DD HH:MM:SS
SET TIME ZONE LOCAL ;                 --timezone SELECT CURRENT_TIMESTAMP AS hoy;

\connect asociacion

CREATE TABLE "fbd2021_1_1625".taxi(
	"placa" varchar(7) NOT NUll,
	"id_persona" int NOT NULL,
	"modelo" varchar(20) NOT NULL,
	"marca" varchar(20) NOT NULL,
	"anio" smallint NOT NULL, 
	"no_cilindros" smallint NOT NULL CHECK(no_cilindros > 0),
	"no_puertas" smallint NOT NULL CHECK(no_puertas > 1),
	CONSTRAINT "pk_taxi" PRIMARY KEY("placa"),
	CONSTRAINT "pk_idpersona" FOREIGN KEY ("id_persona") 
	REFERENCES "fbd2021_1_1625".asociado("id_persona")
	);

CREATE TABLE "fbd2021_1_1625".estado(
	"id_estado" int GENERATED ALWAYS AS IDENTITY,
	"placa" varchar(7),
	"id_persona" int,
	"razon" text,
	"activo" boolean,
	CONSTRAINT "pk_idestado" PRIMARY KEY("id_estado"),
	CONSTRAINT "fk_placa" FOREIGN KEY("placa") REFERENCES "fbd2021_1_1625".taxi("placa"),
	CONSTRAINT "pk_idpersona" FOREIGN KEY("id_persona") REFERENCES "fbd2021_1_1625".asociado("id_persona")
	);