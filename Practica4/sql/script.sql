--Crear un usuario de nombre root, el cual pueda ignorar todos los verifi-
--cadores de permiso.
CREATE ROLE root WITH SUPERUSER LOGIN;

--Crear un tablespace de nombre ’asociacionts’ en la siguiente ubicación:
--/fbd/asociacion/data/, el propietario debe ser el usuario creado en el punto
--anterior.
CREATE TABLESPACE asociacionts OWNER root LOCATION '/fbd/asociacion/data';

-- Crear un usuario que únicamente pueda crear bases de datos.
CREATE ROLE usercreatedb WITH CREATEDB;

-- Crear una base de datos de nombre asociacion.
CREATE DATABASE asociacion;

-- Crear un usuario para la base de datos asociacion al que se le permita 
-- únicamente conectarse a la base de datos.
CREATE ROLE asociacion LOGIN;

-- root debe tener todos los provilegios
GRANT ALL PRIVILEGES ON asociacion TO root;

-- asociacion solamente tiene privilegios de lectura
GRANT CONNECT ON asociacion to asociacion;

-- Crear un esquema con cuyo nombre debe ser FBD2021-1- seguido de los
-- últimos cuatro números de cuenta del alumno que envía la práctica. Ejem-
-- plo: FBD2021-1-5669. El esquema debe pertenecer a la base de datos an-
-- teriormente creada.
\connect asociacion;
CREATE SCHEMA FBD2021_1_1625;