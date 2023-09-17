SELECT * FROM EMPLOYEES;

SELECT DEPARTMENT_ID, ROUND(AVG(SALARY)) as Average_salary
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >6000;

--manager is asking to display annual salary for all employess as annual_salary

SELECT FIRST_NAME, SALARY*12 as annual_salary9
FROM EMPLOYEES;

-- I want to get fullname column where we have firstname+ " " + lastname
--essentailly concatenating

SELECT FIRST_NAME||' '||LAST_NAME as full_name
FROM EMPLOYEES;

--add @cydeo.com to all the emails in teh employee table
-- there are two ways to concatenate, manually or with concat method
SELECT EMAIL||'@cydeo.com' FROM EMPLOYEES;
SELECT concat(EMAIL,'@cydeo.com') FROM EMPLOYEES;

--can change to lowercase
SELECT lower(EMAIL|| '@cydeo.com') FROM EMPLOYEES;
--to uppercase
SELECT upper(EMAIL || '@cydeo.com') FROM EMPLOYEES;

--INITCAP method will capitalize the first letter
--LENGTH
select  EMAIL, length(email) FROM EMPLOYEES;

--display all employees where firstname lenght equals 6
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE length(FIRST_NAME) = 6;

--OR
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '______';

--DISPLAY initials from firstname and lastname
--SUBSTR(columnNAMe, beginningIndex, numberOfChar)

SELECT substr(FIRST_NAME, 0, 1)||'.'||substr(LAST_NAME, 0, 1)||'.' as initials
FROM EMPLOYEES