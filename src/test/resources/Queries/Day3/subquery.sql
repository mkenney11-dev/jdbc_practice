SELECT * FROM EMPLOYEES;

--dispaly all information for those making maximum salary

SELECT MAX(SALARY) FROM EMPLOYEES;
SELECT *
FROM EMPLOYEES
WHERE SALARY =24000;

--dynamic answer
SELECT *
FROM EMPLOYEES
WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEES);

--display all information for those making the minimum salary
SElECT *
FROM EMPLOYEES
WHERE SALARY =(SELECT MIN(SALARY) FROM EMPLOYEES);

--COMMON INTERVIEW QUESTION-- display all information for the employee with second highest salary
SELECT MAX(SALARY) FROM EMPLOYEES;

SELECT MAX(SALARY)
FROM EMPLOYEES
WHERE SALARY <24000;

SELECT *
FROM EMPLOYEES
WHERE SALARY =17000;

--MAKE IT DYNAMIC

SELECT *
FROM EMPLOYEES
WHERE SALARY = (SELECT MAX(SALARY)
                FROM EMPLOYEES
                WHERE SALARY < (SELECT MAX(SALARY)
                                FROM EMPLOYEES));


--DISPLAY all informaiton of employees who are making more than average salary

SELECT *
FROM EMPLOYEES
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                FROM EMPLOYEES);