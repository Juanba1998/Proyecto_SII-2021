CREATE TABLE ALUMNO (ID INTEGER NOT NULL, ALUMNOMOVILIDAD BOOLEAN, CODIGOPOSTAL INTEGER, DNI VARCHAR UNIQUE, DIRECCION VARCHAR, EMAIL_INSTITUCIONAL VARCHAR NOT NULL, EMAIL_PERSONAL VARCHAR, LOCALIDAD VARCHAR, MOVIL INTEGER, NOMBRE_COMPLETO VARCHAR NOT NULL, PROVINCIA VARCHAR, TELEFONO INTEGER, GRUPOS_ASIGNADOS LONGVARBINARY, LOGIN_CODIGO INTEGER, PRIMARY KEY (ID))
CREATE TABLE ASIGNATURA (REFERENCIA INTEGER NOT NULL, DTYPE VARCHAR(31), CARACTER VARCHAR, CODIGO INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, CUATRIMESTRE VARCHAR, CURSO VARCHAR, DURACION VARCHAR, IDIOMAS_DE_IMPARTICION VARCHAR, NOMBRE VARCHAR NOT NULL, OFERTADA INTEGER NOT NULL, ASIGNATURAS_TITULACION_CODIGOTITULACION INTEGER, PRIMARY KEY (REFERENCIA))
CREATE TABLE ASIGNATURAS_MATRICULA (ASIGNATURA_REFERENCIA INTEGER NOT NULL, GRUPO_ID INTEGER, CURSO_ACADEMICO VARCHAR NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE INTEGER NOT NULL, PRIMARY KEY (ASIGNATURA_REFERENCIA, CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE))
CREATE TABLE CENTRO (ID INTEGER NOT NULL, DIRECCION VARCHAR NOT NULL, NOMBRE VARCHAR UNIQUE, TLF_CONSERJERIA INTEGER, PRIMARY KEY (ID))
CREATE TABLE CLASE (DIA TIMESTAMP NOT NULL, HORAINICIO TIMESTAMP NOT NULL, HORAFIN TIMESTAMP, ASIGNATURA_REFERENCIA INTEGER, GRUPO_ID INTEGER NOT NULL, PRIMARY KEY (DIA, HORAINICIO, GRUPO_ID))
CREATE TABLE ENCUESTA (FECHA_DE_ENVIO DATE NOT NULL, EXPEDIENTE_NUM_EXPEDIENTE INTEGER, PRIMARY KEY (FECHA_DE_ENVIO))
CREATE TABLE EXPEDIENTES (NUM_EXPEDIENTE INTEGER NOT NULL, ACTIVO BOOLEAN, CREDITOS_CF INTEGER, CREDITOS_FB INTEGER, CREDITOS_OB INTEGER, CREDITOS_OP INTEGER, CREDITOS_PE INTEGER, CREDITOS_TF INTEGER, CREDITOS_SUPERADOS INTEGER, NOTA_MEDIA_PROVISIONAL DOUBLE, ALUMNO_ID INTEGER, TITULACION_CODIGOTITULACION INTEGER, PRIMARY KEY (NUM_EXPEDIENTE))
CREATE TABLE GRUPO (ID INTEGER NOT NULL, ASIGNAR VARCHAR, CURSO VARCHAR UNIQUE, INGLES BOOLEAN NOT NULL, LETRA VARCHAR UNIQUE, PLAZAS INTEGER, TURNO_MANANA_TARDE VARCHAR NOT NULL, VISIBLE BOOLEAN, ID_GRUPO_ID INTEGER, TITULACION_CODIGOTITULACION INTEGER, PRIMARY KEY (ID))
CREATE TABLE GRUPO_POR_ASIGNATURA (CURSO_ACADEMICO VARCHAR NOT NULL, OFERTA VARCHAR, ASIGNATURA_REFERENCIA INTEGER NOT NULL, GRUPO_ID INTEGER NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID))
CREATE TABLE LOGIN (CODIGO INTEGER NOT NULL, CONTRASENA VARCHAR NOT NULL, USUARIO VARCHAR NOT NULL UNIQUE, ESALUMNO BOOLEAN NOT NULL, ALUMNO_ID INTEGER, PRIMARY KEY (CODIGO))
CREATE TABLE MATRICULA (CURSO_ACADEMICO VARCHAR NOT NULL, ESTADO VARCHAR NOT NULL, FECHA_DE_MATRICULA VARCHAR NOT NULL, LISTADO_ASIGNATURAS VARCHAR, NUEVO_INGRESO BOOLEAN, NUM_ARCHIVO INTEGER, TURNO_PREFERENTE VARCHAR, EXPEDIENTE_NUM_EXPEDIENTE INTEGER NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE))
CREATE TABLE OPTATIVAS (REFERENCIA INTEGER NOT NULL, MENCION VARCHAR, PLAZAS INTEGER, PRIMARY KEY (REFERENCIA))
CREATE TABLE SOLICITUD (CODIGO INTEGER NOT NULL, DESCRIPCION VARCHAR NOT NULL, FECHASOLICITUD TIMESTAMP NOT NULL, ALUMNO_ID INTEGER, PRIMARY KEY (CODIGO))
CREATE TABLE TITULACION (CODIGOTITULACION INTEGER NOT NULL, CREDITOS INTEGER NOT NULL, NOMBRE VARCHAR NOT NULL, PRIMARY KEY (CODIGOTITULACION))
CREATE TABLE Titulacion_Centro (cen_fk INTEGER NOT NULL, titu_fk INTEGER NOT NULL, PRIMARY KEY (cen_fk, titu_fk))
CREATE TABLE GRUPO_POR_ASIGNATURA_ENCUESTA (encuesta_FECHA_DE_ENVIO DATE NOT NULL, CURSO_ACADEMICO VARCHAR NOT NULL, ASIGNATURA_REFERENCIA INTEGER NOT NULL, GRUPO_ID INTEGER NOT NULL, PRIMARY KEY (encuesta_FECHA_DE_ENVIO, CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID))
ALTER TABLE ALUMNO ADD CONSTRAINT FK_ALUMNO_LOGIN_CODIGO FOREIGN KEY (LOGIN_CODIGO) REFERENCES LOGIN (CODIGO)
ALTER TABLE ASIGNATURA ADD CONSTRAINT ASIGNATURA_ASIGNATURAS_TITULACION_CODIGOTITULACION FOREIGN KEY (ASIGNATURAS_TITULACION_CODIGOTITULACION) REFERENCES TITULACION (CODIGOTITULACION)
ALTER TABLE ASIGNATURAS_MATRICULA ADD CONSTRAINT FK_ASIGNATURAS_MATRICULA_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE ASIGNATURAS_MATRICULA ADD CONSTRAINT FK_ASIGNATURAS_MATRICULA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES MATRICULA (CURSO_ACADEMICO, EXPEDIENTE_NUM_EXPEDIENTE)
ALTER TABLE ASIGNATURAS_MATRICULA ADD CONSTRAINT FK_ASIGNATURAS_MATRICULA_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE ENCUESTA ADD CONSTRAINT FK_ENCUESTA_EXPEDIENTE_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTES (NUM_EXPEDIENTE)
ALTER TABLE EXPEDIENTES ADD CONSTRAINT FK_EXPEDIENTES_TITULACION_CODIGOTITULACION FOREIGN KEY (TITULACION_CODIGOTITULACION) REFERENCES TITULACION (CODIGOTITULACION)
ALTER TABLE EXPEDIENTES ADD CONSTRAINT FK_EXPEDIENTES_ALUMNO_ID FOREIGN KEY (ALUMNO_ID) REFERENCES ALUMNO (ID)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_TITULACION_CODIGOTITULACION FOREIGN KEY (TITULACION_CODIGOTITULACION) REFERENCES TITULACION (CODIGOTITULACION)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_ID_GRUPO_ID FOREIGN KEY (ID_GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPO_POR_ASIGNATURA_GRUPO_ID FOREIGN KEY (GRUPO_ID) REFERENCES GRUPO (ID)
ALTER TABLE GRUPO_POR_ASIGNATURA ADD CONSTRAINT FK_GRUPO_POR_ASIGNATURA_ASIGNATURA_REFERENCIA FOREIGN KEY (ASIGNATURA_REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE LOGIN ADD CONSTRAINT FK_LOGIN_ALUMNO_ID FOREIGN KEY (ALUMNO_ID) REFERENCES ALUMNO (ID)
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_EXPEDIENTE_NUM_EXPEDIENTE FOREIGN KEY (EXPEDIENTE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTES (NUM_EXPEDIENTE)
ALTER TABLE OPTATIVAS ADD CONSTRAINT FK_OPTATIVAS_REFERENCIA FOREIGN KEY (REFERENCIA) REFERENCES ASIGNATURA (REFERENCIA)
ALTER TABLE SOLICITUD ADD CONSTRAINT FK_SOLICITUD_ALUMNO_ID FOREIGN KEY (ALUMNO_ID) REFERENCES ALUMNO (ID)
ALTER TABLE Titulacion_Centro ADD CONSTRAINT FK_Titulacion_Centro_cen_fk FOREIGN KEY (cen_fk) REFERENCES CENTRO (ID)
ALTER TABLE Titulacion_Centro ADD CONSTRAINT FK_Titulacion_Centro_titu_fk FOREIGN KEY (titu_fk) REFERENCES TITULACION (CODIGOTITULACION)
ALTER TABLE GRUPO_POR_ASIGNATURA_ENCUESTA ADD CONSTRAINT FK_GRUPO_POR_ASIGNATURA_ENCUESTA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID) REFERENCES GRUPO_POR_ASIGNATURA (CURSO_ACADEMICO, ASIGNATURA_REFERENCIA, GRUPO_ID)
ALTER TABLE GRUPO_POR_ASIGNATURA_ENCUESTA ADD CONSTRAINT GRUPOPORASIGNATURA_ENCUESTAencuesta_FECHA_DE_ENVIO FOREIGN KEY (encuesta_FECHA_DE_ENVIO) REFERENCES ENCUESTA (FECHA_DE_ENVIO)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
