
--ALTER ROLE desarrollador SET SCHEMA 'desarrollo';
--Cambiamos configuracion de clientes
SET statement_timeout = 0; 						--abortar si alguna operacion tarda mas de n milisegundos
SET lock_timeout = 0;      						-- bloquear objeto manipulado si operación tarda mas de n milisegundos
SET client_encoding = 'UTF8'; 				-- codificacion que utiliza el client_encoding
SET client_min_messages = warning;    -- nivel de logs
SET DateStyle = ISO;                  -- formato de fechas por default YYYY-MM-DD HH:MM:SS
SET TIME ZONE LOCAL ;                 --timezone SELECT CURRENT_TIMESTAMP AS hoy;

CREATE TABLE "fbd2021_1_1625".usuario(
	"id_persona" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	"nombre" varchar(15) NOT NULL,
	"paterno" varchar(15) NOT NULL,
	"materno" varchar(15) NOT NULL,
	"calle" varchar(30)  NULL,
	"numero_calle" integer  NULL,
	"colonia" varchar(30)  NULL,
	"correo" varchar(30)  NULL,
	"numero_celular" integer NULL,
	"institucion" varchar(30) NOT NULL,
	"es_alumno" boolean NOT NULL,
	"es_academico" boolean NOT NULL,
	"es_trabajador" boolean NOT NULL,
	"path_fotografia" bytea NOT NUll,
	CONSTRAINT "pk_usuario" PRIMARY KEY("id_persona")

);

CREATE TABLE "fbd2021_1_1625".horario(
	"id_horario" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	"id_persona" integer NOT NULL,
	"entrada" date NOT NULL,
	"salida" date NOT NULL,
	CONSTRAINT "pk_horario" PRIMARY KEY
	(
		"id_horario"
	),
	CONSTRAINT "fk_ousuari_horario" FOREIGN KEY
	(
		"id_persona"
	) REFERENCES "fbd2021_1_1625".usuario (
		"id_persona"
	) 

);

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