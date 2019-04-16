CREATE DATABASE IF NOT EXISTS lab01DB;
USE lab01DB;

CREATE TABLE Estudiante (
    Cedula CHAR(9),
    Carne CHAR(6) NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Apellido VARCHAR(30) NOT NULL,
    CONSTRAINT PK_Estudiante PRIMARY KEY (Cedula),
    CONSTRAINT UC_Estudiante UNIQUE (Carne)
);

CREATE TABLE Libro (
    Isbn CHAR(13),
    Titulo VARCHAR(255) NOT NULL,
    Anno YEAR(4),
    Edicion INT,
    Editorial VARCHAR(30),
    CONSTRAINT PK_Libro PRIMARY KEY (Isbn)
);

CREATE TABLE Autor (
    Nombre VARCHAR(61),
    CONSTRAINT PK_Autor PRIMARY KEY (Nombre)
);

CREATE TABLE Escrito_por (
    Isbn CHAR(13),
    Autor VARCHAR(61),
    CONSTRAINT PK_Escrito_por PRIMARY KEY (Isbn, Autor),
    FOREIGN KEY (Isbn) REFERENCES Libro(Isbn),
    FOREIGN KEY (Autor) REFERENCES Autor(Nombre)
);
