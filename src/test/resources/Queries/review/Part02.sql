SELECT * FROM EMPLOYEES;


--1. Display full addresses from locations table in a single column
SELECT STREET_ADDRESS||', '|| CITY||', '||STATE_PROVINCE||' '|| POSTAL_CODE||' '|| COUNTRY_ID AS "FULL ADDRESS"
FROM LOCATIONS;

--2. Display all information of the employee who has the minimum salary in employees table
SELECT *
FROM EMPLOYEES
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES);

--3. Display the second minimum salary from the employees
SELECT MIN(SALARY)
FROM EMPLOYEES
WHERE SALARY > (SELECT MIN(SALARY)
                FROM EMPLOYEES);

--4. Display all information of the employee who has the second minimum salary

SELECT *
FROM EMPLOYEES
WHERE SALARY = (SELECT MIN(SALARY)
                FROM EMPLOYEES
                WHERE SALARY > (SELECT MIN(SALARY)
                                FROM EMPLOYEES));

--5. List all the employees who are making above the average salary;
SELECT *
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY)
                FROM EMPLOYEES);

--6. List all the employees who are making less than the average salary
SELECT *
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
                FROM EMPLOYEES);

--7. Display manager name of 'Neena'

SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN(SELECT MANAGER_ID
                FROM EMPLOYEES
                WHERE FIRST_NAME = 'NEENA');

--8. Find the 3rd maximum salary from the employees table (do not include duplicates)

SELECT DISTINCT SALARY
FROM EMPLOYEES
WHERE SALARY < (SELECT MAX(SALARY)
                FROM EMPLOYEES
                WHERE SALARY <(SELECT MAX(SALARY)
                               FROM EMPLOYEES));

--OR
SELECT SALARY
FROM (SELECT DISTINCT SALARY
      FROM EMPLOYEES
      ORDER BY SALARY DESC)
WHERE ROWNUM <4;

--9. Find the 5th maximum salary from the employees table (do not include duplicates)



--10. Find the 7th maximum salary from the employees table (do not include duplicates)


--11. Find the 10th maximum salary from the employees table (do not include duplicates)


--12. Find the 3rd minimum salary from the employees table (do not include duplicates)


--13. Find the 5th minimum salary from the employees table (do not include duplicates)