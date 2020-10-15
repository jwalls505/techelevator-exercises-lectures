-- INSERT

-- 1. Add Klingon as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) 
VALUES  ('USA', 'Klingon', false, 1.5);

-- 2. Add Klingon as a spoken language in Great Britain
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage)
VALUES ('Klingon', 'GBR', false, 3.5);


-- UPDATE

-- 1. Update the capital of the USA to Houstonx
SELECT id FROM city WHERE name = 'Houston';

UPDATE  country
SET     capital = (SELECT id FROM city WHERE name = 'Houston')
WHERE   code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state
SELECT id FROM city WHERE name = 'Washington';

UPDATE  country
SET     capital = (SELECT id FROM city WHERE name = 'Washington'),
        headofstate = 'Sir Andrew Reid'
WHERE   code = 'USA';


-- DELETE

-- 1. Delete English as a spoken language in the USA
SELECT * FROM countrylanguage WHERE language = 'English' AND countrycode = 'USA';
DELETE FROM countrylanguage WHERE language = 'English' AND countrycode = 'USA';

-- 2. Delete all occurrences of the Klingon language 
SELECT * FROM countrylanguage WHERE language = 'Klingon';
DELETE FROM countrylanguage WHERE language = 'Klingon';

-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Elvish', true, 99.0);

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('ZZZ', 'English', true, 99.0);

-- 3. Try deleting the country USA. What happens?
SELECT * FROM country WHERE code = 'USA';
DELETE FROM country WHERE code = 'USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'English', true, 99.0);

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE  country
SET     continent = 'Outer Space'
WHERE   code = 'USA';


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

SELECT * FROM countrylanguage;
      
BEGIN TRANSACTION;

       DELETE FROM countrylanguage; 

ROLLBACK;

-- 2. Try updating all of the cities to be in the USA and roll it back

BEGIN TRANSACTION;

        UPDATE city
        SET countrycode = 'USA';
       
ROLLBACK;


-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.
BEGIN TRANSACTION;

        UPDATE city
        SET countrycode = 'USA';
        
ROLLBACK;

BEGIN TRANSACTION;
        UPDATE country SET headofstate = 'Sir Andrew Reid' WHERE code = 'USA';
COMMIT;

select headofstate from country  WHERE code = 'USA';

 UPDATE country SET headofstate = 'George W. Bush' WHERE code = 'USA';


CREATE TABLE country (
        code CHARACTER(3) NOT NULL, 
        name CHARACTER VARYING(64) NOT NULL, 
        continent CHARACTER VARYING(64) NOT NULL, 
        region CHARACTER VARYING(64) NOT NULL, 
        surfacearea REAL NOT NULL, 
        indepyear SMALLINT, 
        population INTEGER NOT NULL, 
        lifeexpectancy REAL, 
        gnp NUMERIC(10,2), 
        gnpold NUMERIC(10,2), 
        localname CHARACTER VARYING(64) NOT NULL,
        governmentform CHARACTER VARYING(64) NOT NULL, 
        headofstate CHARACTER VARYING(64), 
        capital INTEGER, 
        code2 CHARACTER(2) NOT NULL, 

        CONSTRAINT pk_country_code PRIMARY KEY (code), 
        CONSTRAINT country_capital_fkey FOREIGN KEY (capital) REFERENCES "city" ("id"), 
        CONSTRAINT country_continent_check CHECK (((continent)::text = 'Asia'::text) OR ((continent)::text = 'Europe'::text) OR ((continent)::text = 'North America'::text) OR ((continent)::text = 'Africa'::text) OR ((continent)::text = 'Oceania'::text) OR ((continent)::text = 'Antarctica'::text) OR ((continent)::text = 'South America'::text))
);
