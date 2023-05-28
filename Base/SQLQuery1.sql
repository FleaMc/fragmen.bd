SELECT * FROM Entrenamientos1
SELECT * FROM Entrenamientos2
SELECT * FROM Entrenamientos3
ALTER TABLE Entrenamientos
ADD Id int identity (1,1)

Delete from Entrenamientos2 where Entrenamiento ='Maic'
Delete from Entrenamientos2 where Id ='6'
drop table Clientes
drop table Entrenamientos1
truncate table Entrenamientos1
truncate table Entrenamientos2
truncate table Entrenamientos3
drop table Entrenamientos3
drop table Entrenamientos2





















Create table Entrenamientos1(
Id int identity(1,1)  not null primary key, Entrenamiento varchar (30) ,Horario varchar (20),Equipamiento varchar(35)

);
Create table Entrenamientos2(
Id int identity(1,1) not null primary key, Entrenamiento varchar (30),Horario varchar (20),Equipamiento varchar(35)

);
Create table Entrenamientos3(
Id int identity(1,1) not null primary key, Entrenamiento varchar (30),Horario varchar (20),Equipamiento varchar(35)

);
INSERT INTO Entrenamientos1 (Entrenamiento,Horario,Equipamiento) VALUES 
('Karate','Sent','nada'),
('Pesa','Aero','nada'),
('Baile','Bail','nada')
('4','Danc','nada'),
('5','Danc','nada')

INSERT INTO Entrenamientos2 (Entrenamiento,Horario,Equipamiento) VALUES 
('1','Sent','nada'),
('2','Aero','nada'),
('3','Bail','nada'),
('4','Danc','nada'),
('5','Danc','nada')

INSERT INTO Entrenamientos3 (Entrenamiento,Horario,Equipamiento) VALUES 
('1','Sent','nada'),
('2','Aero','nada'),
('3','Bail','nada')
('4','Danc','nada'),
('5','Danc','nada')

SELECT *  
FROM Entrenamientos1  
ORDER BY Id  

select * from Entrenamientos1
drop table Clientes;

SELECT * FROM Clientes
Create table Clientes(

Numero int not null identity (1,1) primary key foreign key (Numero) REFERENCES Entrenamientos1(Id)
, Nombre varchar(30),Telefono int , FechaIngreso date , Iniciomes date ,Ruta_Foto varchar(60), Finmes date, Entrenamiento
varchar(30) 

);
