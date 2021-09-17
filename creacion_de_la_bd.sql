--Creacion del esquema de la base de datos
--creacion del esquema
CREATE SCHEMA `db_ingsofdos` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
 

--creacion de las tablas
CREATE TABLE IF NOT EXISTS usuario
(
    idUsuario INT NOT NULL AUTO_INCREMENT,
    nombreUsuario VARCHAR(12) NOT NULL UNIQUE,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    passwrd VARCHAR(50) NOT NULL,
    status CHARACTER(1),
    PRIMARY KEY(idUsuario)
);

CREATE TABLE IF NOT EXISTS permissions
(
    id_perm INT NOT NULL AUTO_INCREMENT,
    perm_name VARCHAR(15) NOT NULL UNIQUE,
    scope VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_perm)
);

CREATE TABLE IF NOT EXISTS roles
(
    id_role INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(30) UNIQUE,
    PRIMARY KEY(id_role)
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY(user_id, role_id)
);

ALTER TABLE user_role
    ADD    FOREIGN KEY (user_id)
    REFERENCES usuario(idUsuario)
	ON DELETE CASCADE
;

ALTER TABLE user_role
    ADD    FOREIGN KEY (role_id)
    REFERENCES roles(id_role)
	ON DELETE CASCADE
;

CREATE TABLE IF NOT EXISTS roles_permission
(
    id_role INT NOT NULL,
    perm_id INT NOT NULL,
    PRIMARY KEY(id_role, perm_id)
);

ALTER TABLE roles_permission
    ADD    FOREIGN KEY (id_role)
    REFERENCES roles(id_role)
	ON DELETE CASCADE
;

ALTER TABLE roles_permission
    ADD    FOREIGN KEY (perm_id)
    REFERENCES permissions(id_perm)
	ON DELETE CASCADE
;

CREATE TABLE IF NOT EXISTS UserStories
(
    id_us INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50) NOT NULL,
    estatus CHARACTER(10),
    PRIMARY KEY(id_us)
);

CREATE TABLE IF NOT EXISTS sprints
(
    id INT NOT NULL AUTO_INCREMENT,
    duration VARCHAR(10) DEFAULT '2 weeks',
    id_us INT,
    estatus VARCHAR(5) DEFAULT 'TODO',
    PRIMARY KEY(id)
);

ALTER TABLE sprints
    ADD    FOREIGN KEY (id_us)
    REFERENCES UserStories(id_us)
	ON DELETE CASCADE
;

CREATE TABLE IF NOT EXISTS projects
(
    id INT NOT NULL AUTO_INCREMENT,
    project_name VARCHAR(30) NOT NULL,
    descripcion VARCHAR(30),
    estatus VARCHAR(10) DEFAULT 'PEN' NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS project_members
(
    project_id INT NOT NULL,
    user_id INT NOT NULL,
    columna INT,
    PRIMARY KEY(project_id, user_id)
);

ALTER TABLE project_members
    ADD    FOREIGN KEY (user_id)
    REFERENCES usuario(idUsuario)
	ON DELETE CASCADE
;

ALTER TABLE project_members
    ADD    FOREIGN KEY (project_id)
    REFERENCES projects(id)
	ON DELETE CASCADE
;

CREATE TABLE IF NOT EXISTS backlogs
(
    id_backlog INT NOT NULL AUTO_INCREMENT,
    project_id INT NOT NULL,
    us_id INT,
    nombre VARCHAR(15),
    commentario VARCHAR(30),
    PRIMARY KEY(id_backlog, project_id)
);

ALTER TABLE backlogs
    ADD    FOREIGN KEY (project_id)
    REFERENCES projects(id)
	ON DELETE CASCADE
;

ALTER TABLE backlogs
    ADD    FOREIGN KEY (us_id)
    REFERENCES UserStories(id_us)
	ON DELETE CASCADE
;

--insercion de usuarios
INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('1', 'Victor', 'Victor', 'Basaldua', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('2', 'Juan', 'Juan', 'Grance', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('3', 'Dorys', 'Dorys', 'Almeida', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('4', 'Hernan', 'Hernan', 'Pereira', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('5', 'Lilian', 'Lilian', 'Riveros', '456', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('6', 'Lili', 'Lili', 'Demattei', '456', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('7', 'Sebastian', 'Sebastian', 'Fernandez', '456', 'e');

--TRIGGERS
/* POR AHORA NO ES NECESARIO ejecutar estos scripts!!


--controla el borrado de las filas en la tabla user_role en caso de que un rol o un usuario se borre
CREATE TRIGGER t_b_d_usuario
AFTER DELETE ON usuario
FOR EACH ROW
DELETE FROM user_role WHERE user_id=OLD.idUsuario;

CREATE TRIGGER t_b_d_role
AFTER DELETE ON roles
FOR EACH ROW
DELETE FROM user_role WHERE role_id=OLD.id_role;

--controla el borrado de las filas en la tabla roles_permission en caso de que un rol o un usuario se borre
CREATE TRIGGER t_b_d_role_perm
AFTER DELETE ON roles
FOR EACH ROW
DELETE FROM roles_permission WHERE role_id=OLD.id_role;


CREATE TRIGGER t_b_d_perm_role
AFTER DELETE ON permissions
FOR EACH ROW
DELETE FROM roles_permission WHERE perm_id=OLD.id_perm;
*/


