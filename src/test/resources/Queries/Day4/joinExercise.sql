SELECT * FROM EMPLOYEES;


--1. Display all first_name and related department_name

SELECT FIRST_NAME, E.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--Order the list based on teh fristname asc
SELECT FIRST_NAME, E.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY FIRST_NAME ASC;


--2. Display all first_name and related department_name including the employee without a department

SELECT FIRST_NAME, E.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--3. Display all first_name and department_name including department without employees

SELECT FIRST_NAME, E.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E RIGHT JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--4. How many employees do we have for each department_name
SELECT DEPARTMENT_NAME, COUNT(*)
FROM EMPLOYEES E JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY DEPARTMENT_NAME;

--5. Display all firstname and departmentname including department wihtout employees and employee without department
SELECT FIRST_NAME, E.DEPARTMENT_ID, DEPARTMENT_NAME
FROM EMPLOYEES E FULL JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--6. Display all cities and country names

SELECT CITY, COUNTRY_NAME, L.COUNTRY_ID
FROM LOCATIONS L JOIN COUNTRIES C
ON L.COUNTRY_ID = C.COUNTRY_ID;

--7. Display all cities and related country names including countries without a city

SELECT CITY, COUNTRY_NAME, L.COUNTRY_ID
FROM LOCATIONS L RIGHT JOIN COUNTRIES C
ON L.COUNTRY_ID = C.COUNTRY_ID;

--8. Display all department names and all related street addresses
SELECT DEPARTMENT_NAME, D.LOCATION_ID, L.LOCATION_ID, STREET_ADDRESS
FROM DEPARTMENTS D JOIN LOCATIONS L
on D.LOCATION_ID = L.LOCATION_ID;

--9. Display firstname, lastname, and departmentname. city for all employees
SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_NAME, CITY, COUNTRY_NAME, REGION_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
JOIN LOCATIONS L on D.LOCATION_ID = L.LOCATION_ID
JOIN COUNTRIES C2 on L.COUNTRY_ID = C2.COUNTRY_ID
JOIN REGIONS R on C2.REGION_ID = R.REGION_ID;

--10. How many employees are working for each countryname?
SELECT COUNTRY_NAME, COUNT(*)
FROM EMPLOYEES E JOIN DEPARTMENTS D
on E.DEPARTMENT_ID = D.DEPARTMENT_ID
JOIN LOCATIONS L on D.LOCATION_ID = L.LOCATION_ID
JOIN COUNTRIES C2 on L.COUNTRY_ID = C2.COUNTRY_ID
JOIN REGIONS R on C2.REGION_ID = R.REGION_ID
GROUP BY COUNTRY_NAME;


SELECT *
FROM CUSTOMER C LEFT JOIN ADDRESS A
on C.ADDRESS_ID = A.ADDRESS_ID
WHERE A.ADDRESS_ID IS NULL;