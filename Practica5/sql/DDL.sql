
--ALTER ROLE desarrollador SET SCHEMA 'desarrollo';
--Cambiamos configuracion de clientes
SET statement_timeout = 0; 						--abortar si alguna operacion tarda mas de n milisegundos
SET lock_timeout = 0;      						-- bloquear objeto manipulado si operación tarda mas de n milisegundos
SET client_encoding = 'UTF8'; 				-- codificacion que utiliza el client_encoding
SET client_min_messages = warning;    -- nivel de logs
SET DateStyle = ISO;                  -- formato de fechas por default YYYY-MM-DD HH:MM:SS
SET TIME ZONE LOCAL ;                 --timezone SELECT CURRENT_TIMESTAMP AS hoy;

CREATE TABLE "fbd2021_1_1625".usuario(
	"id_persona" SERIAL GENERATED ALWAYS AS IDENTITY NOT NULL,
	"nombre" VARCHAR(15) NOT NULL,
	"paterno" VARCHAR(15) NOT NULL,
	"materno" VARCHAR(15) NOT NULL,
	"calle" VARCHAR(30)  NULL,
	"numero_calle" INTEGER  NULL,
	"colonia" VARCHAR(30)  NULL,
	"correo" VARCHAR(30)  NULL,
	"numero_celular" VARCHAR(10) NULL,
	"institucion" VARCHAR(30) NOT NULL,
	"es_alumno" BOOLEAN NOT NULL,
	"es_academico" BOOLEAN NOT NULL,
	"es_trabajador" BOOLEAN NOT NULL,
	"path_fotografia" BYTEA NOT NUll,
	CONSTRAINT "pk_usuario" PRIMARY KEY("id_persona")

);

CREATE TABLE "fbd2021_1_1625".horario(
	"id_horario" SERIAL GENERATED ALWAYS AS IDENTITY NOT NULL,
	"id_persona" INTEGER NOT NULL,
	"entrada" TIME NOT NULL,
	"salida" TIME NOT NULL,
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

CREATE TABLE "fbd2021_1_1625".asociado(
	  "id_persona" SERIAL GENERATED ALWAYS AS IDENTITY NOT NULL,
	  "numlicencia" INTEGER NOT NULL,
	  "fechaingreso" TIME NOT NULL,
	  "rfc" VARCHAR(30) NOT NULL,
	  "fotografia" BYTEA NOT NULL,
	  "nombre" VARCHAR(30) NOT NULL,
	  "paterno" VARCHAR(30) NOT NULL,
	  "materno" VARCHAR(30) NOT NULL,
	  "calle" VARCHAR(30) NOT NULL,
	  "numero" INTEGER NOT NULL,
	  "colonia" VARCHAR(30) NOT NULL,
	  "correo" VARCHAR(30) NOT NULL,
	  "numerocelular" INTEGER NOT NULL,
	  "es_chofer" BOOLEAN NOT NULL,
	  "es_duenio" BOOLEAN NOT NULL,
	  CONSTRAINT "pk_persona" PRIMARY KEY
		(
			"id_persona"
		)
);

CREATE TABLE "fbd2021_1_1625".taxi(
	"placa" VARCHAR(7) NOT NUll,
	"id_persona" SERIAL NOT NULL,
	"modelo" VARCHAR(20) NOT NULL,
	"marca" VARCHAR(20) NOT NULL,
	"anio" SMALLINT NOT NULL, 
	"no_cilindros" SMALLINT NOT NULL CHECK(no_cilindros > 0),
	"no_puertas" SMALLINT NOT NULL CHECK(no_puertas > 1),
	CONSTRAINT "pk_taxi" PRIMARY KEY("placa", "id_persona"),
	CONSTRAINT "pk_idpersona" FOREIGN KEY ("id_persona") 
	REFERENCES "fbd2021_1_1625".asociado("id_persona")
	);

CREATE TABLE "fbd2021_1_1625".estado(
	"id_estado" SERIAL GENERATED ALWAYS AS IDENTITY,
	"placa" VARCHAR(7),
	"id_persona" INTEGER,
	"razon" TEXT,
	"activo" BOOLEAN,
	CONSTRAINT "pk_idestado" PRIMARY KEY("id_estado"),
	CONSTRAINT "fk_placa" FOREIGN KEY("placa") REFERENCES "fbd2021_1_1625".taxi("placa"),
	CONSTRAINT "pk_idpersona" FOREIGN KEY("id_persona") REFERENCES "fbd2021_1_1625".asociado("id_persona")
	);
	
CREATE TABLE "fbd2021_1_1625".viaje(
	"id_viaje" INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
	"placa" VARCHAR(7) NOT NULL,
	"cantidad_usuarios" VARCHAR(4) NOT NULL,
	"destino" VARCHAR(255) NOT NULL,
	"distancia" INTEGER NOT NULL,
	"costo" MONEY NOT NULL,
	"tiempo" INTEGER NOT NULL,
	CONSTRAINT "pk_viaje" PRIMARY KEY("id_viaje"),
	CONSTRAINT "fk_placas_viaje" FOREIGN KEY("placa") REFERENCES "fbd2021_1_1625".taxi("placa")
);

CREATE TABLE "fbd2021_1_1625".tomar(
	"id_persona" INTEGER NOT NULL,
	"id_viaje" INTEGER NOT NULL,
	CONSTRAINT "pk_tomar" PRIMARY KEY ("id_persona", "id_viaje"),
  	CONSTRAINT "fk_persona" FOREIGN KEY ("id_persona") REFERENCES "fbd2021_1_1625".usuario ("id_persona"),
  	CONSTRAINT "fk_viaje" FOREIGN KEY ("id_viaje") REFERENCES "fbd2021_1_1625".viaje ("id_viaje")
);