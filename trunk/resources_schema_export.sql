alter table PACIENTE drop constraint FK5B4D037164899C74
alter table TURNO drop constraint FK4C79772290DEAA0
alter table TURNO drop constraint FK4C79772207471AE
drop table DOCTOR if exists
drop table Fecha if exists
drop table HISTOGRAMA if exists
drop table Hora if exists
drop table PACIENTE if exists
drop table TURNO if exists
create table DOCTOR (DOCTOR_ID integer generated by default as identity (start with 1), apellido varchar(255), direccion varchar(255), edad integer not null, matricula integer not null, nombre varchar(255), telefono integer not null, primary key (DOCTOR_ID))
create table Fecha (DIA_ID integer generated by default as identity (start with 1), anio integer not null, mes integer not null, primary key (DIA_ID))
create table HISTOGRAMA (DIENTES_ID integer generated by default as identity (start with 1), cara varchar(255), tratamiento varchar(255), primary key (DIENTES_ID))
create table Hora (HORA_ID integer generated by default as identity (start with 1), minutos integer not null, primary key (HORA_ID))
create table PACIENTE (DOCTOR_ID integer generated by default as identity (start with 1), apellido varchar(255), direccion varchar(255), edad integer not null, nombre varchar(255), obraSocial varchar(255), telefono integer not null, histograma_DIENTES_ID integer, primary key (DOCTOR_ID))
create table TURNO (asistido bit not null, fecha_DIA_ID integer not null, hora_HORA_ID integer, primary key (fecha_DIA_ID), unique (fecha_DIA_ID))
alter table PACIENTE add constraint FK5B4D037164899C74 foreign key (histograma_DIENTES_ID) references HISTOGRAMA
alter table TURNO add constraint FK4C79772290DEAA0 foreign key (hora_HORA_ID) references Hora
alter table TURNO add constraint FK4C79772207471AE foreign key (fecha_DIA_ID) references Fecha
