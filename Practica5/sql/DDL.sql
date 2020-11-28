
--ALTER ROLE desarrollador SET SCHEMA 'desarrollo';
--Cambiamos configuracion de clientes
SET statement_timeout = 0; 						--abortar si alguna operacion tarda mas de n milisegundos
SET lock_timeout = 0;      						-- bloquear objeto manipulado si operación tarda mas de n milisegundos
SET client_encoding = 'UTF8'; 				-- codificacion que utiliza el client_encoding
SET client_min_messages = warning;    -- nivel de logs
SET DateStyle = ISO;                  -- formato de fechas por default YYYY-MM-DD HH:MM:SS
SET TIME ZONE LOCAL ;                 --timezone SELECT CURRENT_TIMESTAMP AS hoy;

CREATE TABLE "fbd2021_1_1625".usuario(
	"IdPersona" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	"Nombre" varchar(15) NOT NULL,
	"Paterno" varchar(15) NOT NULL,
	"Materno" varchar(15) NOT NULL,
	"Calle" varchar(30) NOT NULL,
	"NumeroCalle" integer NOT NULL,
	"Colonia" varchar(30) NOT NULL,
	"Correo" varchar(30) NOT NULL,
	"NumeroCelular" integer NOT NULL,
	"Institucion" varchar(30) NOT NULL,
	"EsAlumno" boolean NOT NULL,
	"EsAcademico" boolean NOT NULL,
	"EsTrabajador" boolean NOT NULL,
	"PathFotografia" boolean NOT NUll,
	CONSTRAINT "pk_usuario" PRIMARY KEY("IdPersona")

);

CREATE TABLE "fbd2021_1_1625".horario(
	"IdHorario" integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	"IdPersona" integer NOT NULL,
	"Entrada" date NOT NULL,
	"Salida" date NOT NULL,
	CONSTRAINT "pk_horario" PRIMARY KEY
	(
		"IdHorario"
	),
	CONSTRAINT "fk_usuario_horario" FOREIGN KEY
	(
		"IdPersona"
	) REFERENCES usuario (
		"IdPersona"
	) 

);