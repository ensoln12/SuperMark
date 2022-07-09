use Clientes;
drop table clientes;
create table Clientes(
idCliente int primary key auto_increment not null,
fecha date not null,
nombre varchar(25) not null,
apellido varchar(25) not null,
dni varchar (8) not null,
telefono varchar (12) not null,
domicilio varchar (40) not null,
email varchar(30) not null,
clave varchar(12) not null,
legajo varchar(5) null 
);
UPDATE Clientes SET legajo="17622" WHERE idCliente=1;

create table Ventas(
idVenta int auto_increment primary key,
fecha timestamp not null,
idCliente int,
foreign key(idCliente) references Clientes(idCliente)
);

create table detalle_venta(
idVenta int,
idProductos int,
cantidad int,
foreign key (idVenta) references Ventas (idVenta),
foreign key (idProductos) references Productos (idProductos)
);

use Usuarios;
drop table usuarios;
create table Usuarios(
email varchar(30) not null,
clave varchar(12) not null
);


use Productos;
drop table Productos;
create table Productos (
idProductos int primary key auto_increment not null,
fecha timestamp not null,
nombre varchar(25) not null,
marca varchar(25) not null,
categoria varchar(25) not null,
descripcion varchar(25) not null,
precio decimal (10,2) not null,
stock int not null,
costo decimal (10,2) not null
);

insert into Productos(fecha,nombre,marca,categoria,descripcion,precio,stock,costo)values(Now(),"semola","marollo","almacen","1kg",90,6,70);

