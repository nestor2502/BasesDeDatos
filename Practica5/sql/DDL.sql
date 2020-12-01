
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
	CONSTRAINT "fk_usuario_horario" FOREIGN KEY
	(
		"id_persona"
	) REFERENCES "fbd2021_1_1625".usuario (
		"id_persona"
	)

);

	--Creamos tabla asociado
	CREATE TABLE "fbd2021_1_1625".asociado(
	  "id_persona" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	  "numlicencia" integer NOT NULL,
	  "fechaingreso" date NOT NULL,
	  "rfc" varchar(30) NOT NULL,
	  "fotografia" bytea NOT NULL,
	  "nombre" varchar(30) NOT NULL,
	  "paterno" varchar(30) NOT NULL,
	  "materno" varchar(30) NOT NULL,
	  "calle" varchar(30) NOT NULL,
	  "numero" integer NOT NULL,
	  "colonia" varchar(30) NOT NULL,
	  "correo" varchar(30) NOT NULL,
	  "numerocelular" integer NOT NULL,
	  "es_chofer" boolean NOT NULL,
	  "es_duenio" boolean NOT NULL,
	  CONSTRAINT "pk_persona" PRIMARY KEY
		(
			"id_persona"
		)
);
