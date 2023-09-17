SELECT * FROM EMPLOYEES;

--how many locations do we have for each country?

SELECT * FROM LOCATIONS;

SELECT COUNTRY_ID, COUNT(*)
FROM LOCATIONS
GROUP BY COUNTRY_ID;

--Display only US, UK, and CA

SELECT COUNTRY_ID, COUNT(*)
FROM LOCATIONS
WHERE COUNTRY_ID IN('US', 'UK', 'CA')
GROUP BY COUNTRY_ID
ORDER BY COUNTRY_ID DESC;

--DIsplay where location count is larger than 2

SELECT COUNTRY_ID, COUNT(*)
FROM LOCATIONS
GROUP BY COUNTRY_ID
HAVING COUNT(*) >2
ORDER BY COUNTRY_ID DESC;



-----------------------------------
--Display all employees salaray in following format as column naem Employee_salary
SELECT * FROM EMPLOYEES;
SELECT FIRST_NAME|| ' makes '||SALARY as Employees_salary
from EMPLOYEES;