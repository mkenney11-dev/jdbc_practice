SELECT * FROM EMPLOYEES;

/*
--CREATE table syntax:
    create table TableName(
        colName1 DataType Constraints,
        colName2 DataType Constraints (optional)
        colName3 DataType Constraints,
        ...
        );

 */

CREATE TABLE scrumteam(
    emp_id INTEGER PRIMARY KEY,
    first_name varchar(30) not null,
    last_name varchar(20) not null,
    job_title varchar(20),
    salary Integer
);

SELECT * FROM SCRUMTEAM;

INSERT INTO SCRUMTEAM(emp_id, first_name, last_name, job_title, salary)
VALUES(1, 'Severus', 'Snape', 'Tester', 130000);


INSERT INTO SCRUMTEAM(emp_id, first_name, last_name, job_title, salary)
VALUES(2, 'Harry', 'Potter', 'Developer', 150000);


INSERT INTO SCRUMTEAM(emp_id, first_name, last_name, job_title, salary)
VALUES(3, 'Hermoine', 'Granger', 'Scrum Master', 120000);

INSERT INTO SCRUMTEAM(emp_id, first_name, last_name, job_title, salary)
VALUES(4, 'Rubeus', 'Hagrid', 'Security', 100000);

INSERT INTO SCRUMTEAM(emp_id, first_name, last_name, job_title, salary)
VALUES(5, 'Minerva', 'McGonagal', 'Product Owner', 180000);

INSERT INTO SCRUMTEAM(emp_id, first_name, last_name, job_title, salary)
VALUES(6, 'Luna', 'Lovegood', 'Design', 135000);

commit;


--update values
/*
 UPDATE table_name
 SET column1 = value1,
column2 = value2
 WHERE condition;
 */

SELECT * FROM SCRUMTEAM;

UPDATE SCRUMTEAM
SET SALARY=SALARY+5000;

UPDATE SCRUMTEAM
SET SALARY=110000
WHERE EMP_ID=4;

commit work;

DELETE FROM SCRUMTEAM
WHERE EMP_ID = 2;

commit;

--CRUD
--CREATE (INSERT)
--READ (SELECT)
--UPDATE(UPDATE)
--DELETE (DELETE)



--add new column
ALTER TABLE SCRUMTEAM ADD GENDER varchar(10);

SELECT * FROM SCRUMTEAM;
SELECT * FROM AGILETEAM;

UPDATE SCRUMTEAM
SET GENDER='Male'
WHERE emp_id=1;


--rename the column
ALTER TABLE SCRUMTEAM RENAME COLUMN salary TO annual_salary;


--drop column
ALTER TABLE SCRUMTEAM DROP COLUMN GENDER;

--rename table
ALTER TABLE SCRUMTEAM RENAME TO agileteam;

TRUNCATE TABLE agileteam;
DROP TABLE agileteam;

