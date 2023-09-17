SELECT * FROM EMPLOYEES
WHERE ROWNUM<11;

--display all info from employees who earn 5 highest salaries

SELECT *
FROM EMPLOYEES
ORDER BY SALARY DESC;

SELECT * FROM (SELECT *
               FROM EMPLOYEES
               ORDER BY SALARY DESC)
WHERE ROWNUM < 6;


--display all information for the 5th highest salary

SELECT MIN(SALARY) FROM (SELECT DISTINCT SALARY
                    FROM EMPLOYEES
                    ORDER BY SALARY DESC)
WHERE ROWNUM <6;

SELECT * FROM EMPLOYEES
WHERE SALARY =(SELECT MIN(SALARY) FROM (SELECT DISTINCT SALARY
                         FROM EMPLOYEES
                         ORDER BY SALARY DESC)
                                  WHERE ROWNUM <6);

--IQ How od you find who is making 37th highest salary
SELECT * FROM EMPLOYEES
WHERE SALARY =(SELECT MIN(SALARY) FROM (SELECT DISTINCT SALARY
                                        FROM EMPLOYEES
                                        ORDER BY SALARY DESC)
               WHERE ROWNUM <38);