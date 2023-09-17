



CREATE VIEW EmployeeInfo as
SELECT substr(FIRST_NAME, 0, 1)||'.'||substr(LAST_NAME, 0, 1)||'.' as initials
FROM EMPLOYEES;

DROP VIEW EmployeeInfo