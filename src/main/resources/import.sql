# insertar los roles que se pueden asignar
INSERT INTO rol(rol_id, name) VALUES (1, 'ADMINISTRADOR');
INSERT INTO rol(rol_id, name) VALUES (2, 'CONDUCTOR');

# insertar el usuario/empleado del administrador
INSERT INTO empleados(id, celular, correo, direccion, dni, nombre, num_licencia, sexo, enabled, password, username)
VALUES(1, '123456789', 'admin@gmail.com', 'Mz.Lt.Coop.Av.', '12345678', 'Sr. Admin', 'Q12345678', 'MASCULINO', 1, '$2a$12$QzBlde4bDkC2/8cU.D0yJOrCRcctzOpkHlz2jRPEPmEirZRQjpKzi', 'admin');

# asignar el rol Administrador al usuario creado
INSERT INTO user_rol(id_user, rol_id) VALUES(1,1);