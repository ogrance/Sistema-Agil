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
    project_id INT NOT NULL UNIQUE,
    nombre VARCHAR(30),
    PRIMARY KEY(id_backlog, project_id)
);

ALTER TABLE backlogs
	ADD FOREIGN KEY (project_id)
	REFERENCES projects(id)
	ON DELETE CASCADE
;


CREATE TABLE IF NOT EXISTS sprints
(
	id_sprint INT NOT NULL AUTO_INCREMENT,
	project_id INT NOT NULL,
	name VARCHAR(100) NOT NULL,
	duration VARCHAR(100) NULL,
	estatus VARCHAR(10),
	PRIMARY KEY(id_sprint,project_id)
);

ALTER TABLE sprints
	ADD FOREIGN KEY (project_id) REFERENCES projects(id) 
	ON DELETE CASCADE
;

CREATE TABLE IF NOT EXISTS user_stories
(
	id_us INT NOT NULL AUTO_INCREMENT,
	backlog_id INT NOT NULL,
	project_id INT NOT NULL,
	sprint_id INT NULL,
	descripcion VARCHAR(100),
	estatus VARCHAR(10) DEFAULT 'TO-DO' NOT NULL,
	PRIMARY KEY(id_us, backlog_id, project_id)
);

ALTER TABLE user_stories
	ADD FOREIGN KEY (backlog_id)
	REFERENCES backlogs(id_backlog)
	ON DELETE CASCADE
;

ALTER TABLE user_stories
	ADD FOREIGN KEY (project_id)
	REFERENCES projects(id)
	ON DELETE CASCADE
;

ALTER TABLE user_stories
	ADD FOREIGN KEY (sprint_id) REFERENCES sprints(id_sprint)
;





--insercion de usuarios
INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('1', 'Victor', 'Victor', 'Basaldua', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('2', 'Juan', 'Juan', 'Grance', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('3', 'Dorys', 'Dorys', 'Almeida', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('4', 'Hernan', 'Hernan', 'Pereira', '123', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('5', 'Lilian', 'Lilian', 'Riveros', '456', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('6', 'Lili', 'Lili', 'Demattei', '456', 'e');

INSERT INTO `db_ingsofdos`.`usuario` (`idUsuario`, `nombreUsuario`, `nombre`, `apellido`, `passwrd`, `status`) VALUES ('7', 'Sebastian', 'Sebastian', 'Fernandez', '456', 'e');