create schema db;
DROP TABLE IF EXISTS Teacher;

CREATE TABLE Teacher (
Id int AUTO_INCREMENT,
FirstName varchar(100) NOT NULL,
lastName varchar(100) NOT NULL,
age int NULL,
PRIMARY KEY(Id)
); 

SELECT * FROM Teacher;
INSERT INTO Teacher(FirstName, lastName, age)
VALUES('John', 'Doe', 36);

INSERT INTO Teacher(FirstName, lastName, age)
VALUES('Jane', 'Doe', 32);

INSERT INTO Teacher(FirstName, lastName, age)
VALUES('Mary', 'Boo', 67);

INSERT INTO Teacher(FirstName, lastName, age)
VALUES('Steve', 'Wallace', 54);

UPDATE Teacher
SET lastName = 'Parker'
WHERE Id = 3; 

UPDATE Teacher
SET firstName = 'Steve'
WHERE Id = 4; 

ALTER TABLE Teacher DROP COLUMN age; 
SELECT * FROM Teacher;



