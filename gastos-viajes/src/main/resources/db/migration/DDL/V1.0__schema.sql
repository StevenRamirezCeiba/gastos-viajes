create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table empleado (
 id int not null auto_increment,
 nombre varchar(100) not null,
 primary key (id)
);

create table gasto_viaje (
 id int not null auto_increment,
 fecha date not null,
 valor decimal(20,2) not null,
 empleado_id int not null,
 primary key (id),
 foreign key (empleado_id) references empleado(id)
);

INSERT INTO empleado(nombre) VALUES('Adam');
INSERT INTO empleado(nombre) VALUES('Bolton');
INSERT INTO empleado(nombre) VALUES('Chelsea');
INSERT INTO empleado(nombre) VALUES('Elsy');
INSERT INTO empleado(nombre) VALUES('Vincent');
INSERT INTO empleado(nombre) VALUES('Warden');

INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-01', 2000000, 1);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-02', 1000000, 1);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-01', 400000, 2);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-02', 900000, 3);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-02-03', 1100000, 2);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-02', 5100000, 6);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-02', 4000000, 4);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-02-03', 899999, 5);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-02', 59999, 3);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-02-03', 500000, 1);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-01-02', 500000, 2);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-02-03', 1100000, 6);
INSERT INTO gasto_viaje(fecha, valor, empleado_id) VALUES('2021-02-03', 1100000, 3);


