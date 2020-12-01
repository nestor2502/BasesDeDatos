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
