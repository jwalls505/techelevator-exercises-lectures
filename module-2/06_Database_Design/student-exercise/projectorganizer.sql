DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS project_employee;
BEGIN TRANSACTION;
CREATE TABLE department (
       department_id integer,
       department_name varchar(64) NOT NULL,
       CONSTRAINT pk_department_id PRIMARY KEY(department_id),
       CONSTRAINT ck_department_name CHECK (department_name IN('R&D', 'Eating', 'Sleeping')
 
));
   
CREATE TABLE employee (
       employee_id serial,
       job_title varchar(64) NOT NULL,
       last_name varchar(64) NOT NULL,
       first_name varchar(64) NOT NULL,
       gender varchar(10),
       date_of_birth date NOT NULL,
       date_of_hire date NOT NULL,
       department_id integer NOT NULL,
       CONSTRAINT pk_employee_id PRIMARY KEY(employee_id),
       CONSTRAINT fk_department_id FOREIGN KEY(department_id) REFERENCES department
);
CREATE TABLE project (
       project_id integer,
       project_name varchar(64) NOT NULL,
       project_start date NOT NULL,
       CONSTRAINT pk_project_id PRIMARY KEY(project_id)
);

CREATE TABLE project_employee (
       project_id integer,
       employee_id integer,
       CONSTRAINT pk_project_id_employee_id PRIMARY KEY (project_id, employee_id)
);
INSERT INTO project_employee(project_id, employee_id)
VALUES (1,1),
       (1,3),
       (1,7);      
INSERT INTO project_employee(project_id, employee_id)
VALUES (2,1),
       (2,3),
       (2,7);
INSERT INTO project_employee(project_id, employee_id)
VALUES (3,4),
       (3,5),
       (3,6);
INSERT INTO project_employee(project_id, employee_id)
VALUES (4,1),
       (4,2),
       (4,8);
INSERT INTO project_employee(project_id, employee_id)
VALUES (5,1),
       (5,2),
       (5,3),
       (5,4),
       (5,5),
       (5,6),
       (5,7),
       (5,8);        

INSERT INTO department (department_id, department_name)
VALUES  (1, 'R&D'),
        (2, 'Eating'),
        (3, 'Sleeping');
              
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (1, 'Research Asst.', 'Pawz', 'Tinkle', 'F','01-23-1989','04-25-2016', 1);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (2, 'Customer Service Account Manager', 'McLicks', 'Frank', 'M','03-13-1976','04-12-2008', 2);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (3, 'Taste Specialist', 'Fluffynutter', 'Florence', 'F','01-23-1981','08-04-2015', 2);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (4, 'Sleep Specialist', 'Walls', 'Parkour', 'M','05-23-2015','06-12-2020', 3);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (5, 'Sleep Specialist', 'Walls', 'Furry', 'M','06-13-2015','9-5-2020', 3);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (6, 'Sleep Manager', 'Walls', 'Tempo', 'M','07-23-2017','10-25-2020', 3);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (7, 'Research Lead', 'Walls', 'Ember', 'F','03-23-2018','11-25-2020', 1);
INSERT INTO employee(employee_id,job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_id) VALUES (8, 'Sales Accountant', 'Walls', 'O''Malley', 'M','07-23-2019','12-13-2020', 1);

INSERT INTO project (project_id, project_name, project_start)
VALUES (1, 'Wet FOOD', '02-22-1999'),
       (2, 'DRY food', '01-13-2001'),
       (3, 'ZZZZZ', '10-31-1997'),
       (4, 'Lick TECHNIQUE', '01-23-2005'),
       (5, 'World Domination', '01-01-1999');
       

ROLLBACK;
COMMIT;
ALTER TABLE project_employee ADD FOREIGN KEY(employee_id) REFERENCES employee;
ALTER TABLE project_employee ADD FOREIGN KEY(project_id) REFERENCES project;